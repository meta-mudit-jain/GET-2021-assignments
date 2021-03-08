package com.LinkedList;

import java.util.*;

/**
 * Rotate the sub-list of a linked list from position M to N to the right by K places
 * @author Mudit Jain
 */
class RotateSubList
{
    // Definition of node of linkedlist
    static class ListNode {
        int data;
        ListNode next;
    }

    /**
     * This function take head pointer of list, start and
     * end points of sublist that is to be rotated and the
     * number k and rotate the sublist to right by k places.
     * @param A is the linkedlist
     * @param m is the the element no from where to rotate
     * @param n is the element no till where to rotet
     * @param k is the places by which we have to rotate
     */
    static void rotateSubList(ListNode A, int m, int n, int k)
    {
            if(m<0||m>countNodes(A)||n<0||n>countNodes(A)){
                System.out.println("Value error");
                return;
            }
        int size = n - m + 1;

        // If k is greater than size of sublist then
        // we will take its modulo with size of sublist
        if (k > size) {
            k = k % size;
        }

        // If k is zero or k is equal to size or k is
        // a multiple of size of sublist then list
        // remains intact
        if (k == 0 || k == size) {
            ListNode head = A;
            while (head != null) {
                System.out.print( head.data);
                head = head.next;
            }
            return;
        }

        ListNode link = null;  // m-th node
        if (m == 1) {
            link = A;
        }

        // This loop will traverse all node till
        // end node of sublist.
        ListNode c = A;  // Current traversed node
        int count = 0;  // Count of traversed nodes
        ListNode end = null;
        ListNode pre = null; // Previous of m-th node
        while (c != null) {
            count++;

            // We will save (m-1)th node and later
            // make it point to (n-k+1)th node
            if (count == m - 1) {
                pre = c;
                link = c.next;
            }
            if (count == n - k) {
                if (m == 1) {
                    end = c;
                    A = c.next;
                }
                else {
                    end = c;

                    // That is how we bring (n-k+1)th
                    // node to front of sublist.
                    pre.next = c.next;
                }
            }

            // This keeps rest part of list intact.
            if (count == n) {
                ListNode d = c.next;
                c.next = link;
                end.next = d;
                ListNode head = A;
                while (head != null) {
                    System.out.print( head.data+" ");
                    head = head.next;
                }
                return;
            }
            c = c.next;
        }
    }

    /**
     * Function to count nodes in the linked list
     * @param head is the refrence of head of linked list
     * @return the count of nodes in linked list
     */
    static int countNodes(ListNode head){
        if(head==null)
            return 1;
            return 1+countNodes(head.next);

    }

    /**
     *  Function for creating and linking new nodes
     * @param head is the refrence of head node in linked list
     * @param val is the value to be inserted in the linked list
     * @return the head node of linked list
     */
    static ListNode push( ListNode head, int val)
    {
        ListNode new_node = new ListNode();
        new_node.data = val;
        new_node.next = (head);
        (head) = new_node;
        return head;
    }

    // Driver code
    public static void main(String args[])
    {
        int no,m,n,k;
        Scanner sc=new Scanner(System.in);
        RotateSubList llist= new RotateSubList();
        ListNode head = null;
        System.out.println("Enter No of elements of Linked List");
        no=sc.nextInt();
        for(int i=0;i<no;i++){
            System.out.println("Enter"+(i+1)+"element");
            int inp=sc.nextInt();
            head=llist.push(head,inp);
        }
        ListNode tmp = head;
        System.out.print("Given List: ");
        while (tmp != null) {
            System.out.print( tmp.data + " ");
            tmp = tmp.next;
        }
        System.out.println();
        System.out.println("Enter From where to rotate");
        m=sc.nextInt();
        System.out.println("Enter till where to rotate");
        n=sc.nextInt();
        System.out.println("Enter to rotate by how much places");
        k=sc.nextInt();
        System.out.print( "After rotation of sublist: ");
        rotateSubList(head, m, n, k);
    }
}