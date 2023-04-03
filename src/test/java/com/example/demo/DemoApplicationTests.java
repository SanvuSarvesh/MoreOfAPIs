package com.example.demo;
import static org.junit.jupiter.api.Assertions.*;

import com.example.demo.Models.TestingFuntions;
import com.example.demo.Models.User;
import com.example.demo.Service.DemoService;
import com.fasterxml.jackson.databind.ser.impl.UnknownSerializer;
import jdk.jfr.Enabled;
import org.bson.codecs.pojo.annotations.BsonIgnore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class DemoApplicationTests {
//	@Autowired
//	private User user;

//	@Test
//	void contextLoads() {
//		RestTemplate restTemplate = new RestTemplate();
//		String sourceUrl = "http://localhost:8097/";
//		ResponseEntity responseEntity =
//				restTemplate.getForEntity(sourceUrl+ "getResult",String.class);
//		assertEquals(responseEntity.getStatusCode(), HttpStatus.OK);
//	}
//
//	@Test
//	void testPostAPI(){
//		RestTemplate restTemplate = new RestTemplate();
//		String sourceUrl = "http://localhost:8097/";
//		ResponseEntity<Void> responseEntity =
//			restTemplate.postForEntity(sourceUrl+"add_user",
//					new User("hyd",100), Void.class);
//		assertEquals(responseEntity.getStatusCode(),HttpStatus.CREATED);
//	}
//
//	@Test
//	void testDeleteAPI(){
//		String sourceUrl = "http://localhost:8097";
//		RestTemplate restTemplate = new RestTemplate();
//		TestRestTemplate testRestTemplate = new TestRestTemplate();
//		ResponseEntity<Void> responseEntity =
//				testRestTemplate.delete(sourceUrl+"/delete_uder","username", User.class);
//		//assertEquals();
//	}
//
//	@Test
//	void testUpdateAPI(){
//		String sourceUrl ="http://localhost:8097";
//		TestRestTemplate testRestTemplate = new TestRestTemplate();
//		ResponseEntity responseEntity =
//				//testRestTemplate.put(sourceUrl,"update_details",String.class);
//		testRestTemplate.put( sourceUrl,"/update_details",Void.class);
//	}
	TestingFuntions testingFuntions = new TestingFuntions();
	@Test
	void add(){
		int expected = 15;
		int actual = testingFuntions.add(7,8);
		assertEquals(expected,actual);
	}
	@Test
	void product(){
		assertEquals(70,testingFuntions.product(2,5,7));
	}

	@Autowired
	private DemoService demoService;
	@Test
	public void testAddUser(){
		User user = new User("123","sanvu08","Sanvu Sarvesh",22,
				"sarvesh@gmail.com","albanero","India");
		demoService.addUser(user);
		assertEquals("123",user.getId());
		assertEquals("sanvu08",user.getUsername());
		assertEquals("Sanvu Sarvesh",user.getName());
		assertEquals("India",user.getCountry());
	}

	@Test
	public void testUpdateUser(){
		User user = new User("123","sanvu08","Sanvu Sarvesh",22,
				"sarvesh@gmail.com","albanero","India");
		user.setEmailId("sarvesh@albanero");
		assertEquals("sarvesh@albanero",user.getEmailId());
	}

	@Test
	public void testDeleteUser(){
		User user = new User("123","sanvu08","Sanvu Sarvesh",22,
				"sarvesh@gmail.com","albanero","India");
		demoService.addUser(user);
		demoService.deleteUser(user.getName());
		assertEquals(null,demoService.deleteUser("sanvu08"));
	}
}

