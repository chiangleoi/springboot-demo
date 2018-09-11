package com.leo.springboot.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import io.swagger.annotations.ApiModelProperty;

@Entity
public class UserEntity {
	
	// JPA通用策略生成器 
	// hibernate主键标识为@Id
	// 这里的@id和@GeneratedValue都是JPA的标准用法
	@Id
	@GeneratedValue
	@ApiModelProperty("用户id")
	private Integer id;
	
	private String name;
	
	@Max(value=18, message="你太大了")
	@Min(value=1, message="你还在你妈肚子里吧？")
	private Integer age;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "UserEntity [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
}
