package com.example.demo.Controller;

import com.example.demo.Models.User;
import com.example.demo.Service.DemoService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;

@RestController
@RequestMapping("/task")
public class DemoController {
    @Autowired
    private DemoService demoService;

    @PostMapping("add_user")
    public ResponseEntity<Void> addUser(@RequestBody User user){
        return demoService.addUser(user);
    }
    @GetMapping("/getResult")
    public ResponseEntity<Void> countVowelsAndSpecialChars(@RequestParam("str") String string ){
        return demoService.countVowelsAndSpecialChars(string);
    }

    @PutMapping("/update_details")
    public ResponseEntity<Void> updateUserDetails(@RequestParam("username") String username){
        return demoService.updateUserDetails(username);
    }

    @DeleteMapping("/delete_user")
    public ResponseEntity<Void> deleteUser(@RequestParam("username") String username){
        return demoService.deleteUser(username);
    }
}
