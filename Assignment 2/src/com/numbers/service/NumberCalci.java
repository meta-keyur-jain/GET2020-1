package com.numbers.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
/**
 * 
 * @author Rahul
 * Created on 14 January 2020
 * This class works only for positive integers
 * Contains various arithmetic operation such as addition,subtraction,division,multiplication and comparing two number
 * Also contains method for converting a number to decimal number
 * Also contains method to convert a decimal number to different number base
 * Contains method to remove leading zero from the string number
 */
public class NumberCalci {
	Map<String,Integer> characterToValue = new HashMap<String,Integer>();
	Map<Integer,String> valueToCharacter = new HashMap<Integer,String>();
	/**
	 * set default value for map for converting character to value and ,for map for converting value to character
	 */
	void setDefaultValue(){
		for(int i = 0; i < 10; i++){
			valueToCharacter.put(i, Integer.toString(i));
			characterToValue.put(Integer.toString(i), i);
		}
		characterToValue.put("A", 10);
		characterToValue.put("B", 11);
		characterToValue.put("C", 12);
		characterToValue.put("D", 13);
		characterToValue.put("E", 14);
		characterToValue.put("F", 15);
		valueToCharacter.put(10, "A");
		valueToCharacter.put(11, "B");
		valueToCharacter.put(12, "C");
		valueToCharacter.put(13, "D");
		valueToCharacter.put(14, "E");
		valueToCharacter.put(15, "F");
	}
	public boolean isValidNumberString(String str, int base){
		ArrayList<String> characterToValueKeyList = new ArrayList<String>(characterToValue.keySet());
		Collections.sort(characterToValueKeyList);
		ArrayList<String> characterToValueKeyForBase = new ArrayList<String>();
		for(int i = 0; i < base; i++){
			characterToValueKeyForBase.add(characterToValueKeyList.get(i));
		}
		for(int i = 0; i < str.length() ; i++){
			if(!characterToValueKeyForBase.contains(String.valueOf(str.charAt(i))) || str.length() >= 7)
				return false;
		}
		return true;
	}
	/**
	 * 
	 * @param str : contains a number in string form 
	 * @param base : base of number
	 * @return : decimal number
	 */
	long DecimalConversion(String str, int base){
		long decNum = 0;
		//initialise local base j  with 1 ;base^0=1 
		long j = 1;
		for(int i = str.length() - 1; i >= 0; --i){
			decNum += characterToValue.get(str.substring(i, i + 1)) * j;
			j = j * base;
		}
		return decNum;
	}
	/**
	 * 
	 * @param num : contains a number which is converted to different number form
	 * @param base : base in which we want to convert
	 * @return : string of number of required base
	 */
	String numConversion(long num, int base){
		//Initialse a empty string to store the conversion of decimal number to given base number
		StringBuffer str = new StringBuffer("");
		long temp = num;
		if(num == 0){
			return "0";
		}
		while(temp != 0){
			//System.out.println(temp%base);
			//System.out.println("valueeeee"+valueToCharacter.get(0));
			//System.out.println("temp"+temp);
			//System.out.println("base"+base);
			//System.out.println(valueToCharacter.get());
			str.append(valueToCharacter.get(((int)(temp % base))));
			temp = temp / base;
		}
		return str.reverse().toString();
	}
	/**
	 *  
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @param base : base of number
	 * @return : addtion of two number
	 */
	String add(String str1, String str2, int base){
		String sum;
		long add = DecimalConversion(str1, base) + DecimalConversion(str2, base);
		sum = numConversion(add, base);
		return sum;
	}
	/**
	 * 
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @param base : base of number
	 * @return : subtraction of two number
	 */
	String sub(String str1, String str2, int base){
		String sub;
		if(compare(str1 ,str2) == -1){
			long temp = DecimalConversion(str2, base) - DecimalConversion(str1, base);
			sub = numConversion(temp ,base);
			sub = "-" + sub;
			return sub;
		}
		else{
			long temp = DecimalConversion(str1, base) - DecimalConversion(str2, base);
			sub = numConversion(temp, base);
			return sub;
		}
	}
	/**
	 * 
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @param base : base of number
	 * @return : multiplication of two number
	 */
	String mul(String str1, String str2, int base){
		String mul;
		long temp = DecimalConversion(str1, base) * DecimalConversion(str2, base);
		mul = numConversion(temp, base);
		return mul;
	}
	/**
	 * 
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @param base : base of number
	 * @return : division of two number
	 */
	String div(String str1, String str2, int base){
		String div;
		long temp = DecimalConversion(str1, base) / DecimalConversion(str2, base);
		div = numConversion(temp, base);
		return div;
	}
	/**
	 * 
	 * @param str : string from we want to remove leading zero
	 * @return : string of number without leading zero
	 */
	String removeLeadingZero(String str){
		int i = 0;
		while(i < str.length() && str.charAt(i) == '0'){
			i++;
		}
		StringBuffer tempStr = new StringBuffer(str);
		tempStr.replace(0, i, "");
		return tempStr.toString();
	}
	/**
	 * 
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @return : 1 if str1 > str2 ; -1 if str1 < str2 ; 0 if both are equal
	 */
	int compare(String str1, String str2){
		String tempStr1 = removeLeadingZero(str1);
		String tempStr2 = removeLeadingZero(str2);
		if(tempStr1.length() > tempStr2.length()){
			return 1;
		}
		else if(tempStr1.length() < tempStr2.length()){
			return -1;
		}
		else{
			for(int i = 0; i < tempStr1.length(); i++){
				if(characterToValue.get(tempStr1.substring(i, i + 1)) > characterToValue.get(tempStr2.substring(i, i + 1)))
					return 1;
				else if(characterToValue.get(tempStr2.substring(i, i + 1)) > characterToValue.get(tempStr1.substring(i, i + 1)))
					return -1;
			}
		}
		return 0;
	}
}
