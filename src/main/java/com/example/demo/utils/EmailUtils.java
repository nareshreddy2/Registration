package com.example.demo.utils;

import java.io.File;

import javax.mail.internet.MimeMessage;

import org.apache.logging.log4j.message.SimpleMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;

@Component
public class EmailUtils {

	@Autowired
	private JavaMailSender mailSender;

	public boolean sendEmail() {

		boolean status = false;

		try {
			//MimeMessage msg = mailSender.createMimeMessage();
			SimpleMailMessage helper = new SimpleMailMessage();
			helper.setTo("lakshmidwarampudi878@gmail.com");
			helper.setBcc("mnareshreddy222@gmail.com");
			helper.setSubject("Registration Successful!!");
			helper.setText("Thankyou for Register in our Portal..Hope you Enjoy our Sevices");
			//helper.addAttachment(file.getName(), file);
			//mailSender.send(helper);
			status = true;
		} catch (Exception e) {
          e.printStackTrace();
		}
		return status;
	}
}
