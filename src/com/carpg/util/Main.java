package com.carpg.util;

import javax.mail.MessagingException;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JavaMail mail = new JavaMail();
		try {
			mail.sendVerify("1054974640@qq.com", "yan", "12345678");
		} catch (MessagingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
