/**
 * 
 */
package maths;

/**
 * This class contains all of the static methods for number theory and the conversions
 * between the differet base types of numbers
 * @author adeptues
 *
 */
public class Number {
	
	/**
	 * converts a number from one base to another ie DEC to HEX
	 * 
	 * <STRONG>Note:</STRONG> This method is implemented in the Java Integer class using the Integer.to for either
	 * tohex or to oct and so on. This method is present only to reinforce my knowledge on the subject
	 * and to provide a point of translation should the functionality ever be needed in a different language.
	 * @param number
	 * @param base
	 * @return String 
	 */
	public static String toBase(int number,int base){
		if(number < base){
			return Integer.toString(number);
		}
		//TODO incomplete
		return null;
	}

}
