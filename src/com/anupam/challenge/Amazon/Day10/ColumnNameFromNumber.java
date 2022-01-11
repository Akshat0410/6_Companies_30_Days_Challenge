package com.anupam.challenge.Amazon.Day10;

//Question :- Column name from a given column number

import java.util.Scanner;

public class ColumnNameFromNumber {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long input=sc.nextLong();
        String ans=colName(input);
        System.out.println(ans);
    }

    private static String colName(long n) {

        StringBuilder ans=new StringBuilder();
        while(n>0){
            char ch= (char) ('A'+(n-1)%26);
            ans.append(ch);
            n=(n-1)/26;
        }
        return ans.reverse().toString();

    }
}
