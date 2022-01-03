package com.anupam.challenge.GoldmanSachs.Day3;

// Question :- GCD of strings

import java.util.Scanner;

public class GcdOfStrings {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String st1=sc.next();
        String st2=sc.next();
        String ans=gcdOfStrings(st1,st2);
        System.out.println(ans);
    }

    private static String gcdOfStrings(String str1, String str2) {

        if (!(str1+str2).equals(str2+str1))  return "";
        int gcdVal = gcd(str1.length() , str2.length());
        return str2.substring(0, gcdVal);
    }

    private static int gcd(int p, int q) {
        if (q == 0) return p;
        else return gcd(q, p % q);
    }
}
