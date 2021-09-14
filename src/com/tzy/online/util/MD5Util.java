package com.tzy.online.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

	/**
	 * 加密
	 * 
	 * @param str 明文
	 * @return 加密之后的字符
	 */
	public static String MD5(String str) {

		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };

		try {
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			mdInst.update(str.getBytes());
			byte[] md = mdInst.digest();
			int j = md.length;
			char str2[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str2[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str2[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str2);
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return null;
	}

}
