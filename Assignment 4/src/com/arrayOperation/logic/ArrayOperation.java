package com.arrayOperation.logic;

import java.util.ArrayList;

/**
 * @author Rahul
 * Created on 26 January 2020
 * Contains various methods for array to find maximum mirror in array, to split array ,
 *  to find fix X Y, and to count clumps in array
 */
public class ArrayOperation {
	/**
	 *  method to reverse array
	 * @param arr : array which is to be reversed
	 * @return : reverse array
	 */
	public static int[] reverseArray(int[] arr){
		int tempLength = arr.length;
		int[] rev = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			rev[tempLength - 1] = arr[i];
			tempLength--;
		}
		return rev;
	}
	/**
	 * 
	 * @param arr : array from which we want to find max mirror
	 * @return : maxMirror 
	 */
	public static int maxMirror(int[] arr){
		if(arr.length == 0){
			throw new AssertionError("Array is empty !!");
		}
		int length = arr.length, loop = 0, count = 0, maxMirror = 0;
		int[] rev = reverseArray(arr);
		for(int i = 0; i < length; i++){
			loop = 0;
			int temp = i;
			count = 0;
			while(loop < length && temp < length){
				if(arr[temp] == rev[loop]){
					count++;
					temp++;
					loop++;
				}
				else {
					if(count > maxMirror){
						maxMirror = count;
					}
					count = 0;
					if(rev[loop] == arr[i]) {
						temp = i+1;
						count += 1;
					} 
					else {
						temp = i;
					}
					loop ++;
				}
			}	
			if(count > maxMirror)
				maxMirror = count;
		}
		return maxMirror;
	}
	/**
	 * 
	 * @param arr : array from which we want to find max mirror
	 * @return : number of clumps in array
	 */
	public static int countClumps(int[] arr){
		if(arr.length == 0){
			throw new AssertionError("Array Should not be Empty!");
		}
		int count = 0, clumps = 0;
		for(int i = 0; i < arr.length; i++){
			if(i + 1 <= arr.length - 1 && arr[i] == arr[i + 1]){
				count ++;
			}
			else
				count = 0;
			if(count == 1){
				clumps ++;
			}

		}
		return clumps;
	}
	/**
	 * Return the index if there is a place to split the input array
	 * so that the sum of the numbers on one side is equal to the sum of 
	 * the numbers on the other side else return -1
	 * @param arr : array in which we want to perform operation
	 * @return : index from which we split the array
	 */
	public static int splitArray(int[] arr){
		if(arr.length == 0)
			throw new AssertionError("Array Should not be Empty!");
		int arrSum = 0, tempSum = 0;
		for(int i = 0; i < arr.length; i++){
			arrSum += arr[i];
		}
		if(arrSum % 2 == 0){
			for(int i = 0; i < arr.length; i++){
				tempSum += arr[i];
				if(arrSum - tempSum == arrSum/2){
					return i + 1;
				}
			}
		}
		return -1;

	}
	/**
	 * Return an array that contains exactly the same numbers as the input array,
	 * but rearranged so that every X is immediately followed by a Y.
	 * Do not move X within array, but every other number may move
	 * @param x : value of x
	 * @param y : value of y
	 * @param arr : array in which we want to perform operation
	 * @return : new arranged array
	 * 
	 */
	public static int[] fixXY(int[] arr, int x, int y){
		if(arr.length == 0)
			throw new AssertionError("Array Should not be empty");
		else if (arr[arr.length - 1] == x)
			throw new AssertionError("Last value of Array should not be equal to x");
		else{
			ArrayList<Integer> indexOfUserValue = new ArrayList<Integer>();
			ArrayList<Integer> indexOfChangedValue = new ArrayList<Integer>();
			int[] answer = arr.clone();
			for(int i = 0; i < arr.length; i++){
				if(arr[i] == y){
					indexOfUserValue.add(i);
				}
				if(arr[i] == x){
					if(i + 1 < arr.length){
						indexOfChangedValue.add(i+1);
					}
				}
			}
			if(indexOfChangedValue.size() == indexOfUserValue.size()){
				for(int i = 0; i < indexOfChangedValue.size(); i++){
					int temp;
					temp = answer[indexOfChangedValue.get(i)];
					answer[indexOfChangedValue.get(i)] = answer[indexOfUserValue.get(i)];
					answer[indexOfUserValue.get(i)] = temp;
				}
			}
			else
				throw new AssertionError(" The number of x and y are should be equals in Array");
			return answer;
		}
	}
	
}
