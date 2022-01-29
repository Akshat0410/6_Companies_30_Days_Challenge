package com.anupam.challenge.Walmart.Day28;

//Question :- Maximum Height Tree

import java.util.Scanner;

public class MaximumHeightTree {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int ans = height(n);
        System.out.println(ans);
    }

    private static int height(int N) {
        int i = 0;
        for (i = 0; i < 1000; i++) {
            if (((i * (i + 1)) / 2) > N)
                break;
        }
        return i - 1;
    }

}
