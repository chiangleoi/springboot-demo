package com.leo.springboot.enums;

public enum ResultEnum {
	UNKONW_ERROR(-1, "未知错误"),
	SUCCESS(0, "成功"),
	USER_TOOYOUNG(100, "这是小朋友，你不能看到"),
	USER_TOOOLD(101, "你还在你妈肚子里吧？"),
	;
	
	private Integer code;
	private String msg;
	
	ResultEnum(Integer code, String msg) {
		this.code = code;
		this.msg = msg;
	}

	public Integer getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}
	
	
}
