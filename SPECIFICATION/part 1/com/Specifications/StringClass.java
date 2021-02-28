package com.Specifications;

import java.util.Scanner;

/**
 * All the Main functions are present in it.
 * @author Mudit Jain
 */
public class StringClass {
    private static String str1;
    private static String str2;

    /**
     * Compare both Strings
     * @param str1 and str2 are the strings to be compared
     *             assume  not null and case sensitive
     * @return 1 if strings are equal else 0
     */

    public int compareStrings(String str1, String str2) {
        int l1 = str1.length();
        int l2 = str2.length();
        if (l1 != l2)
            return 0;
        else {
            for (int i = 0; i < l1; i++) {
                int str1_ch = (int)str1.charAt(i);
                int str2_ch = (int)str2.charAt(i);

                if (str1_ch != str2_ch) {
                    return 0;
                }
            }
            return 1;
        }
    }

    /**
     * Find reverse of the string
     * @param str is string to be reversed
     * @return rev the reversed string
     */
    static String reverseString(String str)
    {
        String rev="";
        for(int i=str.length();i>0;--i)
        {
            rev=rev+(str.charAt(i-1));
        }
        return rev;
    }

    /**
     * Replace lowercase string characters with uppercase and vice-versa.
     * @param s is the string in which replacement is to be done
     */
    static void changeCase(String s)
    {
        for(int i=0;i<s.length();i++)
        {
            int ch=s.charAt(i);
            if(ch>64&&ch<91)
            {
                ch=ch+32;
                System.out.print( (char) ch);
            }
            else if(ch>96&&ch<123)
            {
                ch=ch-32;
                System.out.print( (char) ch);
            }
            if(ch==32)
                System.out.print(" ");
        }
    }

    /**
     * Return Longest word from the string
     * @param s the string from which the longest word need to be determined
     * @return lw the longest word present in the string If two words are of same length then it is last word
     */
    public String longestWord(String s){
        String w="",lw="";
        char ch;
        s=s+" ";

        for(int i=0;i<s.length();i++){
            ch=s.charAt(i);
            if(ch!=' '){
                w=w+ch;
            }
            else{
                if(w.length()>=lw.length()){
                    lw=w;
                }
                w="";
            }

        }

        return lw;
    }

    /**
     * Function to take input both strings at a time
     */
    public void setStrings(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the first string");
        str1 = scan.nextLine();
        System.out.println("Enter the second string");
        str2 = scan.nextLine();
    }

    /**
     * Required when only single string is input
     */
    public void setString(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the String");
        str1 = scan.nextLine();
    }

    /**
     * Used mostly when a single string is required sometimes when both strings required its is also used
     * @return str1 the first string
     */
    public String getString1(){
        return str1;
    }

    /**
     * Used when both the strings are required
     * @return str2 the second string
     */
    public String getString2(){
        return str2;
    }
}
