package com.anupam.challenge.Amazon.Day9;

//Question :- Count ways to N'th Stair(Order does not matter)

import java.util.Scanner;

public class CountWays {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Long ans=countWays(sc.nextInt());
        System.out.println(ans);
    }

    private static Long countWays(int n) {
        return (n/2L)+1;
    }
}
