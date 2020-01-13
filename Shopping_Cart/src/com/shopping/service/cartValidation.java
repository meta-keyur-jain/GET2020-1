package com.shopping.service;

/**
 * 
 * @author Rahul
 * Contains required cart validation 
 */
public class cartValidation {
	public int quantityValidation(int quantity){
		if(quantity > 10){
			quantity = 10;
			System.out.println(cartMessage.quantityGreaterAlert);
			return quantity;
		}
		else
			return quantity;
	}
}
