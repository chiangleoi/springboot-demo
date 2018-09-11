package com.leo.springboot.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.leo.springboot.entity.UserEntity;

@Repository("userDao")
public class UserDao {
	
	@Autowired
	private UserDaoBase userDaoBase;
	
	public Object findAll() {
		return userDaoBase.findAll();
	}
	
	public Object add(UserEntity user) {
		return userDaoBase.save(user);
	}
	
	public Object findById(Integer id) {
		return userDaoBase.findById(id);
	}
	
}
