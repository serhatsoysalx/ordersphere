package com.ordersphere.ordersphere.controller;

import com.ordersphere.ordersphere.configuration.expections.InvalidCredentialsException;
import com.ordersphere.ordersphere.dto.LoginRequestDto;
import com.ordersphere.ordersphere.model.UserModel;
import com.ordersphere.ordersphere.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<UserModel> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            UserModel user = loginService.login(loginRequestDto);
            if (!Objects.nonNull(user)) {
                throw new InvalidCredentialsException("Invalid username or password");
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (InvalidCredentialsException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // 400 Invalid credentials
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/userRegistration")
    public ResponseEntity<UserModel> createUser(@RequestBody UserModel userModel) {
        try {
            var savedUser = loginService.saveUser(userModel);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);  // 201 Created
        } catch (Exception ex) {
            throw new RuntimeException("Error occurred while creating user", ex);
        }
    }

    @GetMapping("/test")
    public ResponseEntity<String> test() {
        try {
            return ResponseEntity.ok("Test");

        } catch (Exception ex) {
            throw new RuntimeException("Error occurred while creating user", ex);
        }
    }
}
