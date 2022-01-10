package com.anupam.challenge.Amazon.Day9;

import java.util.Arrays;
import java.util.Scanner;

public class NutsAndBoltsProblem {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        char[] nuts=new char[n];
        char[] bolts=new char[n];

        for(int i=0;i<n;i++){
            nuts[i] = sc.next().charAt(0);
            bolts[i] = sc.next().charAt(0);
        }

        matchPairs(nuts,bolts,n);
        System.out.println(nuts);
        System.out.println(bolts);
    }

    private static void matchPairs(char[] nuts, char[] bolts, int n) {
        Arrays.sort(nuts);
        Arrays.sort(bolts);
    }
}
