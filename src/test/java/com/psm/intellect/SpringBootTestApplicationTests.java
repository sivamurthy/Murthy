package com.psm.intellect;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.WebApplicationContext;

import com.psm.intellect.controller.UserController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootTestApplicationTests {

	 private static final String RESOURCE_LOCATION_PATTERN = "http://localhost/example/v1/hotels/[0-9]+";

	    @InjectMocks
	    UserController controller;
	    
	    @Autowired
	    WebApplicationContext context;
	
	@Test
	public void contextLoads() {
	}

}
