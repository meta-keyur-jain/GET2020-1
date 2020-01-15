package com.shopping.bean;
import com.shopping.service.*;

/**
 * 
 * @author Rahul
 * Created 10 January 2020
 * Contains items variables and getter setter method 
 */
public class Item {
	cartValidation quantityValidation = new cartValidation();
	private double price;
	private int quantity;
	private String name;

	public Item(String name,int price){
		this.price = price;
		this.name = name;
	}
	
	public double getPrice() {
		return price;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantityValidation.quantityValidation(quantity);
	}
	public String getName() {
		return name;
	}
}

