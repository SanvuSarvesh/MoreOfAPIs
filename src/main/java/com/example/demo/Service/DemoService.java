package com.example.demo.Service;

import com.example.demo.Models.User;
import com.example.demo.Repository.DemoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

@Service
public class DemoService {
   @Autowired
   private DemoRepository demoRepository;

    public ResponseEntity<Void> addUser(User user){
        demoRepository.save(user);
        return new ResponseEntity("New use has been created.", HttpStatus.CREATED);
    }

    public ResponseEntity<Void> countVowelsAndSpecialChars(String string){
        HashSet<Character> setOfCharacter = new HashSet<>();
        int n = string.length();
        int vowels = 0;
        int specialChars = 0;
        setOfCharacter.add('A');
        setOfCharacter.add('E');
        setOfCharacter.add('I');
        setOfCharacter.add('O');
        setOfCharacter.add('U');
        setOfCharacter.add('a');
        setOfCharacter.add('e');
        setOfCharacter.add('i');
        setOfCharacter.add('o');
        setOfCharacter.add('u');
        for(int i=0;i<n;i++){
            if(setOfCharacter.contains(string.charAt(i))){
                vowels++;
            }
            else if(!Character.isDigit(string.charAt(i)) &&
                    !Character.isLetter(string.charAt(i))){
                specialChars++;
            }
        }
        int totalCount = vowels + specialChars;
        System.out.println("Total count of vowels and special characters"+totalCount);
        return new ResponseEntity("",HttpStatus.OK);
    }

    public ResponseEntity<Void> updateUserDetails(String username){
        User user = demoRepository.findByUsername(username).get();
        HashSet<Character> setOfVowels = new HashSet<>();
        setOfVowels.add('A');
        setOfVowels.add('E');
        setOfVowels.add('I');
        setOfVowels.add('O');
        setOfVowels.add('U');
        setOfVowels.add('a');
        setOfVowels.add('e');
        setOfVowels.add('i');
        setOfVowels.add('o');
        setOfVowels.add('u');
        String previousName = user.getName();
        StringBuilder sb = new StringBuilder();
        List<Character> listOfSpecialChars = new ArrayList<>();
        int idx = 0;
        while(true){
            if(idx > 32 && idx <47 ||idx > 58 && idx < 64
                    || idx > 91 && idx < 96 || idx >123 && idx < 126){
                listOfSpecialChars.add((char)idx);
            }
            idx++;
            if(idx > 126){
                break;
            }
        }
        int size = listOfSpecialChars.size();
        for(int i=0;i<previousName.length();i++){
            if(setOfVowels.contains(previousName.charAt(i))){
                int index = (int) Math.random() % size;
                char ch = listOfSpecialChars.get(index);
                sb.setCharAt(i,ch);
            }
        }
        String newName = sb.toString();
        user.setName(newName);
        demoRepository.save(user);
        return new ResponseEntity("Your details has been updated.",HttpStatus.OK);
    }

    public ResponseEntity<Void> deleteUser(String username){
        User user = demoRepository.findByUsername(username).get();
        demoRepository.delete(user);
        return new ResponseEntity("Your credentials has been removed.",HttpStatus.OK);
    }
}
