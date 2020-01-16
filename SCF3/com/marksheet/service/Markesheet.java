package com.marksheet.service;
import java.util.Scanner;
/**
 * 
 * @author Rahul
 * Created 16 January 2020
 * Contains operations of grades of students on marksheet
 */
public class Markesheet {
	public static void main(String args[]){
		MarksheetMethods method = new MarksheetMethods();
		int numStudent = 0 ,option = 0 ,invalidInput = 0;
		Scanner sc = new Scanner(System.in);
		int[] studentsGrades = new int[numStudent];
		while(invalidInput == 0){
			try {
				System.out.println(marksheetMessage.enterNumStudent);
				numStudent = sc.nextInt();
				studentsGrades = new int[numStudent];
				System.out.println("Ënter grades between 0 to 100 :");
				int i = 0;
				while(i != numStudent){
					System.out.println("Student"+(i+1));
					studentsGrades[i] = sc.nextInt();
					if(studentsGrades[i] >= 0 && studentsGrades[i] <= 100){
						i++;
					}
					else
						System.out.println(marksheetMessage.invalidGrades);
				}
				invalidInput = 1;
			} catch (Exception e) {
				System.out.println(marksheetMessage.invalidEntry);
				sc.nextLine();
			}
		}
		while(true){
			System.out.println(marksheetMessage.enterOption);
			System.out.println("Options :"+"\n"+"1: Average of grade of students"+"\n"+"2: Maximum grade from all grades"+"\n"+"3: Minimum grades from all grades"+"\n"+"4: Percentage of student pass"+"\n"+"5: Exit");
			option = sc.nextInt();
			switch(option){
			case 1:
				System.out.println("The average grade of student is:"+method.averageGrade(studentsGrades, numStudent));
				break;
			case 2:
				System.out.println("Maximum grade from all students is:"+method.maxGrade(studentsGrades, numStudent));
				break;
			case 3:
				System.out.println("Minimum grade from all student is:"+method.minGrade(studentsGrades, numStudent));
				break;
			case 4:
				System.out.println("The percentage of student passed is:"+method.percentPass(studentsGrades, numStudent));
				break;
			case 5:
				sc.close();
				System.exit(0);
			default :
				System.out.println(marksheetMessage.invalidEntry);
			}
		}
	}
}
