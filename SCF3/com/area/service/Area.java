package com.area.service;

import java.util.Scanner;
/**
 * 
 * @author Rahul
 * Created on 16 January 2020
 * Contains operations for finding area for different shapes
 */
public class Area {
	public static void main(String args[])
	{
		double length = 0, breadth = 0, height = 0, radius = 0, side = 0;
		int option ,invalidInput = 0;
		FindArea area = new FindArea();
		Scanner sc = new Scanner(System.in);
		do{
			try {
				System.out.println("Options :"+"\n"+"1: Area of triangle"+"\n"+"2: Area of rectangle"+"\n"+"3: Area of square"+"\n"+"4: Area of square"+"\n"+"5: Exit");
				System.out.println(AreaMessage.enterOption);
				option = sc.nextInt();
				switch(option){
				case 1:
					do{
						try {
							System.out.print(AreaMessage.triangleData);
							breadth = sc.nextDouble();
							height = sc.nextDouble();
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					System.out.println("The area of triangle is:" + area.findTriangle(breadth, height));
					break;
				case 2:
					do{
						try {
							System.out.print(AreaMessage.rectangleData);
							length = sc.nextDouble();
							breadth = sc.nextDouble();
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					System.out.println("The area of rectangle is:" + area.findRectangle(length, breadth));
					break;
				case 3:
					do{
						try {
							System.out.print(AreaMessage.squareData);
							side = sc.nextDouble();
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					System.out.println("The area of square is:" + area.findSquare(side));
					break;
				case 4:
					do{
						try {
							System.out.print(AreaMessage.circleData);
							radius = sc.nextDouble();
							invalidInput = 1;
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					System.out.println("The area of triangle is:" + area.findCircle(radius));
					break;
				case 5:
					sc.close();
					System.exit(0);
				default:
					System.out.println(AreaMessage.invalidData);
				}
			} catch (Exception e) {
				System.out.println(AreaMessage.invalidOption);
				sc.nextLine();
			}
		}while(true);
	}
}
