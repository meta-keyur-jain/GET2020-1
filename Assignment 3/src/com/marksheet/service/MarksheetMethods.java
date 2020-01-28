package com.marksheet.service;
/**
 * 
 * @author Rahul
 * Created 16 January 2020
 * Contains methods for marksheet such as average grades of students , maximum grade
 * , minimum grade from all students , percentage of students pass (grade >= 40 is consider pass)
 */
public class MarksheetMethods {
	/**
	 * 
	 * @param arr : grades of all students
	 * @param numStudent : total number of student
	 * @return : average grade of student
	 */
	float averageGrade(float[] arr ,int numStudent){
		float average = 0;
		int sumGrades = 0;
		for(int i=0; i<numStudent; i++){
			sumGrades += arr[i];
		}
		average = (float)sumGrades / (float)numStudent;
		return average;
	}
	/**
	 * 
	 * @param arr :  grades of all students
	 * @param numStudent : total number of student
	 * @return : maximum grade from student
	 */
	float maxGrade(float[] arr ,int numStudent){
		float max = 0;
		for(int i=0; i<numStudent; i++){
			if(arr[i] > max)
				max = arr[i];
		}
		return max;
	}
	/**
	 * 
	 * @param arr :  grades of all students
	 * @param numStudent : total number of student
	 * @return : minimum grade from student
	 */
	float minGrade(float[] arr ,int numStudent){
		float min = arr[0];
		for(int i=0;i<numStudent;i++){
			if(arr[i] < min)
				min = arr[i];
		}
		if(min == -0){
			return 0;
		}
		return min;
	}
	/**
	 * 
	 * @param arr : array of students grades
	 * @param numStudent : number of student
	 * @return : percentage of passing students
	 */
	float percentPass(float[] arr ,int numStudent){
		int count = 0;
		float percentage;
		for(int i=0; i<numStudent; i++){
			if(arr[i] >= 40)
				count++;
		}
		percentage = (float)count / numStudent;
		return percentage * 100;
	}
}
