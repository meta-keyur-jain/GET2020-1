package com.string.service;

import java.util.Scanner;

import com.project.messages.*;
/**
 * 
 * @author Rahul
 * Created 16 January 2020
 * Contains various operations to perform on string
 *
 */
public class StringOperation {
	/**
	 * 
	 * @param strMethod : object of StringMethods
	 * 
	 */
	public static void operation(StringMethods strMethod){
		Scanner sc = new Scanner(System.in);
		int operation;
		String str ,str1 ,str2;
		final int CMP_STRING = 1, REV_STRING = 2, CONV_CASE = 3, FIND_LARG_WORD = 4, EXIT = 5;
		while(true){
			int invalidInput = 0;
			try {
				System.out.println("Enter the operation of string");
				System.out.println("Options :"+"\n"+"1: Compare two string"+"\n"+"2: Reverse a string"+"\n"+"3: Convert lowercase to uppercase and vice versa"+"\n"+"4: Find largest word from string"+"\n"+"5: Exit");
				operation = sc.nextInt();
				sc.nextLine();
				switch(operation){
				case CMP_STRING :
					while(invalidInput == 0){
						try {
							System.out.println(stringMessage.firstString);
							//str1 = sc.next();
							str1 = sc.nextLine();
							System.out.println(stringMessage.secondString);
							str2 = sc.nextLine();
							if(strMethod.compareStrings(str1, str2) != 0)
								System.out.println(stringMessage.equal);
							else
								System.out.println(stringMessage.notEqual);
							invalidInput = 1; 
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case REV_STRING :
					while(invalidInput == 0){
						try {
							System.out.println(stringMessage.enterString);
							str = sc.nextLine();
							//sc.nextLine();
							System.out.println("The reversed string is:"+strMethod.reverseString(str));
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case CONV_CASE :
					while(invalidInput == 0){
						try {
							System.out.println(stringMessage.caseConvString);
							str = sc.nextLine();
							//sc.nextLine();
							System.out.println("The new string is:"+strMethod.caseConversion(str));
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case FIND_LARG_WORD :
					while(invalidInput == 0){
						try {
							System.out.println(stringMessage.stringLargWord);
							str = sc.nextLine();
							//sc.nextLine();
							System.out.println("The largest word in string is:"+strMethod.largestWord(str));
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case EXIT :
					System.out.println(messages.thankYou);
					System.exit(0);
					sc.close();
				default :
					System.out.println(stringMessage.invalidEntry);
				}
			} catch (Exception e) {
				System.out.println(stringMessage.invalidOperation);
				sc.nextLine();
			}
		}
	}
}
