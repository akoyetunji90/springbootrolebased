package com.zeedlabs.login.controllers;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.zeedlabs.login.Utility;
import com.zeedlabs.login.entity.User;
import com.zeedlabs.login.service.CustomUserDetailsService;
import com.zeedlabs.login.service.UserNotFoundException;

import net.bytebuddy.utility.RandomString;

@Controller
public class ForgotPasswordController {

	@Autowired
	private CustomUserDetailsService userService;
	@Autowired
	private JavaMailSender mailSender;

	@GetMapping("/forgot_password")
	public String showForgotPasswordForm(Model model) {

		model.addAttribute("pageTitle", "Forgot Password");
		return "forgot_password_form";
	}

	@PostMapping("/forgot_password")
	public String processForgotPasswordForm(HttpServletRequest request, Model model) {
		String email = request.getParameter("email");
		String token = RandomString.make(45);

		try {
			userService.updateResetPasswordToken(token, email);

			String resetPasswordLink = Utility.getSiteURL(request) + "/reset_password?token=" + token;
			System.out.println(resetPasswordLink);

			sendEmail(email, resetPasswordLink);

			model.addAttribute("message", "We have sent a reset Password link" + " to the mail provided please check.");

		} catch (UserNotFoundException e) {

			model.addAttribute("error", e.getMessage());
		} catch (UnsupportedEncodingException | MessagingException e) {
			model.addAttribute("error", "Error while sending mail.");
			e.printStackTrace();
		}

		System.out.println("Email: " + email);
		System.out.println("Token: " + token);

		return "forgot_password_form";

	}

	private void sendEmail(String email, String resetPasswordLink)
			throws UnsupportedEncodingException, MessagingException {
		// TODO Auto-generated method stub
		MimeMessage message = mailSender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(message);

		helper.setFrom("adekunle@zeedlabs.com", "Adekunle Oyetunji");
		helper.setTo(email);

		String subject = "Here is the link to reset your password";

		String content = "<p>Hello, </P>" + "<p>You have requested to reset your password.</P>"
				+ "<p>Click the link below to change your password:</p>" + "<p><b><a href=\"" + resetPasswordLink
				+ "\">Change my password</a></b></p>"
				+ "<p>Ignore this mail if you do remember your pass word or you have not made the request</p>";

		helper.setSubject(subject);
		helper.setText(content, true);

		mailSender.send(message);
	}
	/*
	 * String from = "sender@gmail.com"; String to = "recipient@gmail.com";
	 * 
	 * helper.setSubject("Here's your e-book"); helper.setFrom(from);
	 * helper.setTo(to);
	 * 
	 * helper.setText("<b>Dear friend</b>,<br><i>Please find the book attached.</i>"
	 * , true);
	 * 
	 * FileSystemResource file = new FileSystemResource(new File("Book.pdf"));
	 * helper.addAttachment("FreelanceSuccess.pdf", file);
	 * 
	 * mailSender.send(message);
	 */

	/*
	 * String from = "sender@gmail.com"; String to = "recipient@gmail.com";
	 * 
	 * helper.setSubject("Here's your pic"); helper.setFrom(from); helper.setTo(to);
	 * 
	 * String content =
	 * "<b>Dear guru</b>,<br><i>Please look at this nice picture:.</i>" +
	 * "<br><img src='cid:image001'/><br><b>Best Regards</b>";
	 * helper.setText(content, true);
	 * 
	 * FileSystemResource resource = new FileSystemResource(new
	 * File("picture.png")); helper.addInline("image001", resource);
	 * 
	 * mailSender.send(message);
	 */

	/*
	 * String from = "adekunle@zeedlabs.com"; String to = "akoyetunji@gmail.com";  
	 * SimpleMailMessage message = new SimpleMailMessage();
	 * message.setFrom(adekunle@zeedlabs.com); message.setTo(akoyetunji@gmail.com);
	 * message.setSubject("This is a plain text email");
	 * message.setText("Hello guys! This is a plain text email.");  
	 * mailSender.send(message);
	 */

	@GetMapping("/reset_password")
	public String showResetPasswordForm(@Param(value = "token") String token, Model model) {
		User user = userService.get(token);
		model.addAttribute("token", token);

		if (user == null) {
			model.addAttribute("title", "Reset Your Password");
			model.addAttribute("message", "Invalid Token");
			return "message";
		}

		model.addAttribute("token", token);
		model.addAttribute("pageTitle", "Reset Your Password");

		return "reset_password_form";
	}

	@PostMapping("/reset_password")
	public String processResetPassword(HttpServletRequest request, Model model) {
		String token = request.getParameter("token");
		String password = request.getParameter("password");

		User user = userService.get(token);

		if (user == null) {
			model.addAttribute("title", "Reset your password");
			model.addAttribute("message", "Invalid Token");

		} else {
			userService.updatePassword(user, password);
			model.addAttribute("message", "You have successfully changed your password.");
		}
		return "message";
	}
}
