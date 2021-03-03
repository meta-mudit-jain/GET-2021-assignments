package com.Specifications;

import java.util.Scanner;

/**
 * Class having methods to find area of traingle rectangle circle and square
 * @author Mudit Jain
 */

public class Area {

    /**
     * Main function
     * @param args take input command line arguments
     */
    public static void main(String args[]) {
        Scanner scan = new Scanner();
        Area obj = new Area();
        int choice, height, width, radius, base;
        System.out.println("Find Area of:\n1.Triangle\n2.Rectangle\n3.Circle\n4.Square");
        choice = scan.nextInt();
        Switch(choice) {
            case 1: {
                System.out.println("Enter base");
                base = scan.nextInt();
                System.out.println("Enter height");
                height = scan.nextInt();
                obj.areaOfTriangle(height, base);
            }
            break;
            case 2: {
                System.out.println("Enter width");
                width = scan.nextInt();
                System.out.println("Enter height");
                height = scan.nextInt();
                obj.areaOfRectangle(height, width);
            }
            break;
            case 3: {
                System.out.println("Enter radius");
                radius = scan.nextInt();
                obj.areaOfCircle(radius);
            }
            break;
            case 4: {
                System.out.println("Enter width");
                width = scan.nextInt();
                obj.areaOfSquare(width);
            }
            break;
            default:
                System.out.println("Invalid Number entered");
        }
    }
    /**
     * Find area of triangle
     * @param h is height of triangle >0
     * @param w is width of triangle >0
     * @return area of triangle
     */
    public double areaOfTriangle(double h,double w){
        if(h<=0 || w<=0)
            throw new ArithmeticException("wrong inputs");
        double area;
        area=0.5*h*w;
        return area;
    }

    /**
     * Find area of rectangle
     * @param h is height >0
     * @param w is width >0
     * @return area of rectangle in double
     */
    public double areaOfRectangle(double h,double w){
        if(h<=0 || w<=0)
            throw new ArithmeticException("wrong inputs");
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
        if(w<=0)
            throw new ArithmeticException("wrong inputs");
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
        if(r==0)
            throw new ArithmeticException("wrong inputs");
        double area;
        area=314*r*r;
        return area;
    }


}