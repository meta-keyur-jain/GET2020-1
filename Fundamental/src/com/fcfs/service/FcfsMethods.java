package com.fcfs.service;

/**
 * 
 * @author Rahul
 * Created 15 January 2020
 * Contains method for finding completion time , waiting time , turn around time for each process , 
 * and methods for average waiting time and maximum waiting time. 
 */

public class FcfsMethods {
	/**
	 * 
	 * @param process : contains 2D array of processes arrival time and burst time
	 * @return : array for completion time of each process 
	 */
	int[] completionTime(int[][] process){
		int[] completionTime = new int[process.length];
		for(int i = 0; i < process.length; i++){
			if(i - 1 >= 0)
				completionTime[i] = process[i][1] + completionTime[i-1]; 
			else
				completionTime[i] = process[i][1];
		}
		return completionTime;
	}
	/**
	 * 
	 * @param process : contains 2D array of processes arrival time and burst time
	 * @return : array for turnaround time of each process
	 * Turn Around Time = Completion Time - Arrival Time   
	 */
	int[] turnAroundTime(int[][] process){
		int[] completionTime = completionTime(process);
		int[] turnAroundTime = new int[process.length];
		for(int i = 0; i < process.length; i++){
			turnAroundTime[i] = completionTime[i] - process[i][0] ;
		}
		return turnAroundTime;
	}
	/**
	 * 
	 * @param process : contains 2D array of processes arrival time and burst time
	 * @return :  array for waiting time of each process
	 * Waiting Time = Turnaround time - Burst Time   
	 */
	int[] waitingTime(int[][] process){
		int[] turnAroundTime = turnAroundTime(process);
		int[] waitingTime = new int[process.length];
		for(int i = 0; i < process.length; i++){
			waitingTime[i] = turnAroundTime[i] - process[i][1] ;
		}
		return waitingTime;
	}
	/**
	 * 
	 * @param process :  contains 2D array of processes arrival time and burst time
	 * @return : average waiting time
	 * average = total waiting time / total number of process
	 */
	float averageWaitingTime(int[][] process){
		float average;
		float sumWaitingTime = 0;
		int[] waitingTime = waitingTime(process);
		for(int i = 0; i < process.length; i++){
			sumWaitingTime += waitingTime[i]; 
		}
		average = sumWaitingTime / process.length;
		return average;
	}
	/**
	 * 
	 * @param process : contains 2D array of processes arrival time and burst time
	 * @return : maximum waiting time
	 */
	int maxWaitingTime(int[][] process){
		int[] waitingTime = waitingTime(process);
		int max = waitingTime[0];
		for (int i = 1; i < waitingTime.length; i++){
			if (waitingTime[i] > max) 
				max = waitingTime[i]; 
		}
		return max;
	}
}
