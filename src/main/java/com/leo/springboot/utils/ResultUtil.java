package com.leo.springboot.utils;

import com.leo.springboot.entity.ResultEntity;
import com.leo.springboot.enums.ResultEnum;

public class ResultUtil {
	
	public static ResultEntity success (Object data) {
		ResultEntity result = new ResultEntity();
		result.setCode(0);
		result.setMsg("SUCCESS");
		result.setData(data);
		return result;
	}
	
	public static ResultEntity success () {
		return success(null);
	}
	
	public static ResultEntity error (Integer code, String msg) {
		ResultEntity result = new ResultEntity();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static ResultEntity error (ResultEnum resultEnum) {
		ResultEntity result = new ResultEntity();
		result.setCode(resultEnum.getCode());
		result.setMsg(resultEnum.getMsg());
		return result;
	}
}
