package com.anupam.challenge.Microsoft.Day4;

//Question :- Stickler Thief

import java.util.Scanner;

public class SticklerThief {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();

        int ans = findMaxSum(ar, n);
    }

    private static int findMaxSum(int[] arr, int n) {
        int[] dp = new int[arr.length + 2];
        dp[0] = 0;
        dp[1] = 0;
        for (int i = 0; i < arr.length; i++) {
            dp[i + 2] = Math.max(arr[i] + dp[i], dp[i + 1]);
        }
        return dp[dp.length - 1];
    }
}
