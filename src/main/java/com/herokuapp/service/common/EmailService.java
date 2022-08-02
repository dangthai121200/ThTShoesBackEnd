package com.herokuapp.service.common;

import java.util.Map;

import javax.mail.MessagingException;

public interface EmailService {
	public void sendSimpleMessage(String to, String subject, String text);

	public void sendMessageWithAttachment(String to, String subject, String text, String pathToAttachment)
			throws MessagingException;

	public String convertToTemplateHtmlEmail(Map<String, Object> props, String templateName);
}
