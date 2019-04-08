package com.example.demo.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogoutFilter implements Filter {
	private static Logger logger = LoggerFactory.getLogger(LogoutFilter.class);
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
		System.out.println("logout");
		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;
		String path = req.getServletPath();
		if("/logout".equals(path)) {
			
			if (req.getSession().getAttribute("user")==null) {
				response.getWriter().write("User has logouted .");
				return;
			}
			req.getSession().removeAttribute("user");
			res.getWriter().write("Login Out Success");
			return ;
		}
		chain.doFilter(request, response);
		logger.info("LogoutFilter 执行完毕");
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}
