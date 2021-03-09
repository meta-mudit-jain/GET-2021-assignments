package com.dsa4;


import java.util.*;
    public class UniqueCharacterString {
        public static HashMap<String,Integer> cache=new HashMap<>();

        public static int countUniqueCharacter(String input){
            boolean[] isItThere=new boolean[Character.MAX_VALUE];
            for(int i=0;i<input.length();i++)
                isItThere[input.charAt(i)]=true;
            int count=0;
            for(int i=0;i<isItThere.length;i++){
                if(isItThere[i]==true)
                    count++;
            }
            return count;
        }
        public static void getString(){
            System.out.println("Enter the string");
            Scanner sc=new Scanner(System.in);
            String str=sc.nextLine();
            if(cache.isEmpty()){
                int c=countUniqueCharacter(str);
                cache.put(str,c);
                System.out.println("The number of unique characters are "+c);
            }
            else{
                if(cache.containsKey(str))
                    System.out.println("The number of unique characters are "+cache.get(str));
                else{
                    int c=countUniqueCharacter(str);
                    cache.put(str,c);
                    System.out.println("The number of unique characters are "+c);
                }
            }
        }

        public static void main(String arg[]){
            Scanner sc=new Scanner(System.in);
            int a=1;
            while(a!=0){
                System.out.println("Enter 1 to countUniqueCharacter and 2 to exit");
                int n=sc.nextInt();
                switch(n){
                    case 1 : getString();
                        break;
                    case 2 : System.out.println("Thanks");
                        a=0;
                        break;
                    default : System.out.println("You entered wrong choice.Please choose again");
                }
            }
        }
    }
