package com.email;

import java.util.Properties;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

public class JavaMail {
	
	public void sendMailtoUser(String email,String name, int jo_code, String name_jobopening) {
	    Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.gmail.com");
	    props.put("mail.smtp.socketFactory.port", "465");
	    props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "465");
	 
	    String email_stmp, password;
	    
	    email_stmp = "projbayer.snipercontractor@gmail.com";
	    password = "Noreply!Qualquercoisa500#smtp!services@@";
	    
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() 
	           {
	                 return new PasswordAuthentication(email_stmp, password);
	           }
	      });
	    
	    session.setDebug(true);
	    
	    try {
	 
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(email_stmp));
	 
	      Address[] toUser = InternetAddress.parse(email);  
	 
	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Feedback of your application in the Job Opening nº " +jo_code+" - " + name_jobopening);
	      message.setText("Dear " + name +", a Recruiter gave you a feedback about your application, check it out on our portal!\n\n\nCheers,\nSniper Contractor Inc.");
	      Transport.send(message);
	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	 }
	
	public void sendWelcomeMail(String email, String name) {
		Properties props = new Properties();
	    props.put("mail.smtp.host", "smtp.office365.com");
	    //props.put("mail.smtp.socketFactory.port", "587");
	    //props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
	    props.put("mail.smtp.starttls.enable", "true");
	    props.put("mail.smtp.auth", "true");
	    props.put("mail.smtp.port", "587");
	 
	    String email_stmp, password;
	    
	    email_stmp = "projectbayer.snipercontractorv1.0@outlook.com";
	    password = "noreply!projectbayerfiap";
	    
	    Session session = Session.getDefaultInstance(props,
	      new javax.mail.Authenticator() {
	           protected PasswordAuthentication getPasswordAuthentication() 
	           {
	                 return new PasswordAuthentication(email_stmp, password);
	           }
	      });
	    
	    session.setDebug(true);
	    
	    try {
	 
	      Message message = new MimeMessage(session);
	      message.setFrom(new InternetAddress(email_stmp));
	 
	      Address[] toUser = InternetAddress.parse(email);  
	 
	      message.setRecipients(Message.RecipientType.TO, toUser);
	      message.setSubject("Welcome to Sniper Contractor!");
	      message.setText("Greetings " + name +"!\nYou are more than welcome to our platform, we hope very much you get your next job as soons as possible! For any doubts: www.snipercontractor.com/doubts\n\n\nCheers,\nSniper Contractor Inc.");
	      Transport.send(message);
	     } catch (MessagingException e) {
	        throw new RuntimeException(e);
	    }
	}
}	
