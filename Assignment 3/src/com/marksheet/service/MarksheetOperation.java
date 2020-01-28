package com.marksheet.service;

import java.util.Scanner;

import com.project.messages.*;
/**
 * 
 * @author Rahul
 * Created 16 January 2020
 * Contains various methods to store data of marksheet by user and 
 * also contains method to perform operations of marksheet
 */
public class MarksheetOperation {
	static int numStudent = 0 ,option = 0 ,invalidInput = 0, invalidGrade = 0;
	static Scanner sc = new Scanner(System.in);
	static float[] studentsGrades = new float[numStudent];
	static final int AVERAGE_GRADE_OF_STUDENT = 1, MAX_GRADE_OF_STUDENT = 2, MIN_GRADE_OF_STUDENT = 3, PERCENT_STUDENT_PASS = 4, EXIT = 5;
	/**
	 * methods to store data for marksheet
	 * @param method object of MarksheetMethods 
	 * 
	 */
	public static void storeData(MarksheetMethods method){
		while(invalidInput == 0){
			try {
				System.out.println(marksheetMessage.enterNumStudent);
				numStudent = sc.nextInt();
				if(numStudent == 0){
					System.out.println(marksheetMessage.studentRange);
				}
				else{
					studentsGrades = new float[numStudent];
					System.out.println(marksheetMessage.enterGrades);
					int i = 0;
					while(invalidGrade == 0){
						try {
							while(i < numStudent){
								System.out.println("Student"+ (i + 1));
								studentsGrades[i] = sc.nextFloat();
								if(studentsGrades[i] >= 0 && studentsGrades[i] <= 100){
									i++;
								}
								else
									System.out.println(marksheetMessage.invalidGrades);
							}
							invalidGrade = 1;
						} catch (Exception e) {
							System.out.println("wrong input");
							invalidGrade = 0;
							sc.nextLine();
						}
					}
					invalidInput = 1;
				}
			} catch (Exception e) {
				System.out.println(marksheetMessage.invalidEntry);
				sc.nextLine();
			}
		}
	}
	/**
	 *  method to do operation on marksheet
	 * @param method  method object of MarksheetMethods 
	 */
	public static void operation(MarksheetMethods method){
		do{
			try {
				System.out.println(marksheetMessage.enterOption);
				System.out.println("Options :"+"\n"+"1: Average of grade of students"+"\n"+"2: Maximum grade from all grades"+"\n"+"3: Minimum grades from all grades"+"\n"+"4: Percentage of student pass"+"\n"+"5: Exit");
				option = sc.nextInt();
				switch(option){
				case AVERAGE_GRADE_OF_STUDENT:
					System.out.println("The average grade of student is:"+method.averageGrade(studentsGrades, numStudent));
					break;
				case MAX_GRADE_OF_STUDENT:
					System.out.println("Maximum grade from all students is:"+method.maxGrade(studentsGrades, numStudent));
					break;
				case MIN_GRADE_OF_STUDENT:
					System.out.println("Minimum grade from all student is:"+method.minGrade(studentsGrades, numStudent));
					break;
				case PERCENT_STUDENT_PASS:
					System.out.println("The percentage of student passed is:"+method.percentPass(studentsGrades, numStudent));
					break;
				case EXIT:
					sc.close();
					System.out.println(messages.thankYou);
					System.exit(0);
				default :
					System.out.println(marksheetMessage.invalidEntry);
				}
			} catch (Exception e) {
				sc.nextLine();
				System.out.println(marksheetMessage.invalidEntry);
			}
		}while(invalidInput == 1);
	}
}
