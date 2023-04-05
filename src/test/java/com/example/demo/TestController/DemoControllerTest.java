package com.example.demo.TestController;

import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.Controller.DemoController;
import com.example.demo.Models.User;
import com.example.demo.Service.DemoService;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class DemoControllerTest {

    @InjectMocks
    private DemoController demoController;

    @Mock
    private DemoService demoService;

    @Mock
    User user;
    @BeforeEach
    public void setUp() {
        //MockitoAnnotations.initMocks(this);
        user = new User("1045","aalloo08","Sanvu Sarvesh",
                22,"sarvesh@albanero","albanero","India");
    }
    @AfterEach
    public void setNull(){
        user = null;
    }

    @Test
    public void testAddUser() {
        user.setUsername("aalloo08");
        ResponseEntity<String> expectedResponse =
                new ResponseEntity<>("New user has been created...", HttpStatus.CREATED);

        when(demoService.addUser(user)).thenReturn(expectedResponse);

        ResponseEntity<String> response = demoController.addUser(user);

        verify(demoService, times(1)).addUser(user);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testCountVowelsAndSpecialChars() {
        String inputString = "Hello World!";
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("Total count of vowels and special characters : ", HttpStatus.OK);

        when(demoService.countVowelsAndSpecialChars(inputString)).thenReturn(expectedResponse);

        ResponseEntity<String> response = demoController.countVowelsAndSpecialChars(inputString);

        verify(demoService,times(1)).countVowelsAndSpecialChars(inputString);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testGetUserDetails() {
        String username = "aalloo08";
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("User details fetched successfully", HttpStatus.OK);

        when(demoService.getUserDetails(username)).thenReturn(expectedResponse);

        ResponseEntity<String> response = demoController.getUserDetails(username);

        verify(demoService, times(1)).getUserDetails(username);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testUpdateUserDetails() {
        String username = "aalloo08";
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("User details updated successfully", HttpStatus.OK);

        when(demoService.updateUserDetails(username)).thenReturn(expectedResponse);

        ResponseEntity<String> response = demoController.updateUserDetails(username);

        verify(demoService, times(1)).updateUserDetails(username);
        assertEquals(expectedResponse, response);
    }

    @Test
    public void testDeleteUser() {
        String username = "aalloo08";
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("Your credentials has been removed.", HttpStatus.OK);

        when(demoService.deleteUser(username)).thenReturn(expectedResponse);

        ResponseEntity<String> response = demoController.deleteUser(username);

        verify(demoService, times(1)).deleteUser(username);
        assertEquals(expectedResponse, response);
    }
}
