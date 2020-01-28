package com.numberOperation.logic;
/**
 * 
 * @author Rahul
 * Created 24 January 2020
 * Contains method for finding lcm of two numbers
 */
public class LCM {
	/**
	 * 
	 * @param firstNum : first number
	 * @param secondNum : second number
	 * @return : lcm of two number
	 */
	public static int lcm(int firstNum, int secondNum){
		int notGet = 1;
		int lcm = (firstNum > secondNum) ? firstNum : secondNum;
		while(notGet == 1){
			if( lcm % firstNum == 0 && lcm % secondNum == 0 ){
				notGet = 0;
				break;
			}
			++lcm;
		}
		return lcm;
	}

}
