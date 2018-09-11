/**
 * 
 */
package com.leo.springboot.filter;

import java.io.IOException;
import java.util.Date;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author chian
 *
 */
public class ThridFilter implements Filter {
	
	Logger log = LoggerFactory.getLogger(ThridFilter.class);

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#destroy()
	 */
	@Override
	public void destroy() {
		log.info("ThridFilter is destroy");
	}

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#doFilter(javax.servlet.ServletRequest, javax.servlet.ServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		long time1 = new Date().getTime();
		log.info("ThridFilter is start");
		// 处理请求
		chain.doFilter(request, response);
		log.info("ThridFilter use time: " + (new Date().getTime() - time1) );
		log.info("ThridFilter is end");
	}                                                                                                                               

	/* (non-Javadoc)
	 * @see javax.servlet.Filter#init(javax.servlet.FilterConfig)
	 */
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		log.info("ThridFilter is init");
	}

}
