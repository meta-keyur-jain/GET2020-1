package com.numberOperation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.numberOperation.logic.LCM;
/**
 * 
 * @author Rahul
 * Created 24 January 2020
 * Class contains test method for two numbers
 */
public class TestLcm {
	@Test
	public void lcmTestOne() {
		int res = LCM.lcm(7 , 5);
		assertEquals(res , 35);
	}
	
	@Test
	public void lcmTestTwo() {
		int res = LCM.lcm(15 , 20);
		assertEquals(res , 60);
	}
}
