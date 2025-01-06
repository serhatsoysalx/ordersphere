package com.ordersphere.ordersphere.service.custom;

import com.ordersphere.ordersphere.dto.UserDTO;
import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.model.custom.CustomUserDetails;
import com.ordersphere.ordersphere.repository.IUserRepository;
import com.ordersphere.ordersphere.util.constants.LoginErrorMessage;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailsService extends GeneralService<IUserRepository> implements UserDetailsService {

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        final Optional<User> userOpt = repository.findByUsername(username);

        if (userOpt.isPresent()) {
            return new CustomUserDetails(modelMapper.map(userOpt.get(), UserDTO.class));
        } else {
            throw new UsernameNotFoundException(LoginErrorMessage.USER_NOT_FOUND + " : " + username);
        }
    }

    public boolean validatePassword(String rawPassword, String encodedPassword) {
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
