package com.arrayOperation.test;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.arrayOperation.logic.ArrayOperation;

/**
 * 
 * @author Rahul
 * Created on 26 January 2020
 * Contains test cases for various array operations
 */
@RunWith(Parameterized.class)
public class TestForArrOperation {

	@Parameters
	public static Collection <Object[]> array()
	{
		return Arrays.asList(new Object[][]{
		{ new int[] {1, 2, 2, 3, 4, 4},new int[] {2, 4, 2}},
		{new int[] {1, 1, 2, 1, 1},new int[] {2, -1, 5}},
		{new int[] {1, 1, 1, 1, 1},new int[] {1, -1, 5}},
		{new int[] {1, 1, 1, 2, 1},new int[] {1, 3, 3}},
		{new int[] {10, 10},new int[] {1, 1, 2}},
		{new int[] {1, 2, 3, 8, 9, 3, 2, 1},new int[] {0, -1, 3}},
		{new int[] {7, 1, 4, 9, 7, 4, 1},new int[] {0, -1, 2}},
		{new int[] {1, 2, 1, 4},new int[] {0, 3, 3}},
		{new int[] {1, 4, 5, 3, 5, 4, 1},new int[] {0, -1, 7}},	
		});
	}
		
	private int[] input;
	private int[] expectedOutput;
	
	// Parameterized constructor to initialize input and expected values for testing.
	public  TestForArrOperation(int input[], int[] expectedOutput) {
		this.input = input;
		this.expectedOutput = expectedOutput;
	}
	
	@Test
	public void testCountClumps() {
	
		assertEquals(expectedOutput[0], ArrayOperation.countClumps(input));
	}
	
	@Test
	public void testSplitArray() {
			assertEquals(expectedOutput[1], ArrayOperation.splitArray(input));
		
	}
	
	
	@Test
	public void testMaxMirror() {
		
			assertEquals(expectedOutput[2], ArrayOperation.maxMirror(input));
	}

}
