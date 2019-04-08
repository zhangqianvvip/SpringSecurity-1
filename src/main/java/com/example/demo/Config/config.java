package com.example.demo.Config;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import com.example.demo.Filter.LoginFilter;
import com.example.demo.Filter.Loginquanxian;
import com.example.demo.Filter.LogoutFilter;
@Configuration
public class config {
	@Bean
	@Order(1)
	public FilterRegistrationBean addFilter1() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new LogoutFilter());
		filter.addUrlPatterns("/*");
		return filter;
	}
	@Bean
	@Order(2)
	public FilterRegistrationBean addFilter() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new LoginFilter());
		filter.addUrlPatterns("/login");
		return filter;
	}
	@Bean
	@Order(3)
	public FilterRegistrationBean addFilter2() {
		FilterRegistrationBean filter = new FilterRegistrationBean();
		filter.setFilter(new Loginquanxian());
		filter.addUrlPatterns("/qwe","/ere");
		return filter;
	}
	
}
