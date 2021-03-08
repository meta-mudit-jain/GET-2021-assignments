package com.LinkedList;

import java.util.Scanner;

/**
 * @author  Mudit Jain
 * Class having MultivariatePoly expression
 * Main function is present at line no 140
 */
public class MultivariatePoly{
    PolyNode headOfPoly;
    int noOfPolys;
    // Linked list class which store all nodes together
    public static class LinkedList {
        Node head;
        int noOfNodes;
        int coeff;
        // Node class which creates Node element of list
        public static class Node {
            char variable;
            int degree;
            Node next;
            // Node class constructor
            public Node(char variable, int degree) {
                this.variable = variable;
                this.degree = degree;
            }
        }

        /**
         * Constructor of LinkedList Class
         * @param coeff is coefficient
         */
        public LinkedList(int coeff) {
            this.coeff = coeff;
        }

        /**
         * Add an element in linked list
         * @param node is the node to be added to linked list
         */
        public void addToLinkedList(Node node) {
            if (head == null) {
                head = node;
            } else {
                Node temp = head;
                while (temp.next != null)
                    temp = temp.next;
                temp.next = node;
            }
            noOfNodes++;
        }

        /**
         * Method to print element in linked list
         * @return list string type with the variable and  their powers
         */
        public String printList() {
            Node temp = head;
            String list = "";
            while (temp != null) {
                list += temp.variable + "^" + temp.degree;
                temp = temp.next;
            }
            return list;
        }
    }
    // Java class of Polynomial node
    public static class PolyNode {
        LinkedList polyExpression;
        PolyNode nextPolyNode;

        /**
         * Constructor of class PolyNode
         * @param polyExpression is the linked list having a polynomial expression
         */
        public PolyNode(LinkedList polyExpression) {
            this.polyExpression = polyExpression;
        }
    }

    /**
     *Method to add a node to Polynode linked list
     * @param polyNode is the node to be inserted
     */
    public void addPolyNode(PolyNode polyNode) {
        if (headOfPoly == null) {
            headOfPoly = polyNode;
        } else {
            PolyNode temp = headOfPoly;
            while (temp.nextPolyNode != null)
                temp = temp.nextPolyNode;
            temp.nextPolyNode = polyNode;
        }
        noOfPolys++;
    }

    /**
     * Method to find degree of linked list
     * @return the degree of linked list
     */
    public int degreeOfPolynomial() {
        int degree = 0;
        int i = 0;
        int sum = 0;
        PolyNode poly = headOfPoly;
        while (poly != null) {
            while (i < poly.polyExpression.noOfNodes) {
                sum = 0;
                LinkedList.Node node = poly.polyExpression.head;
                while (node != null) {
                    sum += node.degree;
                    node = node.next;
                }
                i++;
            }
            if (sum > degree) {
                degree = sum;
            }
            poly = poly.nextPolyNode;
            i = 0;
        }
        return degree;
    }

    /**
     * Method to print the final polynomial
     */
    public void printPolynomial() {
        PolyNode temp = headOfPoly;
        while (temp != null) {
            System.out.print(temp.polyExpression.coeff
                    + temp.polyExpression.printList() + " + ");
            temp = temp.nextPolyNode;
        }
        System.out.println();
    }

    /**
     * Main function
     * @param args is to take command line arguments
     */
    public static void main(String[] args) {
        Scanner sc= new Scanner(System.in);
        int num,xi,yi,zi;
        System.out.println("Enter the no of elements in the linked list:");
        num=sc.nextInt();
        MultivariatePoly polynomial = new MultivariatePoly();
        for(int i=0;i<num;i++){
            LinkedList list;
            System.out.println("Enter the coefficient of "+(i+1)+" Element");
            int input=sc.nextInt();
            list=new LinkedList(input);
            System.out.println("Enter the x power of "+(i+1)+" Element");
            xi=sc.nextInt();
            list.addToLinkedList(new LinkedList.Node('x',xi));
            System.out.println("Enter the y power of "+(i+1)+" Element");
            yi=sc.nextInt();
            list.addToLinkedList(new LinkedList.Node('y',yi));
            System.out.println("Enter the z power of "+(i+1)+" Element");
            zi=sc.nextInt();
            list.addToLinkedList(new LinkedList.Node('z',zi));
            PolyNode polyNode = new PolyNode(list);
            polynomial.addPolyNode(polyNode);

        }
        System.out.println("Polynomial expression is-");
        polynomial.printPolynomial();
        System.out.println("Degree of polynomial: "
                + polynomial.degreeOfPolynomial());
    }
}
