package com.anupam.challenge.Adobe.Day19;

// Question :- Amend The Sentence

import java.util.Scanner;

public class AmendString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ans=amendSentence(s);
        System.out.println(ans);
    }

    private static String amendSentence(String s) {

        StringBuilder ans= new StringBuilder();
        for(int i=0;i<s.length();i++){
            char c=s.charAt(i);
            if(Character.isUpperCase(c)){
                ans.append(" ").append(c);
            }else{
                ans.append(c);
            }
        }

        return ans.toString().toLowerCase().trim();

    }
}
