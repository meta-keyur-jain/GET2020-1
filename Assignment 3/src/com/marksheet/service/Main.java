package com.marksheet.service;

/**
 * 
 * @author Rahul
 * Created 16 January 2020
 * Contains operations of grades of students on marksheet
 */
public class Main {
	public static void main(String args[]){
		MarksheetMethods method = new MarksheetMethods();
		MarksheetOperation.storeData(method);
		MarksheetOperation.operation(method);
	}
}
