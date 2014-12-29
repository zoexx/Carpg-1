package com.carpg.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import javax.mail.MessagingException;

public class Main {
	static int id;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaMail mail = new JavaMail();
		try {
			mail.sendVerify("1054974640@qq.com", "name", "code", "regist");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	public void setI(){
		id = 3;
	}

}
