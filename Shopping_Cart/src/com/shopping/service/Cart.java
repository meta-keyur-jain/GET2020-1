package com.shopping.service;
import com.shopping.bean.*;
import java.util.HashMap;
/**
 * 
 * 
 * @author Rahul
 * Created 10 January 2020
 * Cart for adding products
 * Contains methods for adding items , view cart , generate bill , edit items , remove item , show available items 
 * 
 */
public class Cart {
	/**
	 * Map for product id and products object which contain detail about product
	 */
	HashMap<Integer, Item> products = new HashMap<Integer,Item>();	
	/**
	 * Map for product id and products object which are in the cart of user
	 */
	HashMap<Integer,Item> userCart =new HashMap<Integer,Item>(); 
	/**
	 * Method for creating items in the ecommerce
	 */
	void availableItems(){
		Item prod1 = new Item("Candy",40);
		Item prod2 = new Item("Bread",30);
		Item prod3 = new Item("Butter",50);
		Item prod4 = new Item("Milk",43);
		Item prod5 = new Item("Toast",60);
		Item prod6 = new Item("Curd",20);
		Item prod7 = new Item("Cream",80);
		Item prod8 = new Item("Pastry",45);
		Item prod9 = new Item("Cake",300);
		Item prod10 = new Item("Panner",200);
		Item prod11 = new Item("Egg",8);
		products.put(1,prod1);
		products.put(2,prod2);
		products.put(3,prod3);
		products.put(4,prod4);
		products.put(5,prod5);
		products.put(6,prod6);
		products.put(7,prod7);
		products.put(8,prod8);
		products.put(9,prod9);
		products.put(10,prod10);
		products.put(11,prod11);
	}
	/**
	 * Method for showing the items added in user cart
	 */
	void showItem(){
		availableItems();
		System.out.println("Id" +" \t \t"+ "Item Name" +" \t"+ "Price");
		for (HashMap.Entry<Integer,Item> entry : products.entrySet()){
			System.out.println(entry.getKey() +" \t \t"+entry.getValue().getName()+" \t \t"+ entry.getValue().getPrice());
		}
	}
	/**
	 * For adding items in user cart.
	 * @param id Id of product
	 * @param quantity : quantity of items
	 */
	void addItem(int id,int quantity){
		if(userCart.containsKey(id)){
			int newQuantity = products.get(id).getQuantity()+quantity;
			products.get(id).setQuantity(newQuantity);
			System.out.println(cartMessage.alreadyAdded + newQuantity);
		}
		else{
			products.get(id).setQuantity(quantity);
			userCart.put(id,products.get(id));
			System.out.println(cartMessage.itemAdded);
		}
	}
	/**
	 * Method for viewing the user cart
	 */
	void viewCart(){
		if(userCart.isEmpty()){
			System.out.println(cartMessage.emptyCart);
		}
		else{
			System.out.println("Id" +" \t \t"+ "Item Name" +" \t \t"+ "Quantity");
			for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())  
				System.out.println(entry.getKey() +" \t: \t"+entry.getValue().getName()+" \t: \t"+ entry.getValue().getQuantity()); 
		}
	}
	/**
	 * 
	 * @param id : Id of product
	 * Method for removing item from user cart
	 */
	void removeItem(int id){
		if(!userCart.containsKey(id)){
			System.out.println(cartMessage.invalidId);
		}
		else
			userCart.remove(id);
	}
	/**
	 * 
	 * @param id : Id of product
	 * @param quantity : quantity of product
	 * Method for editing the quantity of ietm to cart
	 */
	void editItem(int id,int quantity){
		if(!userCart.containsKey(id)){
			System.out.println(cartMessage.itemNotInCart);
		}
		else{
			products.get(id).setQuantity(quantity);
		}
	}
	/**
	 * 
	 * @return total amount of all the item
	 * Method for generating bill 
	 */
	int bill(){
		int amount=0;
		for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			amount += entry.getValue().getQuantity()*entry.getValue().getPrice();
		return amount;
	}
}
