package com.search.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.search.logic.Search;
/**
 * 
 * @author Rahul
 * Created 24 January 2020
 * Contains methods for testing linear search and binary search methods
 */

public class TestSearch {
	@Test
	public void positiveTestLinearSearchTest() {
		int res = Search.linearSearch(new int[] {16,7,2,5,9},5);
		assertEquals(res , 3);
	}
	
	@Test
	public void negativeTestLinearSearchTest() {
		int res = Search.linearSearch(new int[] {1,5,4,8,2}, 22);
		assertEquals(res , 0);
	}
	
	@Test
	//array required for binary search is sorted
	public void positiveTestBinarySearchTest() {
		int res = Search.binarySearch(new int[] {1, 4, 9, 6, 12, 23}, 4);
		assertEquals(res , 1);
	}
	
	@Test
	//array required for binary search is sorted
	public void NegativeTestBinarySearchTest() {
		int res = Search.binarySearch(new int[] {1,3,6,8,12,34,45}, 100);
		assertEquals(res , 0);
	}
}
