package com.example.demo.TestService;

import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.Models.User;
import com.example.demo.Repository.DemoRepository;
import com.example.demo.Service.DemoService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.*;


@SpringBootTest
public class UserServiceTest {
    @Mock
    private DemoRepository demoRepository;
    @InjectMocks
    private DemoService demoService;

    User user;

    @BeforeEach
    public void mockTry(){
        user = new User("1045","aalloo08","Sanvu Sarvesh",
                22,"sarvesh@albanero","albanero","India");
    }
    @AfterEach
    public void clearingTheUser(){
        user = null;
    }

    @Test
    @DisplayName("Test for add user")
    public void addUserTest(){
        when(demoRepository.save(user)).thenReturn(user);
        ResponseEntity<String> expected = new ResponseEntity<>
                ("New user has been created...",HttpStatus.CREATED);
        ResponseEntity<String> actual = demoService.addUser(user);
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Negative test case for add user")
    public void addUserTest_Negative(){
        when(demoRepository.save(user)).thenReturn(user);
        ResponseEntity<String> expected = new ResponseEntity<>
                ("New user has been created...",HttpStatus.CREATED);

    }
}
