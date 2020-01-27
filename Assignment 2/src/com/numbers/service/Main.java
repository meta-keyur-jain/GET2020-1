package com.numbers.service;

/**
 * 
 * @author Rahul
 * Created 14 January 2020 
 * Main class contains varoius operations of number system
 */

public class Main {
	public static void main(String args[]){
		NumberCalci numCalc = new NumberCalci();
		numCalc.setDefaultValue();
		MathOperation.get_data(numCalc);
		MathOperation.operationOnData(numCalc);
	}
}
