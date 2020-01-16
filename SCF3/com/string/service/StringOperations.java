package com.string.service;

import java.util.Scanner;
/**
 * 
 * @author Rahul
 *Created 16 January 2020
 *Contains various operations performed on string
 */

public class StringOperations {
	public static void main(String args[]){
		StringMethods strMethod = new StringMethods();
		Scanner sc = new Scanner(System.in);
		int operation;
		String str ,str1 ,str2;
		while(true){
			int flag = 0;
			try {
				System.out.println("Enter the operation of string");
				System.out.println("Options :"+"\n"+"1: Compare two string"+"\n"+"2: Reverse a string"+"\n"+"3: Convert lowercase to uppercase and vice versa"+"\n"+"4: Find largest word from string"+"\n"+"5: Exit");
				operation = sc.nextInt();
				sc.nextLine();
				switch(operation){
				case 1 :
					while(flag == 0){
						try {
							System.out.println("Enter the 1st string");
							//str1 = sc.next();
							str1 = sc.nextLine();
							System.out.println("Enter the 2nd string");
							str2 = sc.nextLine();
							if(strMethod.compareStrings(str1, str2) != 0)
								System.out.println("Both are equal");
							else
								System.out.println("Both are not equal");
							flag = 1; 
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case 2 :
					while(flag == 0){
						try {
							System.out.println("Enter the string which have to be reversed");
							str = sc.nextLine();
							//sc.nextLine();
							System.out.println("The reversed string is:"+strMethod.reverseString(str));
							flag = 1;
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case 3 :
					while(flag == 0){
						try {
							System.out.println("Enter the string which cases to be converted ");
							str = sc.nextLine();
							//sc.nextLine();
							System.out.println("The new string is:"+strMethod.caseConversion(str));
							flag = 1;
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case 4 :
					while(flag == 0){
						try {
							System.out.println("Enter the string which largest word to be find ");
							str = sc.nextLine();
							//sc.nextLine();
							System.out.println("The largest word in string is:"+strMethod.largestWord(str));
							flag = 1;
						} catch (Exception e) {
							System.out.println(stringMessage.invalidString);
							sc.nextLine();
						}
					}
					break;
				case 5 :
					System.exit(0);
					sc.close();
				default :
					System.out.println("Invalid!! entry");
				}
			} catch (Exception e) {
				System.out.println("Ënter valid operation");
				sc.nextLine();
			}
		}
	}
}
