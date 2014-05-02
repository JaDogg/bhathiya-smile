package org.bhathiya.util;

import android.annotation.SuppressLint;
import java.util.Locale;

public class BhathiUtil {

	/**
	 * Convert a given integer to a string always using a sign.
	 * <br /><br />
	 * example: <br />
	 * intToPlusOrMinusString(5) => "+5" <br />
	 * intToPlusOrMinusString(-1) => "-1" 
	 * 
	 * @param val int value
	 * @return value as a String
	 * 
	 */
	@SuppressLint("DefaultLocale")
	public static String intToPlusOrMinusString(int val) {
		return String.format(Locale.US,"%+d", val);
	}
	
	/**
	 * int to boolean (0 is false, all others are true)
	 * @param val int value
	 * @return a boolean
	 *  
	 */
	public static boolean intToBoolean(int val){
		return (val != 0);
	}
	/**
	 * boolean to int
	 * @param condition a boolean primitive
	 * @return 1 if true, 0 if false
	 */
	public static int booleanToInt(boolean condition){
		return ((condition) ? 1 : 0);
	}
}
