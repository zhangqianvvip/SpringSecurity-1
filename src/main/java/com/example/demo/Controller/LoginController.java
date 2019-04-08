package com.example.demo.Controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LoginController {
	private static Logger log = LoggerFactory.getLogger(LoginController.class);

	
	@GetMapping("/login")
	public String login(HttpServletRequest request, String username, String password) {
		if ("admin".equals(username)) {
			if ("123".equals(password)) {
				request.getSession().setAttribute("user", "1");
				return "Admin Login Success!";
			}
		}
		if ("user".equals(username)) {
			if ("123".equals(password)) {
				request.getSession().setAttribute("user", "2");
				return "User Login Success!";
			}
		}
		return "Login Failed!";
	}
}
