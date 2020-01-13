package Shopping;
import java.util.HashMap;

public class Cart {
	
	//Map for product id and products object which contain detail about product
	HashMap<Integer,Item> products = new HashMap<Integer,Item>();	
	//Map for product id and products object which are in the cart of user
	HashMap<Integer,Item> userCart =new HashMap<Integer,Item>(); 
	//Create the objects for product available in shopping mart and pass the arguments name and price for product
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
	Cart(){
	//Add Id as key and object of product as value in map
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
	//Method to show all the items of the website
	void showItem(){
		System.out.println("Id" +" \t \t"+ "Item Name" +" \t"+ "Price");
		for (HashMap.Entry<Integer,Item> entry : products.entrySet()){
				System.out.println(entry.getKey() +" \t \t"+entry.getValue().getName()+" \t \t"+ entry.getValue().getPrice());
		}
	}
	//Method to add item to user cart
	void addItem(int id,int quantity){
		if(userCart.containsKey(id)){
			int newQuantity = products.get(id).getQuantity()+quantity;
			products.get(id).setQuantity(newQuantity);
			System.out.println("The item is already present in cart, quantity updated to:"+newQuantity);
		}
		else{
			products.get(id).setQuantity(quantity);
			userCart.put(id,products.get(id));
		}
	}
	//Method to view the cart of user
	void viewCart(){
		if(userCart.isEmpty()){
			System.out.println("Cart is Empty");
		}
		else{
			System.out.println("Id" +" \t \t"+ "Item Name" +" \t \t"+ "Quantity");
			for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())  
				System.out.println(entry.getKey() +" \t: \t"+entry.getValue().getName()+" \t: \t"+ entry.getValue().getQuantity()); 
		}
	}
	//Method to remove the item from the user cart
	void removeItem(int id){
		if(!userCart.containsKey(id)){
			System.out.println("Oops!! Invalid item id");
		}
		else
			userCart.remove(id);
	}
	//Method to edit any item in user cart
	void editItem(int id,int quantity){
		if(!userCart.containsKey(id)){
			System.out.println("Sorry!! The entered item is not in your cart");
		}
		else{
			products.get(id).setQuantity(quantity);
		}
	}
	//Method to find the total bill
	int bill(){
		int amount=0;
		for (HashMap.Entry<Integer,Item> entry : userCart.entrySet())
			amount += entry.getValue().getQuantity()*entry.getValue().getPrice();
		return amount;
	}
}
