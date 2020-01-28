package com.numberOperation.logic;
/**
 * 
 * @author Rahul
 * Created 24 January 2020
 * Class which contains method for finding hcf
 */
public class HCF {
	/**
	 * @param firstNum
	 * @param secondNum
	 * @return : hcf of two numbers using Euclid’s algorithm
	 */
	public static int hcf(int firstNum, int secondNum) 
    { 
		if (secondNum == 0)
			return firstNum;
		else 
			return hcf(secondNum, firstNum % secondNum);
    } 
}
