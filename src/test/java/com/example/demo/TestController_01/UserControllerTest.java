package com.example.demo.TestController_01;

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



@SpringBootTest
public class UserControllerTest {
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

    }
}
