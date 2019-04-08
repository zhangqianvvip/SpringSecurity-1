package com.example.demo.Inteceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class Inteceptor implements HandlerInterceptor{
private static Logger logger = LoggerFactory.getLogger(Inteceptor.class); 
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("preHandle");
		HttpSession session=request.getSession();
	       if(!StringUtils.isEmpty(session.getAttribute("upUser"))) {
	    	   response.sendRedirect( request.getContextPath()+"/signupInteceptor");  
	    	   System.out.println("注册过了");
	    	  return false;
	       }
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		// TODO Auto-generated method stub
		logger.info("postHandle");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		// TODO Auto-generated method stub
		logger.info("afterCompletion");
	}

}
