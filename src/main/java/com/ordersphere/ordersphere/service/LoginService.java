package com.ordersphere.ordersphere.service;

import com.ordersphere.ordersphere.dto.LoginRequestDto;
import com.ordersphere.ordersphere.dto.RoleDTO;
import com.ordersphere.ordersphere.dto.UserDTO;
import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.repository.IUserRepository;
import com.ordersphere.ordersphere.service.custom.CustomUserDetailsService;
import com.ordersphere.ordersphere.util.constants.LoginErrorMessage;
import com.ordersphere.ordersphere.util.expections.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class LoginService extends GeneralService<IUserRepository> {

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    public UserDTO login(LoginRequestDto loginRequestDto) {
        final UserDetails customUser = customUserDetailsService.loadUserByUsername(loginRequestDto.getUsername());

        if (Objects.nonNull(customUser) && passwordEncoder.matches(loginRequestDto.getPassword(), customUser.getPassword())) {
            Optional<User> user = repository.findByUsername(customUser.getUsername());

            if (user.isPresent()) {
                User userEntity = user.get();
                UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);
                Set<RoleDTO> rolesDto = userEntity.getRoles().stream()
                        .map(userRoleEntity -> modelMapper.map(userRoleEntity, RoleDTO.class))
                        .collect(Collectors.toSet());
                userDTO.setRoles(rolesDto);

                return userDTO;
            }
        }

        throw new InvalidCredentialsException(LoginErrorMessage.INVALID_CREDENTIALS);
    }
}
