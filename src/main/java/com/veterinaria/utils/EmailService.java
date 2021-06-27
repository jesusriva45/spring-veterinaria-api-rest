package com.veterinaria.utils;



public interface EmailService {
	
	public abstract void sendEmailMessageWelcome(String to)  ;
	
	
	public abstract void sendEmailMessagePedido(String subject, String to, String body);
	
	public abstract void sendEmailMessagePagoCita(String subject, String to, String body)   ;

}
