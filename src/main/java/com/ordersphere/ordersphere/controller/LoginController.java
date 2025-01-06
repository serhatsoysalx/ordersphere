package com.ordersphere.ordersphere.controller;

import com.ordersphere.ordersphere.dto.LoginRequestDto;
import com.ordersphere.ordersphere.dto.UserDTO;
import com.ordersphere.ordersphere.service.LoginService;
import com.ordersphere.ordersphere.util.constants.LoginErrorMessage;
import com.ordersphere.ordersphere.util.expections.InvalidCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/login")
    public ResponseEntity<UserDTO> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            UserDTO user = loginService.login(loginRequestDto);
            if (!Objects.nonNull(user)) {
                throw new InvalidCredentialsException(LoginErrorMessage.INVALID_CREDENTIALS);
            }
            return new ResponseEntity<>(user, HttpStatus.OK);
        } catch (InvalidCredentialsException ex) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);  // 400 Invalid credentials
        } catch (Exception ex) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
