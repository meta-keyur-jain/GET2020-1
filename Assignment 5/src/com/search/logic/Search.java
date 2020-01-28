package com.search.logic;

public class Search {
	/**
	 * 
	 * @param arr : array from which we have to search element
	 * @param element : element which have to be searched in array
	 * @return : index of element if found and if not found than return 0
	 */
	public static int linearSearch(int[] arr, int element){	
		return finalLinearSearch(arr, element, 0);
	}
	/**
	 * 
	 * @param arr : array from which we have to search element
	 * @param element : element which have to be searched in array
	 * @param index : index from we have to start searching 
	 * @return index of element if found and if not found than return 0
	 */
	public static int finalLinearSearch(int[] arr, int element, int index){
		if(index >= arr.length){
			return 0;
		}
		else if(arr[index] == element){
			return index;
		}
		else
			return finalLinearSearch(arr, element, index + 1);
	}
	/**
	 * 
	 * @param arr : array from which we have to search element
	 * @param element : element which have to be searched in array
	 * @return : index of element if found and if not found than return 0
	 */
	public static int binarySearch(int[] arr, int element){
		int left = 0, right = arr.length -1 ;
		return finalbinarySearch(arr, left, right, element);
	}
	/**
	 * 
	 * @param arr : array from which we have to search element
	 * @param left : starting index of subarray in which element is present 
	 * @param right : last index of subarray in which element is present 
	 * @param element : element which have to be searched in array
	 * @return : index of element if found and if not found than return 0
	 */
	public static int finalbinarySearch(int arr[], int left, int right, int element) 
	{ 
		if(left > right )
			return 0;
		int mid = left + (right - left) / 2; 

		// If element is present at the middle itself 
		if (arr[mid] == element) 
			return mid; 

		// element is smaller than mid, then it can be present in left subarray 
		if (arr[mid] > element) 
			return finalbinarySearch(arr, left, mid - 1, element); 

		// element can only be present in right subarray 
		else if(arr[mid] < element)
			return finalbinarySearch(arr, mid + 1, right, element); 
		// when element is not present it returns 0 
		else
			return 0; 
	} 
}
