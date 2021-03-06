package com.leo.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.leo.springboot.dao.UserDao;
import com.leo.springboot.entity.ResultVO;
import com.leo.springboot.entity.UserEntity;
import com.leo.springboot.enums.ResultEnum;
import com.leo.springboot.exception.UserException;
import com.leo.springboot.utils.ResultUtil;

@Service("userService")
public class UserService {
	
	@Autowired
	private UserDao userDao;
	
	public ResultVO<Object> add(UserEntity user) {
		return ResultUtil.success(userDao.add(user));
	}
	
	public ResultVO<Object> findAll() {
		return ResultUtil.success(userDao.findAll());
	}
	
	public ResultVO<Object> findById (Integer id) {
		return ResultUtil.success(userDao.findById(id));
	}
	
	public ResultVO<Object> findAgeById (Integer id) throws Exception {
		UserEntity user = (UserEntity) userDao.findById(id);
		Integer age = user.getAge();
		if (age < 6) {
			throw new UserException(ResultEnum.USER_TOOYOUNG);
		} else if (age > 18) {
			throw new UserException(ResultEnum.USER_TOOOLD);
		} else {
			return ResultUtil.success(age);
		}
		
	}
	
	
}
