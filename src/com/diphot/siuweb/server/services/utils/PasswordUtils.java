package com.diphot.siuweb.server.services.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class PasswordUtils {

	private static String salt = "5@L";
	
	public static String hashMD5(String input) {
		String md5 = null;
		if(input != null) {
			try {
				//Create MessageDigest object for MD5
				MessageDigest digest = MessageDigest.getInstance("MD5");
				//Update input string in message digest
				digest.update(input.getBytes(), 0, input.length());
				//Converts message digest value in base 16 (hex) 
				md5 = new BigInteger(1, digest.digest()).toString(16);
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
			}
		}
		return md5;
	}
	
	public static String saltHashMD5(String input){
		return hashMD5(input+ salt);
	}
}
