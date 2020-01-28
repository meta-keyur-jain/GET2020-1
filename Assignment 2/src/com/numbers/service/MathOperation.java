package com.numbers.service;

import java.util.Scanner;
/**
 * 
 * @author Rahul
 * Created 14 January 2020
 * Contains methods of getting data 
 * Contains methods for performing operation on data
 */
public class MathOperation {
	static Scanner sc = new Scanner(System.in);
	static int base = 10 ,option ,correctBase = 0, correctNum = 1;
	static String num1 = "" ,num2 = "";
	final static int ADD = 1, SUB = 2, MUL = 3, DIV = 4, COMPARE = 5, EXIT = 6;
	/**
	 * 
	 * @param numCalc : object of NumberCalci class
	 * perform operation to get data from user
	 */
	static void getData(NumberCalci numCalc){
		do{
			try {
				System.out.println(Messages.enterBase);
				base = sc.nextInt();
				if(base >= 2 && base <= 16){
					do{
						System.out.println(Messages.enterFirstNum);
						num1 = sc.next();
						if(numCalc.isValidNumberString(num1, base)){
							correctNum = 0;
							correctBase = 1;
						}
						else{
							correctNum = 1;
							correctBase = 0;
							System.out.println(Messages.validNum);
							continue;
						}
					}while(correctNum == 1);
					do{
						System.out.println(Messages.enterSecondNum);
						num2 = sc.next();
						if(numCalc.isValidNumberString(num2, base)){
							correctNum = 1;
							correctBase = 1;
						}
						else{
							correctNum = 0;
							correctBase = 0;
							System.out.println(Messages.validNum);
							continue;
						}
					}while(correctNum == 0);
				}
				else{
					System.out.println(Messages.baseRange);
				}
			} catch (Exception e) {
				System.out.println(Messages.invalidBase);
				sc.nextLine();
			}
		}while(correctBase == 0);
	}
	/**
	 * 
	 * @param numCalc : object of NumberCalci class
	 * Perform operation on data
	 */
	static void operationOnData(NumberCalci numCalc){
		do{
			try {
				System.out.println("Options :"+"\n"+"1: Addition"+"\n"+"2: Subtraction"+"\n"+"3: Multiplication"+"\n"+"4: Division"+"\n"+"5: Compare two number"+"\n"+"6: Exit");
				System.out.println(Messages.enterOption);
				option = sc.nextInt();
				//System.out.println("number 1 is:"+num1+"number 2 is"+num2+"base: "+base);
				switch(option){
				case ADD:
					System.out.println("The addition of two number is :"+ numCalc.add(num1,num2,base));
					break;
				case SUB:
					System.out.println("The subtraction of two number is :"+ numCalc.sub(num1,num2,base));
					break;
				case MUL:
					System.out.println("The multiplication of two number is :"+ numCalc.mul(num1,num2,base));
					break;
				case DIV:
					System.out.println("The division of two number is :"+ numCalc.div(num1,num2,base));
					break;
				case COMPARE:
					if(numCalc.compare(num1,num2) == 1)
						System.out.println(num1 + " is greater than " + num2);
					else if(numCalc.compare(num1,num2) == -1)
						System.out.println(num1 + " is lesser than " + num2);
					else
						System.out.println(Messages.equal);
					break;
				case EXIT:
					sc.close();
					System.out.println(Messages.thankYou);
					System.exit(0);
					break;
				default:
					System.out.println(Messages.validOption);
				}
			} catch (Exception e) {
				System.out.println(Messages.invalidEntry);
				sc.nextLine();
			}
		}while(true);
	}
}
