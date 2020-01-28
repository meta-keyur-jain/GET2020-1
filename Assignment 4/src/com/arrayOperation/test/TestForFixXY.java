package com.arrayOperation.test;
import static org.junit.Assert.*;

import org.junit.Test;

import com.arrayOperation.logic.ArrayOperation;
/**
 * 
 * @author Rahul
 * Created 26 January 2020
 * Contains various methods for array on fix X Y problem
 */
public class TestForFixXY{
	

	@Test
	public void positivefixXYTestOne() {
			assertArrayEquals(new int[] {1, 1, 2, 1, 1}, ArrayOperation.fixXY(new int[] {1, 1, 2, 1, 1}, 4, 5));
	}
	
	@Test
	public void positivefixXYTestTwo() {
		assertArrayEquals(new int[] {1, 4, 5, 1, 1, 4, 5}, ArrayOperation.fixXY(new int[] {1, 4, 1, 5, 5, 4, 1 }, 4, 5));
	}
	
	@Test
	public void positivefixXYTestThird() {
		assertArrayEquals(new int[] {1, 4, 5, 1}, ArrayOperation.fixXY(new int[] { 1, 4, 1, 5}, 4, 5));
	}
	
	@Test
	public void positivefixXYTestFour() {
		assertArrayEquals(new int[] {9, 4, 5, 4, 5, 9}, ArrayOperation.fixXY( new int[] {5, 4, 9, 4, 9, 5}, 4, 5));
	}
	
	
	@Test(expected = AssertionError.class)
	public void emptyArray() {
		assertArrayEquals(new int[] {}, ArrayOperation.fixXY(new int[] {}, 4, 5));
	}
	
	@Test(expected = AssertionError.class)
	public void adjacentX() {
		assertArrayEquals(new int[] {}, ArrayOperation.fixXY(new int[] {1, 4, 4, 3, 5, 6, 5 }, 4, 5));
	}
	
	@Test(expected = AssertionError.class)
	public void differentXandY() {
		assertArrayEquals(new int[] {}, ArrayOperation.fixXY(new int[] {1, 4, 3, 5, 6, 5 }, 4, 5));
	}
	
	@Test(expected = AssertionError.class)
	public void xAtLast() {
		assertArrayEquals(new int[] {}, ArrayOperation.fixXY(new int[] {1, 4, 5, 5, 6, 4 }, 4, 5));
	}
	
	
}
