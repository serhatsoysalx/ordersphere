package com.ordersphere.ordersphere.controller;

import com.ordersphere.ordersphere.dto.UserDTO;
import com.ordersphere.ordersphere.service.UserService;
import com.ordersphere.ordersphere.util.constants.ErrorMessages;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<UserDTO> registerUser(@RequestBody UserDTO userDTO) {
        try {
            var savedUser = userService.registerUser(userDTO);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        } catch (Exception ex) {
            throw new RuntimeException(ErrorMessages.OCCURRED_WHILE_CREATING_USER, ex);
        }
    }
}
