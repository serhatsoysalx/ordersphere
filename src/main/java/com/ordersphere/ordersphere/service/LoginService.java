package com.ordersphere.ordersphere.service;

import com.ordersphere.ordersphere.dto.LoginRequestDto;
import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.entity.UserRules;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.model.UserModel;
import com.ordersphere.ordersphere.repository.IUserRepository;
import com.ordersphere.ordersphere.service.custom.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class LoginService extends GeneralService<IUserRepository> {

    @Autowired
    public LoginService(IUserRepository userRepository) {
        this.repository = userRepository;
    }

    @Autowired
    private CustomUserDetailsService userDetailsService;


    public UserModel login(LoginRequestDto loginRequestDto) {
        UserDetails user = userDetailsService.loadUserByUsername(loginRequestDto.getUsername());

        if (userDetailsService.validatePassword(loginRequestDto.getPassword(), user.getPassword())) {
            return modelMapper.map(user, UserModel.class);
        }

        return null;
    }

    public UserModel saveUser(UserModel userModel) {
        userModel.setPasswordHash(encodePassword(userModel.getPasswordHash()));
        User userEntity = modelMapper.map(userModel, User.class);

        Set<UserRules> userRules = new HashSet<>();

        if (userModel.getUserRules() != null) {
            for (var ruleDto : userModel.getUserRules()) {
                UserRules userRule = new UserRules();
                userRule.setRuleName(ruleDto.getRuleName());
                userRule.setRuleDescription(ruleDto.getRuleDescription());
                userRule.setUser(userEntity);
                userRules.add(userRule);
            }
        }
        userEntity.setUserRules(userRules);
        final User savedUser = repository.save(userEntity);
        return modelMapper.map(savedUser, UserModel.class);
    }

}
