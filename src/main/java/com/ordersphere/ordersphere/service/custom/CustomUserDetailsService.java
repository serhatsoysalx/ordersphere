package com.ordersphere.ordersphere.service.custom;

import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.model.UserModel;
import com.ordersphere.ordersphere.model.custom.CustomUserDetails;
import com.ordersphere.ordersphere.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService extends GeneralService<IUserRepository> implements UserDetailsService {

    @Autowired
    public CustomUserDetailsService(IUserRepository userRepository) {
        this.repository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> userOpt = repository.findByUsername(username);

        if (userOpt.isPresent()) {
            return new CustomUserDetails(modelMapper.map(userOpt.get(), UserModel.class));
        } else {
            throw new UsernameNotFoundException("User not found: " + username);
        }
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
