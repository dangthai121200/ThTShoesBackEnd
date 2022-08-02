package com.herokuapp.service.common;

import java.io.File;
import java.util.Map;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.context.Context;
import org.thymeleaf.spring5.SpringTemplateEngine;

@Service
public class MailServiceImpl implements EmailService {

	@Autowired
	private JavaMailSender emailSender;

	@Autowired
	private Environment environment;

	@Autowired
	private SpringTemplateEngine templateEngine;

	@Override
	public void sendSimpleMessage(String to, String subject, String text) {
		SimpleMailMessage message = new SimpleMailMessage();
		message.setFrom(environment.getProperty("spring.mail.username"));
		message.setTo(to);
		message.setSubject(subject);
		message.setText(text);
		emailSender.send(message);
	}

	@Override
	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
			throws MessagingException {
		MimeMessage message = emailSender.createMimeMessage();

		MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");

		helper.setFrom(environment.getProperty("spring.mail.username"));
		helper.setTo(to);
		helper.setSubject(subject);
		helper.setText(text, true);

		if (pathToAttachment != null) {
			FileSystemResource file = new FileSystemResource(new File(pathToAttachment));
			helper.addAttachment("Invoice", file);
		}

		emailSender.send(message);

	}

	@Override
	public String convertToTemplateHtmlEmail(Map<String, Object> props, String templateName) {
		Context context = new Context();
		context.setVariables(props);
		String html = templateEngine.process(templateName, context);
		return html;
	}

}
