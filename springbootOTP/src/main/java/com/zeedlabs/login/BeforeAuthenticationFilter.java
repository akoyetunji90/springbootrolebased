package com.zeedlabs.login;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.stereotype.Component;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.service.UserServices;

@Component
public class BeforeAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

	@Autowired
	UserServices userService;

	public BeforeAuthenticationFilter() {
		super.setUsernameParameter("email");
		super.setRequiresAuthenticationRequestMatcher(new AntPathRequestMatcher("/login", "POST"));
	}

	public BeforeAuthenticationFilter(AuthenticationManager authenticationManager) {
		super(authenticationManager);

	}

	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {

		String email = request.getParameter("email");
		System.out.println("attemptAuthentication eamil: " + email);

		User user = userService.getUserByEmail(email);
		if (user != null) {
			float spamScore = getGoogleRecapthaScore();
			if (spamScore < 0.5) {
				if (user.isOTPRequired()) {
					return super.attemptAuthentication(request, response);
				}

				try {
					userService.generateOneTimePassword(user);

					throw new InsufficientAuthenticationException("OTP");
				} catch (UnsupportedEncodingException | MessagingException e) {
					throw new AuthenticationServiceException("Error while sending OTP to your email");
				}
			}
		}

		return super.attemptAuthentication(request, response);
	}

	private float getGoogleRecapthaScore() {
		// TODO Auto-generated method stub
		return 0.43f; // for normal return value > 0.5
	}

	@Autowired
	@Override
	public void setAuthenticationManager(AuthenticationManager authenticationManager) {
		super.setAuthenticationManager(authenticationManager);
	}

	@Autowired
	@Override
	public void setAuthenticationSuccessHandler(AuthenticationSuccessHandler successHandler) {
		super.setAuthenticationSuccessHandler(successHandler);
	}

	@Autowired
	@Override
	public void setAuthenticationFailureHandler(AuthenticationFailureHandler failureHandler) {
		super.setAuthenticationFailureHandler(failureHandler);
	}

}