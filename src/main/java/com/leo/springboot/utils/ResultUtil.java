package com.leo.springboot.utils;

import com.leo.springboot.entity.ResultVO;
import com.leo.springboot.enums.ResultEnum;

public class ResultUtil {
	
    public static ResultVO<Object> success(Object data) {
        return success(ResultEnum.SUCCESS, data);
    }
    
    public static ResultVO<Object> success() {
        return success(ResultEnum.SUCCESS, null);
    }
	
    public static ResultVO<Object> success(ResultEnum resultEnum, Object data) {
    	ResultVO<Object> result = new ResultVO<>();
        result.setCode(resultEnum.getCode());
        result.setMsg(resultEnum.getMsg());
        result.setData(data);
        return result;
    }
    
	public static ResultVO<Object> error (Integer code, String msg) {
		ResultVO<Object> result = new ResultVO<>();
		result.setCode(code);
		result.setMsg(msg);
		return result;
	}
	
	public static ResultVO<Object> error (ResultEnum resultEnum) {
		ResultVO<Object> result = new ResultVO<>();
		result.setCode(resultEnum.getCode());
		result.setMsg(resultEnum.getMsg());
		return result;
	}

	public static ResultVO<Object> error(ResultEnum resultEnum, Object data) {
		ResultVO<Object> result = new ResultVO<>();
		result.setCode(resultEnum.getCode());
		result.setMsg(resultEnum.getMsg());
		result.setData(data);
		return result;
	}
}
