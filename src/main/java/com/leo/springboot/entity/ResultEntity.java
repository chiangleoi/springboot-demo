package com.leo.springboot.entity;

/**
 * 返回结果 格式化
 * @author chian
 *
 * @param
 */
public class ResultEntity {

	private Integer code;
	private String msg;
	private Object data;
	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	
	
}
