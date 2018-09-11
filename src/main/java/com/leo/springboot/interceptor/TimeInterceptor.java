/**
 * 
 */
package com.leo.springboot.interceptor;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author chian
 * 局限性
 * 		拿不到处理请求的参数
 */
@Component
public class TimeInterceptor implements HandlerInterceptor {
	
	Logger log = LoggerFactory.getLogger(TimeInterceptor.class);

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		log.info("TimeInterceptor is start");
		request.setAttribute("startTime", new Date().getTime());
		// 处理请求的 class
		log.info(((HandlerMethod)handler).getBean().getClass().getName());
		// 处理请求的 方法名
		log.info(((HandlerMethod)handler).getMethod().getName());
		// true false 决定是否进入 后面的方法
		return true;
	}
	
	/**
	 * 如果 控制器发生异常 这个方法也会被终止
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
		log.info("TimeInterceptor 耗时：" + (new Date().getTime() - (long)request.getAttribute("startTime")));
	}
	
	/**
	 *  这个 方法永远会被调用，包括 控制器发生异常
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
		
		log.info("TimeInterceptor 耗时：" + (new Date().getTime() - (long)request.getAttribute("startTime")));
		log.error("ex is : " + ex);
		log.info("TimeInterceptor is completion");
	}
}
