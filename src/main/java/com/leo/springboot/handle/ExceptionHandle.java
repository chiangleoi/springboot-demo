package com.leo.springboot.handle;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.leo.springboot.entity.ResultVO;
import com.leo.springboot.enums.ResultEnum;
import com.leo.springboot.exception.UserException;
import com.leo.springboot.utils.ResultUtil;

// 所有 controller 都会经过这个
@ControllerAdvice
public class ExceptionHandle {
	
	private final static Logger logger = LoggerFactory .getLogger(ExceptionHandle.class);
	
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public ResultVO<Object> handle(Exception e) {
		
		if (e instanceof UserException) {
			UserException userException = (UserException) e;
			return ResultUtil.error(userException.getCode(), userException.getMessage());
		} else {
			logger.error("系统异常 {}", e);
			return ResultUtil.error(ResultEnum.UNKONW_ERROR);
		}
	}
	
}
