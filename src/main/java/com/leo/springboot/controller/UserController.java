package com.leo.springboot.controller;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.leo.springboot.entity.UserEntity;
import com.leo.springboot.enums.ResultEnum;
import com.leo.springboot.service.UserService;
import com.leo.springboot.utils.ResultUtil;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@RequestMapping("/user")
public class UserController {
	
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	public UserService UserService; 

	@Value("${author.name}")
	private String propertiesUser;
	
	@Value("${author.age}")
	private Integer propertiesAge;
	
	@GetMapping("/properties")
	public String getProperties() {
		return propertiesUser + propertiesAge;
	}
	
    @GetMapping("/findAll")
    public Object findAll() {
        return UserService.findAll();
    }
    
    @GetMapping("/{id:\\d+}")
    @ApiOperation("通过ID 获取用户") // swagger 中的注释
    public Object findByid(@ApiParam("用户id") @PathVariable Integer id) {
    	return UserService.findById(id);
    }
    
    @PostMapping("/add")
    public Object addUser(@Valid UserEntity user, BindingResult bindingResult) {
    	if (bindingResult.hasErrors()) {
    		logger.error(bindingResult.getFieldError().getDefaultMessage());
    		return ResultUtil.error(ResultEnum.FORM_VALID_ERROR, bindingResult.getFieldError().getDefaultMessage());
    	} else {
    		return UserService.add(user);
    	}
    }
    
    @GetMapping("/getAge/{id}")
    public Object age(@PathVariable Integer id) throws Exception{
    	return UserService.findAgeById(id);
    }

}