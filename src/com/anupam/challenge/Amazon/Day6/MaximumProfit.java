package com.anupam.challenge.Amazon.Day6;

//Question :- Maximum Profit

import java.util.Scanner;

public class MaximumProfit {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) {
            price[i] = sc.nextInt();
        }

        int profit = maxProfit(k, n, price);
        System.out.println(profit);
    }

    private static int maxProfit(int K, int N, int[] A) {

        int[][] dp = new int[K + 1][N];
        for (int t = 1; t <= K; t++) {
            int max = Integer.MIN_VALUE;

            for (int d = 1; d < A.length; d++) {
                if (dp[t - 1][d - 1] - A[d - 1] > max) {
                    max = dp[t - 1][d - 1] - A[d - 1];
                }

                if (max + A[d] > dp[t][d - 1]) {
                    dp[t][d] = max + A[d];
                } else {
                    dp[t][d] = dp[t][d - 1];
                }
            }
        }

        return dp[K][N - 1];

    }
}
