package com.psm.intellect.controller;

import java.awt.PageAttributes.MediaType;
import java.util.Arrays;

import java.util.List;

import org.apache.log4j.Logger;
import org.jboss.logging.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.psm.intellect.model.User;
import com.psm.intellect.service.UserService;

/**
 * 
 * @author SIVAMURTHY
 *
 */

@RestController
@RequestMapping("/user")
public class UserController {
	
	final static Logger logger = Logger.getLogger(UserController.class);

	@Autowired
	UserService userService;

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json",produces = "application/json")
	public ResponseEntity<User> addUser(@RequestBody User user) {
		userService.save(user);
		logger.debug("Added:: " + user);
		return new ResponseEntity<User>(user, HttpStatus.CREATED);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> updateUser(@RequestBody User user) {
		User existingUser = userService.getById(user.getId());
		if (existingUser == null) {
			logger.debug("User with id " + user.getId() + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.save(user);
			return new ResponseEntity<Void>(HttpStatus.OK);
		}
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<User> getUser(@PathVariable("id") Long id) {
		User user = userService.getById(id);
		if (user == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
		}
		logger.debug("Found User:: " + user);
		return new ResponseEntity<User>(user, HttpStatus.OK);
	}


	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<User>> getAllUsers() {
		List<User> user = userService.getAll();
		if (user.isEmpty()) {
			logger.debug("User does not exists");
			return new ResponseEntity<List<User>>(HttpStatus.NO_CONTENT);
		}
		logger.debug("Found " + user.size() + " Users");
		logger.debug(Arrays.toString(user.toArray()));
		return new ResponseEntity<List<User>>(user, HttpStatus.OK);
	}


	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUser(@PathVariable("id") Long id) {
		
		User user = userService.getById(id);
		if (user == null) {
			logger.debug("User with id " + id + " does not exists");
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		} else {
			userService.delete(id);
			logger.debug("User with id " + id + " deleted");
			return new ResponseEntity<Void>(HttpStatus.GONE);
		}
	}

}
