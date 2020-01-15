package com.numbers.service;

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
public class NumberCalc {
	Map<Character,Integer> characterToValue = new HashMap<Character,Integer>();
	Map<Integer,Character> valueToCharacter = new HashMap<Integer,Character>();
	/**
	 * set default value for map for converting character to value and ,for map for converting value to character
	 */
	void setDefaultValue(){
		characterToValue.put('0' ,0);
		characterToValue.put('1' ,1);
		characterToValue.put('2' ,2);
		characterToValue.put('3' ,3);
		characterToValue.put('4' ,4);
		characterToValue.put('5' ,5);
		characterToValue.put('6' ,6);
		characterToValue.put('7' ,7);
		characterToValue.put('8' ,8);
		characterToValue.put('9' ,9);
		characterToValue.put('A' ,10);
		characterToValue.put('B' ,11);
		characterToValue.put('C' ,12);
		characterToValue.put('D' ,13);
		characterToValue.put('E' ,14);
		characterToValue.put('F' ,15);
		valueToCharacter.put(0 ,'0');
		valueToCharacter.put(1 ,'1');
		valueToCharacter.put(2 ,'2');
		valueToCharacter.put(3 ,'3');
		valueToCharacter.put(4 ,'4');
		valueToCharacter.put(5 ,'5');
		valueToCharacter.put(6 ,'6');
		valueToCharacter.put(7 ,'7');
		valueToCharacter.put(8 ,'8');
		valueToCharacter.put(9 ,'9');
		valueToCharacter.put(10 ,'A');
		valueToCharacter.put(11 ,'B');
		valueToCharacter.put(12 ,'C');
		valueToCharacter.put(13 ,'D');
		valueToCharacter.put(14 ,'E');
		valueToCharacter.put(15 ,'F');
	}
	/**
	 * 
	 * @param str : contains a number in string form 
	 * @param base : base of number
	 * @return : decimal number
	 */
	int DecimalConversion(String str,int base){
		int decNum=0;
		//initialise local base j  with 1 ;base^0=1 
		int j=1;
		for(int i=str.length()-1;i>=0;--i){
			decNum += characterToValue.get(str.charAt(i)) * j;
			j = j*base;
		}
		return decNum;
	}
	/**
	 * 
	 * @param num : contains a number which is converted to different number form
	 * @param base : base in which we want to convert
	 * @return : string of number of required base
	 */
	String numConversion(int num,int base){
		//Initialse a empty string to store the conversion of decimal number to given base number
		StringBuffer str = new StringBuffer("");
		int temp = num;
		while(temp!=0){
			/*if(temp%base>=0 && temp%base<=9){
				//Converting to string 0 to 9 by adding 48 to ascii value
				str.append((char)(temp%base + 48));
				temp = temp/16;
			}
			else if(temp%base>=10 && temp%base<=15){
				//Converting to string A to F by adding 55 to ascii value
				str.append((char)(temp%base + 55));
				temp = temp/16;
			}*/
			str.append(valueToCharacter.get(temp%base));
			temp = temp/base;
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
	String add(String str1,String str2,int base){
		String sum;
		int add = DecimalConversion(str1, base) + DecimalConversion(str2, base);
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
	String sub(String str1,String str2,int base){
		String sub;
		int temp = DecimalConversion(str1, base) - DecimalConversion(str2, base);
		sub = numConversion(temp,base);
		return sub;
	}
	/**
	 * 
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @param base : base of number
	 * @return : multiplication of two number
	 */
	String mul(String str1,String str2,int base){
		String mul;
		int temp = DecimalConversion(str1, base) * DecimalConversion(str2, base);
		mul = numConversion(temp,base);
		return mul;
	}
	/**
	 * 
	 * @param str1 : 1 number in string form
	 * @param str2 : 2 number in string form
	 * @param base : base of number
	 * @return : division of two number
	 */
	String div(String str1,String str2,int base){
		String div;
		int temp = DecimalConversion(str1, base) / DecimalConversion(str2, base);
		div = numConversion(temp,base);
		return div;
	}
	/**
	 * 
	 * @param str : string from we want to remove leading zero
	 * @return : string of number without leading zero
	 */
	String removeLeadingZero(String str){
		int i = 0;
		while(i < str.length() && str.charAt(i)=='0'){
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
	int compare(String str1,String str2){
		String tempStr1 = removeLeadingZero(str1);
		String tempStr2 = removeLeadingZero(str2);
		if(tempStr1.length() > tempStr2.length()){
			return 1;
		}
		else if(tempStr1.length() < tempStr2.length()){
			return -1;
		}
		else{
			for(int i=0;i<tempStr1.length();i++){
				if(characterToValue.get(tempStr1.charAt(i)) > characterToValue.get(tempStr2.charAt(i)))
					return 1;
				else if(characterToValue.get(tempStr2.charAt(i)) > characterToValue.get(tempStr1.charAt(i)))
					return -1;
			}
		}
		return 0;
	}
}
