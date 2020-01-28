package com.numberOperation.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.numberOperation.logic.HCF;
/**
 * 
 * @author Rahul
 * 24 January 2020
 * Class contains test methods for hcf of two numbers
 */
public class TestHcf {
	@Test
	public void hcfTestOne() {
		int res = HCF.hcf(36 , 60);
		assertEquals(res , 12);
	}

	@Test
	public void hcfTestTwo() {
		int res = HCF.hcf(98 , 56);
		assertEquals(res , 14);
	}
}
