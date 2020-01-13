package Shopping;

class Item {
	private double price;
	private int quantity;
	private String name;

	Item(String name,int price){
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
		if(quantity>10){
			this.quantity=10;
			System.out.println("Quantity must be less than or equal to 10, your 10 quantity is added");
		}
		else
			this.quantity = quantity;
	}
	public String getName() {
		return name;
	}
}

