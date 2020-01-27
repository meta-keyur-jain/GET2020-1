package com.fcfs.service;

import java.util.Scanner;
/**
 * 
 * @author Rahul
 * Created 15 January 2020
 * Contains method for getting data from user
 * Contains method for performing operation of FCFS scheduler
 */
public class FcfsOperation {
	static Scanner sc = new Scanner(System.in);
	static int numProcess = 0, processTimes = 2, option, invalidNum = 0;
	static int[][] process;
	/**
	 * Getting data from users
	 * @param scheduler : object of FcfsMethods
	 */
	static void get_data(FcfsMethods scheduler){
		do{
			try {
				System.out.println(FcfsMessage.enterProcess);
				numProcess = sc.nextInt();
				if(numProcess > 0){
					invalidNum = 1;
				}
				else{
					System.out.println(FcfsMessage.invalidProcessNum);
				}
			} catch (Exception e) {
				System.out.println(FcfsMessage.invalidProcessNum);
			}
			sc.nextLine();
		}while(invalidNum == 0);
		process = new int[numProcess][processTimes];
		do{
			try {
				for(int i = 0; i < numProcess; i++){
					System.out.println(FcfsMessage.arrivalAndBurst + (i + 1));
					for(int j = 0; j < processTimes; j++){
						process[i][j] = sc.nextInt();
					}
					invalidNum = 0;
				}
			} catch (Exception e) {
				invalidNum = 1;
				System.out.println(FcfsMessage.invalidEntry);
			}
			sc.nextLine();
		}while(invalidNum == 1);
	}
	/**
	 * 
	 * @param scheduler : object of FcfsMethods
	 * Perform operations of FCFS scheduler
	 */
	static void Operation(FcfsMethods scheduler){
		do{
			System.out.println("Options :"+"\n"+"1: Find completion time for each process"+"\n"+"2: Find turn around time for each process"+"\n"+"3: Find waiting time for each process"+"\n"+"4: Find average waiting time"+"\n"+"5: Find Maximum waiting time period for a process in queue"+"\n"+"6: Exit");
			System.out.println("Enter option:");
			try {
				option = sc.nextInt();
				switch(option){
				case 1:
					System.out.println(FcfsMessage.completionTime);
					int[] completionTime = scheduler.completionTime(process);
					for(int i = 0; i < process.length; i++){
						System.out.println("Process" + ( i + 1) +":" + completionTime[i]);
					}
					break;
				case 2:
					System.out.println(FcfsMessage.turnAroundTime);
					int[] turnAroundTime = scheduler.turnAroundTime(process);
					for(int i  = 0; i < process.length; i++){
						System.out.println("Process" + ( i + 1) +":" + turnAroundTime[i]);
					}
					break;
				case 3:
					System.out.println(FcfsMessage.waitingTime);
					int[] waitingTime = scheduler.waitingTime(process);
					for(int i = 0; i < process.length; i++){
						System.out.println("Process" + (i + 1) +":" + waitingTime[i]);
					}
					break;
				case 4:
					System.out.println(FcfsMessage.averageTime);
					System.out.println(scheduler.averageWaitingTime(process));
					break;
				case 5:
					System.out.println(FcfsMessage.maximumWaitingTime);
					System.out.println(scheduler.maxWaitingTime(process));
					break;
				case 6:
					System.out.println(FcfsMessage.thankYou);
					invalidNum = 1;
					break;
				default:
					System.out.println(FcfsMessage.enterValidOption);
				}
			} catch (Exception e) {
				System.out.println(FcfsMessage.invalidEntry);
			}
			sc.nextLine();
		}while(invalidNum == 0);
	}

}
