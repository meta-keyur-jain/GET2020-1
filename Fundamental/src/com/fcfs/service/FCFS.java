package com.fcfs.service;

import java.util.Scanner;
/**
 * 
 * @author Rahul
 * Created 15 January 2020
 * Provide complete functionality of FCFS scheduler
 */

public class FCFS {
	public static void main(String srgs[]){
		FcfsMethods scheduler = new FcfsMethods(); 
		Scanner sc = new Scanner(System.in);
		int numProcess=0 ,processTimes=2 ,option ,flag=0;
		do{
			try {
				System.out.println("Enter the number of process:");
				numProcess = sc.nextInt();
				flag=1;
			} catch (Exception e) {
				System.out.println(FcfsMessage.invalidProcessNum);
			}
			sc.nextLine();
		}while(flag==0);
		int[][] process = new int[numProcess][processTimes];
		do{
			try {
				for(int i=0;i<numProcess;i++){
					System.out.println("Enter arrival time and burst time for process:"+(i+1));
					for(int j=0;j<processTimes;j++){
						process[i][j] = sc.nextInt();
					}
				flag=0;
				}
			} catch (Exception e) {
				System.out.println(FcfsMessage.invalidEntry);
			}
			sc.nextLine();
		}while(flag==1);
		do{
			System.out.println("Options :"+"\n"+"1: Find completion time for each process"+"\n"+"2: Find turn around time for each process"+"\n"+"3: Find waiting time for each process"+"\n"+"4: Find average waiting time"+"\n"+"5: Find Maximum waiting time period for a process in queue"+"\n"+"6: Exit");
			System.out.println("Enter option:");
			try {
				option = sc.nextInt();
				switch(option){
					case 1:
						System.out.println("Completion time for each process is :");
						int[] completionTime = scheduler.completionTime(process);
						for(int i=0;i<process.length;i++){
							System.out.println("Process"+(i+1)+":"+completionTime[i]);
						}
						break;
					case 2:
						System.out.println("TurnAround time for each process is :");
						int[] turnAroundTime = scheduler.turnAroundTime(process);
						for(int i=0;i<process.length;i++){
							System.out.println("Process"+(i+1)+":"+turnAroundTime[i]);
						}
						break;
					case 3:
						System.out.println("Waiting time for each process is :");
						int[] waitingTime = scheduler.waitingTime(process);
						for(int i=0;i<process.length;i++){
							System.out.println("Process"+(i+1)+":"+waitingTime[i]);
						}
						break;
					case 4:
						System.out.println("Average waiting time for processes is :");
						System.out.println(scheduler.averageWaitingTime(process));
						break;
					case 5:
						System.out.println("Maximum waiting time for processes in queue is :");
						System.out.println(scheduler.maxWaitingTime(process));
						break;
					case 6:
						flag=1;
						break;
					default:
						System.out.println("Enter valid option!!");
				}
			} catch (Exception e) {
				System.out.println(FcfsMessage.invalidEntry);
			}
			sc.nextLine();
		}while(flag==0);
		sc.close();
	}

}
