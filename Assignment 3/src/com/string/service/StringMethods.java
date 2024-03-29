package com.string.service;
/**
 * 
 * @author Rahul
 * Created on 16 January 2020
 * Contains various methods for comparing two string
 * ,reverse string
 * ,case conversion from lowercase to uppercase and vice cersa
 * ,method for finding largest word from string
 */
public class StringMethods {
	/**
	 * 
	 * @param str1 : 1st string 
	 * @param str2 : 2nd string
	 * @return : 1 if both string are equals else 0
	 */
	int compareStrings(String str1 ,String str2){
		int length_str1 = str1.length();
		int length_str2 = str2.length();
		int lMin = length_str1 <= length_str2 ? length_str1 : length_str2;
		for(int i=0; i<lMin; i++){
			if(str1.charAt(i) != str2.charAt(i)){
				return 0;
			}
		}
		if(length_str1 != length_str2)
			return 0;
		else
			return 1;
	}
	/**\
	 * 
	 * @param str : string which have to be reverse
	 * @return : reversed string
	 */
	String reverseString(String str){
		String rev = "";
		for(int i=str.length()-1; i>=0; i--){
			rev += str.charAt(i); 
		}
		return rev;
	}
	/**\
	 * 
	 * @param str : string which have to be converted
	 * @return : case converted string
	 */
	String caseConversion(String str){
		String newString = "";
		for(int i=0; i<str.length(); i++){
			Character strChar = str.charAt(i);
			if(strChar >= 65 && strChar <= 90){
				newString += (char)(strChar + 32); 
			}
			else if(strChar >= 97 && strChar <= 122){
				newString += (char)(strChar -32); 
			}
			else
				newString += strChar;
		}
		return newString;
	}
	/**
	 * 
	 * @param str : string from which largest word to be find
	 * @return : largest word
	 */
	String largestWord(String str){
		String largestword = "", tempString = "";
		int maxlength = 0, length = str.length(), pre = 0;
		for(int i=0; i<length; i++){
			if(str.charAt(i) == ' ' || i == length - 1 ) {

				if(i == length - 1) {
					tempString += str.charAt(i);
					i += 1;
				}
				if((i - pre) >= maxlength){
					maxlength = i - pre;
					largestword = tempString;
				}
				pre = i;
				tempString = "";
			} else {
				tempString = tempString + str.charAt(i);
			}
		}

		return largestword;
	}
}
