package com.veterinaria.utils;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender emailSender; 

	@Override
	@Transactional
	public void sendEmailMessageWelcome(String to) {
		// TODO Auto-generated method stub       
	        
	        String body = "<p>&nbsp;</p>\r\n"
					+ "<h3></h3>"+
					"<span><img src='https://firebasestorage.googleapis.com/v0/b/patazasvet.appspot.com/o/imagenes%2FLogo%20de%20patazas-02.png?alt=media&token=74d187c5-f54b-477b-a950-920b523e6f67'></span>";			

			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			try {
				helper.setSubject("Bienvenido a Patazas");
				helper.setFrom("jesusriva45@gmail.com");
				helper.setTo(to);				
				helper.setText(body,true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}
			emailSender.send(message);	
	}
	
	
	@Override
	@Transactional
	public void sendEmailMessagePedido(String to, String subject, String body) {
		// TODO Auto-generated method stub
		 body = "<p>&nbsp;</p>\r\n"
					+ "<h3></h3>"+
					"<span><img src='https://firebasestorage.googleapis.com/v0/b/patazasvet.appspot.com/o/imagenes%2FLogo%20de%20patazas-02.png?alt=media&token=74d187c5-f54b-477b-a950-920b523e6f67'></span>";			

			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			try {
				helper.setSubject(subject);
				helper.setFrom("jesusriva45@gmail.com");
				helper.setTo(to);				
				helper.setText(body,true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}
			emailSender.send(message);	
		
	}


	@Override
	public void sendEmailMessagePagoCita(String subject, String to, String body) {
		// TODO Auto-generated method stub
		
		
		
					

			MimeMessage message = emailSender.createMimeMessage();
			MimeMessageHelper helper = new MimeMessageHelper(message);
			try {
				helper.setSubject(subject);
				helper.setFrom("jesusriva45@gmail.com");
				helper.setTo(to);				
				helper.setText(body,true);
			} catch (MessagingException e) {
				// TODO Auto-generated catch block				
				e.printStackTrace();
			}
			emailSender.send(message);	
	}
}

/*
 * @Bean
public JavaMailSender getJavaMailSender() {
    JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
    mailSender.setHost("smtp.gmail.com");
    mailSender.setPort(587);
    
    mailSender.setUsername("my.gmail@gmail.com");
    mailSender.setPassword("password");
    
    Properties props = mailSender.getJavaMailProperties();
    props.put("mail.transport.protocol", "smtp");
    props.put("mail.smtp.auth", "true");
    props.put("mail.smtp.starttls.enable", "true");
    props.put("mail.debug", "true");
    
    return mailSender;
}*/
 