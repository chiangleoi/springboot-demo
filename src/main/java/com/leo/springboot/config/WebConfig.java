package com.leo.springboot.config;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.Filter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.leo.springboot.filter.ThridFilter;
import com.leo.springboot.interceptor.TimeInterceptor;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Autowired
	private TimeInterceptor timeInterceptor;
	
	/**
	 * 配置拦截器
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(timeInterceptor).addPathPatterns("/user/**");
	}
	
	/**
	 * 配置第三方过滤器
	 * @return
	 */
	@Bean
	public FilterRegistrationBean<Filter> thirdFilter() {
		
		FilterRegistrationBean<Filter> registrationBean = new FilterRegistrationBean<>();
		
		// 配置使用的过滤器
		ThridFilter filter = new ThridFilter();
		registrationBean.setFilter(filter);
		
		// 配置过滤器 拦截哪些目录
		List<String> urls = new ArrayList<>();
		urls.add("/user/**");
		registrationBean.setUrlPatterns(urls);
		
		return registrationBean;
		
	}
}
