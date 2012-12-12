/**
 * 
 */
package utils;

import java.security.MessageDigest;

/**
 * For checksum and hashing algorithms
 * @author adeptues
 *
 */
public class CheckSum {
	
	/**
	 * computes a md5 hash from a string
	 * @param text
	 * @return
	 */
	public static final String md5HashFromString(String text) {
	      try {
	         MessageDigest md5 = MessageDigest.getInstance("MD5");
	         md5.reset();
	         md5.update(text.getBytes("UTF-8"));
	         byte[] result = md5.digest();
	         
	         StringBuilder sb = new StringBuilder();
	         
	         for (int i = 0; i < result.length; i += 1) {
	            String value = Integer.toHexString(0xFF & result[i]);
	            if (value.length() < 2) {
	               value = "0" + value;
	            }
	            sb.append(value);
	         }
	         
	         return sb.toString();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	      
	      return null;
	   }

}
