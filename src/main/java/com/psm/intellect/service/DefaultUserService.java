package com.psm.intellect.service;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.psm.intellect.dao.UserDAO;
import com.psm.intellect.model.User;


/**
 * 
 * @author SivaMurthy
 *
 */	
	
@Service
public class DefaultUserService implements UserService {
	
	private static List<User> users;

		@Autowired
		private UserDAO userDAO;

		@Override
		public User save(User entity) {
			return userDAO.save(entity);
		}

		@Override
		public User getById(Serializable id) {
			return userDAO.findOne((Long) id);
		}

		@Override
		public List<User> getAll() {
			return userDAO.findAll();
		}

		@Override
		public void delete(Serializable id) {
			userDAO.delete((Long) id);
		}
		
		@Override
		public User getByPinCode(Serializable pinCode) {
			for(User user : users){
				if(user.getPinCode() == pinCode){
					return user;
				}
			}
			return null;
		}

}
