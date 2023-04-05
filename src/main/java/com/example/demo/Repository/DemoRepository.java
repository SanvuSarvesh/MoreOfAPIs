package com.example.demo.Repository;


import com.example.demo.Models.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface DemoRepository extends MongoRepository<User,String> {
    User findByUsername(String username);

    //List<User> findByUserName(String username);
}
