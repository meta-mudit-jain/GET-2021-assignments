package com.Specifications;

import java.util.Scanner;

/*
 * Compare two strings and return 1 if equals else 0. Take two string inputs, compare them and return values accordingly.
 * Return the reverse of any string.
 * Receive a string as parameter and replace lowercase characters with uppercase and vice-versa.
 * Return the largest word of a string. If two words are of same length then return last word
 */

/**
 * Creates a command-line User Interface.
 * @author Mudit Jain
 */

public class Main {

    static int choice;

    public static void main(String[] args) {

        StringClass objSC=new StringClass();
        int exitCode;

        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Enter your choice from the following menu:");
            System.out.println("""
                    1.Compare Two Strings
                    2.Reverse a String
                    3.Replace lowercase characters with uppercase and vice-versa of a String
                    4.Find the largest word present in String
                    5.Exit
                    """);

            choice = sc.nextInt();

            switch(choice){
                case 1: {
                    objSC.setStrings();
                    System.out.println(objSC.compareStrings(objSC.getString1(),objSC.getString2()));
                }
                break;
                case 2: {
                    objSC.setString();
                    System.out.println(objSC.reverseString(objSC.getString1()));
                }
                break;
                case 3: {
                    objSC.setString();
                    objSC.changeCase(objSC.getString1());

                }
                break;
                case 4: {
                    objSC.setString();
                    System.out.println(objSC.longestWord(objSC.getString1()));
                }
                break;
                case 5: {
                    System.exit(0);
                }
                default:System.out.println("Invalid choice");
            }
            System.out.println("Do you want to continue?1.Yes 2.No");
            exitCode=sc.nextInt();
            }while(exitCode==1);

        }

}