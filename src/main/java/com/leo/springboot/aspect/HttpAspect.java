package com.leo.springboot.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


/**
 * 
 * @author chian
 * 局限性
 * 		拿不到  HttpServletRequest HttpServletResponse
 */
@Aspect
@Component
public class HttpAspect {
	
	private final static Logger logger =  LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.leo.springboot.controller.*.*(..))")
	public void log() {
    }
	
	@Before("log()")
	public void doBefore(JoinPoint joinpoint) {
		logger.info("before HttpAspect");
		
		ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		
		// 访问方法:地址
		logger.info("url={}:{}", request.getMethod(), request.getRequestURI());
		
		// 来源ip
		logger.info("ip={}", request.getRemoteAddr());
		
		// 类方法
		logger.info("class_method={}.{}", joinpoint.getSignature().getDeclaringTypeName(), joinpoint.getSignature().getName());
		
		// 参数
		logger.info("args={}", joinpoint.getArgs());
		
	}
	
	@After("log()")
	public void doAfter() {
		logger.info("after HttpAspect");
	}
	
	@AfterReturning(returning = "object", pointcut = "log()")
	public void doAfterReturning(Object object) {
		try {
			logger.info("response={}", object.toString());
		} catch (Exception e) {
			logger.error("response toString fail");
		}
		
	}
	
}
