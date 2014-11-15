package com.carpg.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class Tools {

	
	//MD5º”√‹
	public static String getMD5(String s) {
        String strResult = "";
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte[] messageDigest = digest.digest();
            
            String hs = "";
            String stmp = "";
     
            for (int n = 0; n < messageDigest.length; n++) {
                stmp = (java.lang.Integer.toHexString(messageDigest[n] & 0XFF));
                if (stmp.length() == 1)
                    hs = hs + "0" + stmp;
                else
                    hs = hs + stmp;
            }
            strResult = hs.toUpperCase();
            strResult = strResult.toLowerCase();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
 
        return strResult;
    }

}
