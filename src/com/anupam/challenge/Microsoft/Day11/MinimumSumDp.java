package com.anupam.challenge.Microsoft.Day11;

//Question :- Divide an array into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference using dynamic programming

import java.util.Scanner;

public class MinimumSumDp {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int val = minDifference(ar, n);
        System.out.println(val);
    }

    public static int minDifference(int[] arr, int n) {
        int sum = 0;
        for (int ele : arr) sum += ele;

        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= sum; i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                dp[i][j] = dp[i - 1][j];
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i][j] || dp[i - 1][j - arr[i - 1]];
                }
            }
        }

        int mindiff = Integer.MAX_VALUE;
        for (int j = sum / 2; j >= 0; j--) {
            if (dp[n][j]) {
                mindiff = sum - 2 * j;
                break;
            }
        }

        return mindiff;
    }
}
