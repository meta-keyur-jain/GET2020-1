package Shopping;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ShoppingCart{
	public static void main(String args[]){
		Cart cart=new Cart();
		int itemId=0, itemQuantity=0, option, amount, flag=0;
		Scanner sc=new Scanner(System.in);
		cart.showItem();
		System.out.println("Options :"+"\n"+"1: Add item"+"\n"+"2: View cart"+"\n"+"3: Edit cart"+"\n"+"4: Remove item from cart"+"\n"+"5: Generate Bill"+"\n"+"6: Exit");
		do {
			System.out.println("Select your option:");
			
			try {
				option=sc.nextInt();
				switch(option){
					case 1:
						do{
							try{
								System.out.println("Enter Id of Item to add to your cart");
								itemId=sc.nextInt();
								if(itemId<=0 || itemId>cart.products.size()){
									System.out.println("Id is invalid !! Please enter a valid Id");
								}
								else
									flag=1;
							}
							catch (InputMismatchException e) {
						        System.out.print("Id is invalid !! Please enter a valid Id\n");
						    }
						    sc.nextLine();
						}while(flag == 0);
						do{
							try{
								System.out.println("Enter Quantity");
								itemQuantity=sc.nextInt();
								if(itemQuantity<=0){
									System.out.println("Quantity is invalid !! Please enter a quantity");
									}
								else
									flag = 0;
							}
							catch (InputMismatchException e) {
						        System.out.print("Quantity is invalid !! Please enter a quantity\n");
						    }
						    sc.nextLine();
							}while(flag == 1);
						cart.addItem(itemId, itemQuantity);
						break;
					case 2:
						cart.viewCart();
						break;
					case 3:
						do{
							try{
								System.out.println("Enter Id of Item to be edit");
								itemId=sc.nextInt();
								if(itemId<=0 || itemId>cart.products.size()){
									System.out.println("Id is invalid !! Please enter a valid Id");
								}
								else
									flag=1;
							}
							catch (InputMismatchException e) {
						        System.out.print("Id is invalid !! Please enter a valid Id\n");
						    }
						    sc.nextLine();
						}while(flag == 0);
						do{
							try{
								System.out.println("Enter Quantity");
								itemQuantity = sc.nextInt();
								if(itemQuantity<=0){
									System.out.println("Quantity is invalid !! Please enter a quantity");
									}
								else
									flag = 0;
							}
							catch (InputMismatchException e) {
						        System.out.print("Quantity is invalid !! Please enter a quantity\n");
						    }
						    sc.nextLine();
						}while(flag == 1);
						cart.editItem(itemId,itemQuantity);
						break;
					case 4:
						do{
							try{
								System.out.println("Enter Id of Item to be remove from cart");
								itemId=sc.nextInt();
								if(itemId<=0 || itemId>cart.products.size()){
									System.out.println("Id is invalid !! Please enter a valid Id");
								}
								else
									flag=1;
							}
							catch (InputMismatchException e) {
						        System.out.print("Id is invalid !! Please enter a valid Id\n");
						    }
						    sc.nextLine();
						}while(flag == 0);
						cart.removeItem(itemId);
						break;
					case 5:
						amount=cart.bill();
						System.out.println("The total amount is :" +amount);
						break;
					case 6:
						System.exit(0);
						break;
					default:
						System.out.println("Please Enter valid expression");
				}
			} catch (Exception e) {
				System.out.println("Enter correct choice");
				sc.nextLine();
			}
		}while(true);	
	}
}
