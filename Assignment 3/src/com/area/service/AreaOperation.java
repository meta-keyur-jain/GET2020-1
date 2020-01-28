package com.area.service;

import java.util.Scanner;

import com.project.messages.*;
/**
 * 
 * @author Rahul
 * Created on 16 January 2020
 * contains operations of area on different shape
 */
public class AreaOperation {
	
	static double length = 0, breadth = 0, height = 0, radius = 0, side = 0;
	static int option ,invalidInput = 0;
	/**
	 * 
	 */
	final static int AREA_TRIANGLE = 1, AREA_RECTANGLE = 2, AREA_SQUARE = 3, AREA_CIRCLE = 4, EXIT = 5;
	/**
	 * 
	 * @param area : object of FindArea class object 
	 *  do various operations on different shapes to find area 
	 */
	public static void operation(FindArea area){
		Scanner sc = new Scanner(System.in);
		do{
			try {
				System.out.println("Options :"+"\n"+"1: Area of triangle"+"\n"+"2: Area of rectangle"+"\n"+"3: Area of square"+"\n"+"4: Area of circle"+"\n"+"5: Exit");
				System.out.println(AreaMessage.enterOption);
				option = sc.nextInt();
				switch(option){
				case AREA_TRIANGLE:
					do{
						try {
							System.out.print(AreaMessage.triangleData);
							breadth = sc.nextDouble();
							height = sc.nextDouble();
							invalidInput = 1;
							System.out.println("The area of triangle is:" + area.findTriangle(breadth, height));
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					break;
				case AREA_RECTANGLE:
					do{
						try {
							System.out.print(AreaMessage.rectangleData);
							length = sc.nextDouble();
							breadth = sc.nextDouble();
							invalidInput = 1;
							System.out.println("The area of rectangle is:" + area.findRectangle(length, breadth));
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					break;
				case AREA_SQUARE:
					do{
						try {
							System.out.print(AreaMessage.squareData);
							side = sc.nextDouble();
							invalidInput = 1;
							System.out.println("The area of square is:" + area.findSquare(side));
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					break;
				case AREA_CIRCLE:
					do{
						try {
							System.out.print(AreaMessage.circleData);
							radius = sc.nextDouble();
							invalidInput = 1;
							System.out.println("The area of circle is:" + area.findCircle(radius));
						} catch (Exception e) {
							System.out.println(AreaMessage.invalidData);
							sc.nextLine();
						}
					}while(invalidInput == 0);
					break;
				case EXIT:
					sc.close();
					System.out.println(messages.thankYou);
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
