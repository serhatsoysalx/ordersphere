package com.ordersphere.ordersphere.controller;

import com.ordersphere.ordersphere.dto.LoginRequestDto;
import com.ordersphere.ordersphere.dto.UserDTO;
import com.ordersphere.ordersphere.service.LoginService;
import com.ordersphere.ordersphere.util.constants.LoginErrorMessage;
import com.ordersphere.ordersphere.util.expections.InvalidCredentialsException;
import com.ordersphere.ordersphere.util.security.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/auth")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody LoginRequestDto loginRequestDto) {
        try {
            final UserDTO user = loginService.login(loginRequestDto);

            if (user == null || !user.getStatus()) {
                return buildErrorResponse(LoginErrorMessage.INVALID_CREDENTIALS, HttpStatus.UNAUTHORIZED);
            }

            authenticateUser(loginRequestDto.getUsername(), loginRequestDto.getPassword());
            String token = generateToken(user);
            return new ResponseEntity<>(token, HttpStatus.OK);

        } catch (InvalidCredentialsException ex) {
            return buildErrorResponse(ex.getMessage(), HttpStatus.UNAUTHORIZED);
        } catch (Exception ex) {
            return buildErrorResponse("An internal error occurred. Please try again later.", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    private String generateToken(UserDTO user) {
        List<String> roles = user.getRoles().stream()
                        .map(role -> role.getRoleName())
                        .collect(Collectors.toList());
        return jwtUtil.generateToken(user.getUsername(), roles);
    }

    private void authenticateUser(String username, String password) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
    }

    private ResponseEntity<String> buildErrorResponse(String message, HttpStatus status) {
        return new ResponseEntity<>(message, status);
    }
}
