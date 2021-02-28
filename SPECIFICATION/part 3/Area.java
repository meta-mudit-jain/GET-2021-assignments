package com.Specifications;
/*
Design a class Area to calculate areas for different shapes. It should support following methods
Method to return area of a Triangle. Method will receive width and height as double and return computed value as double.
Method to return area of a Rectangle. Method will receive width and height as double and return computed value as double.
Method to return area of a Square. Method will receive width as double and return computed value as double.
Method to return area of a Circle. Method will receive radius as double and return computed value as double.

 */

/**
 * @author Mudit Jain
 */

public class Area {
    /**
     * Find area of triangle
     * @param h is height w is width of triangle of type double
     * @return area of triangle in double
     */
    public double areaOfTriangle(double h,double w){
        double area;
        area=0.5*h*w;
        return area;
    }

    /**
     * Find area of rectangle
     * @param h is height and w is  width of rectangle
     * @return area of rectangle in double
     */
    public double areaOfRectangle(double h,double w){
        double area;
        area=h*w;
        return area;
    }
    /**
     * Find area of square
     * @param w width of square
     * @return area of square in double
     */
    public double areaOfSquare(double w){
        double area;
        area=w*w;
        return area;
    }

    /**
     * Find area of circle
     * @param r radius of circle
     * @return area of circle in double
     */
    public double areaOfCircle(double r){
        double area;
        area=314*r*r;
        return area;
    }
    public static void main(String args[]){
        Area circle=new Area();
        Area rectangle=new Area();
        Area square=new Area();
        Area triangle=new Area();

        System.out.println("The area of triangle is "+triangle.areaOfTriangle(50,100));
        System.out.println("The area of rectangle is "+rectangle.areaOfRectangle(100,400));
        System.out.println("The area of square is "+square.areaOfSquare(560));
        System.out.println("The area of circle is "+circle.areaOfCircle(200));
    }
}