package com.area.service;
/**
 * 
 * @author Rahul
 * Created on 16 January 2020
 * Contains methods for finding area of different shapes 
 */

public class FindArea {
		 /**
		  * 
		  * @param b : breadth of triangle 
		  * @param h : height of triangle
		  * @return : area of triangle
		  */
	    double findTriangle(double b, double h) 
	    {
	        double area = (b*h) / 2;
	        return area;
	    }
	    /**
	     * 
	     * @param l : length of rectangle
	     * @param b : breadth of rectangel
	     * @return : area of rectangle
	     */
	    double findRectangle(double l, double b)
	    {
	        double area = l*b;
	        return area;
	    }
	    /**
	     * 
	     * @param s : side of square
	     * @return : area of square
	     */
	    double findSquare(double s)
	    {
	        double area = s*s;
	        return area;
	    }
	    /**
	     * 
	     * @param r : radius of circle
	     * @return : area of circle
	     */
	    double findCircle(double r)
	    {
	        double area = 3.14 * r * r;
	        return area;
	    }
}
