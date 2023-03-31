package com.example.demo.Models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "user")
//@Data
public class User {
    @Id
    private String id;
    private String username;
    private String name;
    private int age;
    private String emailId;
    private String currentCompany;
    private String country;

    public User() {

    }

    public User(String id, String username, String name, int age,
                String emailId, String currentCompany, String country) {
        this.id = id;
        this.username = username;
        this.name = name;
        this.age = age;
        this.emailId = emailId;
        this.currentCompany = currentCompany;
        this.country = country;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCurrentCompany() {
        return currentCompany;
    }

    public void setCurrentCompany(String currentCompany) {
        this.currentCompany = currentCompany;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
