package com.psm.intellect.dao;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;


import org.springframework.stereotype.Repository;

import com.psm.intellect.model.User;
/**
 * 
 * @author SivaMurthy
 *
 */
//@Repository
public interface UserDAO extends JpaRepository<User, Long>  {

	//void update(String sql);

}
