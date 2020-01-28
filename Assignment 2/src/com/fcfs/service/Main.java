package com.fcfs.service;

/**
 * 
 * @author Rahul
 * Created 15 January 2020
 * Provide complete functionality of FCFS scheduler
 */

public class Main {
	public static void main(String srgs[]){
		FcfsMethods scheduler = new FcfsMethods(); 
		FcfsOperation.getData(scheduler);
		FcfsOperation.Operation(scheduler);
	}
}
