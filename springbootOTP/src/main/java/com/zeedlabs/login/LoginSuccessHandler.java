package com.zeedlabs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.service.UserServices;

@Component
public class LoginSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

	@Autowired
	private UserServices userService;

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		System.out.println("onAuthenticationSuccess");

		CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

		/*
		 * User user = userDetails.getUser();
		 * 
		 * if (user.isOTPRequired()) { userService.clearOTP(user); }
		 */
		super.onAuthenticationSuccess(request, response, authentication);
	}

}
