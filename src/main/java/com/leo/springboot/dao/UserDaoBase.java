package com.leo.springboot.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.leo.springboot.entity.UserEntity;


public interface UserDaoBase extends JpaRepository<UserEntity, Integer>{

}
