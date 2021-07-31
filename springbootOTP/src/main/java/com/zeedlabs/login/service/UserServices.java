package com.zeedlabs.login.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.repository.UserRepository;

import net.bytebuddy.utility.RandomString;

@Service
public class UserServices {

	@Autowired
	private UserRepository repo;

	@Autowired
	private JavaMailSender mailSender;

	public boolean isEmailUnique(String email) {

		User existUser = repo.findByEmail(email);
		return existUser == null;
	}

	public User getUserByEmail(String email) {

		return repo.findByEmail(email);
	}

	public void generateOneTimePassword(User user) throws UnsupportedEncodingException, MessagingException {
		String OTP = RandomString.make(8);
		System.out.println("OTP: " + OTP);

		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String encodedOTP = passwordEncoder.encode(OTP);

		user.setOneTimePassword(encodedOTP);
		user.setOtpRequestedTime(new Date());

		repo.save(user);
		sendOTPEmail(user, OTP);
	}

	public void sendOTPEmail(User user, String OTP) throws UnsupportedEncodingException, MessagingException {
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("adekunle@zeedlabs.com", "Zeedlabs Support");
		helper.setTo(user.getEmail());

		String subject = "Here's your One Time Password (OTP) - Expire in 5 minutes!";
		String content = "<p>Hello " + user.getFirstName() + "</p>"
				+ "<p>For security reason, you're required to use the following " + "One Time Password to login:</p>"
				+ "<p><b>" + OTP + "</b></p>" + "<br>" + "<p>Note: this OTP is set to expire in 5 minutes.</p>";

		helper.setSubject(subject);

		helper.setText(content, true);

		mailSender.send(message);

		System.out.println("Email was sent");
	}

	public void clearOTP(User user) {
		user.setOneTimePassword(null);
		user.setOtpRequestedTime(null);
		repo.save(user);

		System.out.println("OTP Is Cleared");
	}
}