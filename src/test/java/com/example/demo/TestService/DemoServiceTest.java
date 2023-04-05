package com.example.demo.TestService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.example.demo.Models.User;
import com.example.demo.Repository.DemoRepository;

import com.example.demo.Service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

class DemoServiceTest {

    private DemoRepository demoRepository;
    private DemoService demoService;

    @BeforeEach
    void setUp() {
        demoRepository = mock(DemoRepository.class);
        demoService = new DemoService();
        //demoService.setDemoRepository(demoRepository);
    }

    @Test
    void addUser_ShouldReturnHttpStatusCreated() {
        User user = new User();
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("New user has been created...", HttpStatus.CREATED);
        when(demoRepository.save(any(User.class))).thenReturn(user);
        ResponseEntity<String> actualResponse = demoService.addUser(user);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void countVowelsAndSpecialChars_ShouldReturnHttpStatusOk() {
        String string = "This is a test string!";
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("Total count of vowels and special characters : 8",
                HttpStatus.OK);
        ResponseEntity<String> actualResponse = demoService.countVowelsAndSpecialChars(string);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void getUserDetails_ShouldReturnHttpStatusFound() {
        String username = "testuser";
        User user = new User();
        user.setUsername(username);
        ResponseEntity<String> expectedResponse = new ResponseEntity<>
                ("Details of user is :- " + user.toString(),
                HttpStatus.FOUND);
        when(demoRepository.findByUsername(username)).thenReturn(user);
        ResponseEntity<String> actualResponse = demoService.getUserDetails(username);
        assertEquals(expectedResponse, actualResponse);
    }

    @Test
    void updateUserDetails_ShouldReturnHttpStatusOk() {
        String username = "testuser";
        User user = new User();
        user.setUsername(username);
        user.setName("Test User");
        when(demoRepository.findByUsername(username)).thenReturn(user);
        ResponseEntity<String> actualResponse = demoService.updateUserDetails(username);
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }

    @Test
    void deleteUser_ShouldReturnHttpStatusOk() {
        String username = "testuser";
        User user = new User();
        user.setUsername(username);
        when(demoRepository.findByUsername(username)).thenReturn(user);
        ResponseEntity<String> actualResponse = demoService.deleteUser(username);
        assertEquals(HttpStatus.OK, actualResponse.getStatusCode());
    }
}
