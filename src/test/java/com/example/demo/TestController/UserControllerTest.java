package com.example.demo.TestController;

import static org.junit.jupiter.api.Assertions.*;
import com.example.demo.Models.User;
import com.example.demo.Repository.DemoRepository;
import com.example.demo.Service.DemoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
//import org.springframework.boot.*;
//import org.springframework.boot.web.client.*;
//import org.springframework.test.web.reactive.server.WebTestClient;
//import org.springframework.test.web.reactive.server.*;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.Optional;

import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserControllerTest {
    @LocalServerPort
    private int port = 8090;
    private String username;

//    @Autowired
//    private WebTestClient.Builder webTestClient;

    @Autowired
    private WebClient.Builder webTestClient;
    @MockBean
    private DemoRepository demoRepository;
    @MockBean
    private DemoService demoService;
    private User user = new User("1045","aalloo08","Sanvu Sarvesh",
            22,"sarvesh@albanero","albanero","India");

    public UserControllerTest() {
    }

    @BeforeEach
    public void mockfun(){
        when(demoRepository.save(user)).thenReturn(user);
        when(demoRepository.findByUsername(user.getUsername()))
                .thenReturn(demoRepository.findByUsername(username));
        //when(demoRepository.findByUsername(username))
        //        .thenReturn(Optional.ofNullable(user));
    }

    @Test
    public void addUserTest(){
        ResponseEntity<User> response = webTestClient.baseUrl("http://localhost/"+port+"/task")
                .build()
                .post()
                .uri("/add_user")
                .bodyValue(user)
                .retrieve()
                .toEntity(User.class).block();
        assertEquals(response.getBody().getAge(),user.getAge());
        assertEquals(response.getBody().getName(),user.getName());
        assertEquals(HttpStatus.CREATED,demoService.addUser(user));
    }

    @Test
    public void getUserDetailsTest(){
        ResponseEntity<User> response = webTestClient
                .baseUrl("http://localhost/"+port+"/task")
                .build().get().uri("/get_userDetails")
                .retrieve()
                .toEntity(User.class)
                .block();
        assertEquals(HttpStatus.FOUND,demoService.getUserDetails("aalloo08"));
    }

    @Test
    public void getStringDetailsTest(){
        ResponseEntity<Integer> response = webTestClient.baseUrl("http://localhost/"+port+"/task")
                .build()
                .get()
                .uri("/getResult")
                .retrieve()
                .toEntity(Integer.class)
                .block();
        assertEquals(7,demoService.countVowelsAndSpecialChars("#sanvu@sarvesh#"));
    }

    @Test
    public void updateDetailsTest(){
        ResponseEntity<User> response = webTestClient.baseUrl("http://localhost/"+port+"/task")
                .build()
                .get()
                .uri("/update_user")
                .retrieve()
                .toEntity(User.class)
                .block();
        assertEquals(response.getBody(),"Your details has been updated.");
        assertEquals(HttpStatus.OK,demoService.updateUserDetails("aaloo08"));
    }

    @Test
    public void deleteUserTest(){
        ResponseEntity<Void> response = webTestClient.baseUrl("http://localhost/"+port+"/task")
                .build()
                .delete()
                .uri("/delete_user")
                .retrieve()
                .toEntity(Void.class)
                .block();
        assertEquals(response.getBody(),"Your credentials has been removed.");
        assertEquals(HttpStatus.OK,demoService.deleteUser("aalloo08"));
    }

}
