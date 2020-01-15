package com.numbers.service;

import java.util.Scanner;

public class MathOperation {
	public static void main(String args[]){
		NumberCalc numCalc = new NumberCalc();
		numCalc.setDefaultValue();
		Scanner sc=new Scanner(System.in);
		int base ,option;
		String num1 ,num2;
		System.out.println("Enter the base of number :");
		base = sc.nextInt();
		System.out.println("Enter first number :");
		num1 = sc.next();
		System.out.println("Enter second number :");
		num2 = sc.next();
		do{
			System.out.println("Options :"+"\n"+"1: Addition"+"\n"+"2: Subtraction"+"\n"+"3: Multiplication"+"\n"+"4: Division"+"\n"+"5: Compare two number"+"\n"+"6: Exit");
			System.out.println("Enter the option which you want to perform");
			option = sc.nextInt();
			switch(option){
				case 1:
					System.out.println("The addition of two number is :"+ numCalc.add(num1,num2,base));
					break;
				case 2:
					System.out.println("The subtraction of two number is :"+ numCalc.sub(num1,num2,base));
					break;
				case 3:
					System.out.println("The multiplication of two number is :"+ numCalc.mul(num1,num2,base));
					break;
				case 4:
					System.out.println("The subtraction of two number is :"+ numCalc.div(num1,num2,base));
					break;
				case 5:
					if(numCalc.compare(num1,num2) == 1)
						System.out.println(num1+" is greater than "+num2);
					else if(numCalc.compare(num1,num2) == -1)
						System.out.println(num1+" is lesser than "+num2);
					else
						System.out.println("Both are equal");
					break;
				case 6:
					System.exit(0);
					break;
				default:
					System.out.println("Enter valid option");
			}
		}while(true);
	}
}
