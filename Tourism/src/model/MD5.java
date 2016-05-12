
package model;

import java.security.MessageDigest;

/**
 * 
 * This class is used to encipher user's passwords it is based on the arithmetic
 * of the MD5
 * 
 * @author WANG XI - GAUTHIER Pierre
 */
public class MD5 {
	/**
	 * 
	 * @param origString
	 *            The passwords which is prepared to be enciphered
	 * @return The String which is been enciphered
	 */
	public static String getMD5ofStr(String origString) {
		String origMD5 = null;
		try {
			MessageDigest md5 = MessageDigest.getInstance("MD5");
			byte[] result = md5.digest(origString.getBytes());
			origMD5 = byteArray2HexStr(result);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return origMD5;
	}

	/**
	 * This method change the byte array to hexadecimal String
	 * 
	 * @param bs
	 *            The byte array
	 * @return Hexadecimal String
	 */
	private static String byteArray2HexStr(byte[] bs) {
		StringBuffer sb = new StringBuffer();
		for (byte b : bs) {
			sb.append(byte2HexStr(b));
		}
		return sb.toString();
	}

	/**
	 * This method change byte to hexadecimal String
	 * 
	 * @param b
	 *            The byte
	 * @return The hexadecimal String
	 */
	private static String byte2HexStr(byte b) {
		String hexStr = null;
		int n = b;
		if (n < 0) {
			// Here is the displacement, you can change this arithmetic to
			// custom your own encipherment.
			n = b & 0x7F + 128;
		}
		hexStr = Integer.toHexString(n / 16) + Integer.toHexString(n % 16);
		return hexStr.toUpperCase();
	}

	/**
	 * This method offers a multiple encipher choice.
	 * 
	 * @param origString
	 *            The String prepared to be enciphered
	 * @param times
	 *            The times you want to encipher your String
	 * @return The String which has been enciphered
	 */
	public static String getMD5ofStr(String origString, int times) {
		String md5 = getMD5ofStr(origString);
		for (int i = 0; i < times - 1; i++) {
			md5 = getMD5ofStr(md5);
		}
		return getMD5ofStr(md5);
	}

	/**
	 * This method is used to verify the String and the String after enciphered
	 * 
	 * @param inputStr
	 *            The original String
	 * @param MD5Code
	 *            The String which has been enciphered
	 * @return If they are matched
	 */
	public static boolean verifyPassword(String inputStr, String MD5Code) {
		return getMD5ofStr(inputStr).equals(MD5Code);
	}

	/**
	 * This method is used to verify the String and the String after multiple
	 * enciphered
	 * 
	 * @param inputStr
	 *            The original String
	 * @param MD5Code
	 *            The String which has been enciphered
	 * @param times
	 *            The times that has been enciphered
	 * @return If they are matched
	 */
	public static boolean verifyPassword(String inputStr, String MD5Code, int times) {
		return getMD5ofStr(inputStr, times).equals(MD5Code);
	}

}