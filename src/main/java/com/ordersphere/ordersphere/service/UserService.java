package com.ordersphere.ordersphere.service;

import com.ordersphere.ordersphere.dto.UserDTO;
import com.ordersphere.ordersphere.entity.User;
import com.ordersphere.ordersphere.general.GeneralService;
import com.ordersphere.ordersphere.repository.IUserRepository;
import com.ordersphere.ordersphere.util.constants.LoginErrorMessage;
import com.ordersphere.ordersphere.util.expections.UserAlreadyExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService extends GeneralService<IUserRepository> {

    @Autowired
    private RoleService roleService;

    @Transactional
    public UserDTO registerUser(UserDTO userDTO) {
        if (userExists(userDTO)) {
            throw new UserAlreadyExistsException(LoginErrorMessage.USER_ALREADY_EXISTS);
        }

        if (!roleService.existsRole(userDTO.getRoles())) {
            throw new UserAlreadyExistsException(LoginErrorMessage.ROLE_ID_NOT_FOUND);
        }
        userDTO.setPassword(encodePassword(userDTO.getPassword()));
        userDTO.setRoles(roleService.getUserRoleFromEntity(userDTO.getRoles()));
        User userEntity = modelMapper.map(userDTO, User.class);
        final User savedUser = repository.save(userEntity);
        return modelMapper.map(savedUser, UserDTO.class);
    }

    private boolean userExists(UserDTO userDTO) {
        if (userDTO.getUsername() == null || userDTO.getUsername().isEmpty() ||
                userDTO.getEmail() == null || userDTO.getEmail().isEmpty()) {
            return true;
        }
        final boolean username = repository.existsByUsername(userDTO.getUsername());
        final boolean email = repository.existsByEmail(userDTO.getEmail());
        return username || email;
    }

}
