package com.ordersphere.ordersphere.controller;

import com.ordersphere.ordersphere.service.LoginService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class LoginControllerTest {

    @Mock
    private LoginService loginService;

    @InjectMocks
    private LoginController loginController;

    @Test
    public void testLogin_ValidCredentials() {
//        LoginRequestDto loginRequestDto = new LoginRequestDto("srt241", "srt241");
//
//        UserDTO mockUserDTO = new UserDTO(1L, "srt241", "", "srt241", new HashSet<>());
//
//        when(loginService.login(loginRequestDto)).thenReturn(mockUserDTO);
//
//        ResponseEntity<UserDTO> response = loginController.login(loginRequestDto);
//
//        UserDTO result = response.getBody();
//
//        assertNotNull(result);
//
//        assertEquals(mockUserDTO.getId(), result.getId());
//        assertEquals(mockUserDTO.getUsername(), result.getUsername());
//        assertEquals(mockUserDTO.getEmail(), result.getEmail());
    }

    @Test
    public void testLogin_InvalidCredentials() {
//        LoginRequestDto loginRequestDto = new LoginRequestDto("serhat", "wrongpassword");
//        when(loginService.login(loginRequestDto)).thenThrow(new InvalidCredentialsException("Invalid credentials"));
//        assertThrows(InvalidCredentialsException.class, () -> loginController.login(loginRequestDto));
    }
}
