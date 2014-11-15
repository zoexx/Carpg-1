package com.carpg.util;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MyAuth extends Authenticator {
	
	private String username = "";
	private String password = "";
	
	public MyAuth(String username, String password){
		this.username = username;
		this.password = password;
	}
	
	public PasswordAuthentication getPasswordAuthentication() {      
        return new PasswordAuthentication(this.username, this.password);  
  
    }

}
