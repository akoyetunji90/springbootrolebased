package com.zeedlabs.login;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.service.UserServices;

@Component
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {

	@Autowired
	UserServices userService;

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {
		String email = request.getParameter("email");

		System.out.println("onAuthenticationFailure email: " + email);

		String failureRedirectURL = "/login?error&email=" + email;

		if (exception.getMessage().contains("OTP")) {
			failureRedirectURL = "/login?otp=true&email=" + email;
		} else {
			User user = userService.getUserByEmail(email);
			if (user != null && user.isOTPRequired()) {
				failureRedirectURL = "/login?error&email=" + email;

			}
		}

		super.setDefaultFailureUrl(failureRedirectURL);

		super.onAuthenticationFailure(request, response, exception);

	}

}
