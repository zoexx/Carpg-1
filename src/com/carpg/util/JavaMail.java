package com.carpg.util;

import java.util.Date;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMessage.RecipientType;

public class JavaMail {
	
	private final String username="tao_baoguang@163.com";
	private final String password="taobaoguang1";
	
	 private Message getMessage(){
	  Properties p=new Properties();
	  p.put("mail.transport.protocol","smtp");
	  p.put("mail.smtp.host","smtp.163.com");
	  p.put("mail.smtp.port","25");
	  p.put("mail.smtp.auth","true");
	  
	  MyAuth auth = new MyAuth(username, password);
	  Session session=Session.getInstance(p, auth);
	  Message message=new MimeMessage(session);
	  return message;
	 }
	 
	 //发送邮箱验证信息
	 public void sendVerify(String email,String name,String code)
	 throws MessagingException {	 
	   Message message=getMessage();
	   message.setFrom(new InternetAddress(username));
	   message.setRecipient(RecipientType.TO,new InternetAddress(email));
	   message.setSentDate(new Date());
	   message.setSubject("Carpg");
	   String m="<a href="+"http://127.0.01:8080/test/index.jsp?stu_nameMd5="+name+"&randMd5="+code+">" +
	     "http:/127.0.01:8080/test/index.jsp?stu_nameMd5="+name+"&randMd5="+code+"</a>";
	   message.setContent(m,"text/html;charset=utf-8");
	   Transport.send(message);
	  }

}
