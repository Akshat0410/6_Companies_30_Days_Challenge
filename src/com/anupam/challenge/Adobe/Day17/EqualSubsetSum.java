package com.anupam.challenge.Adobe.Day17;

//Question :-  Partition Equal Subset Sum

import java.util.Scanner;

public class EqualSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] ar = new int[N];
        for (int i = 0; i < N; i++) {
            ar[i] = sc.nextInt();
        }

        int ans = equalPartition(N, ar);
        System.out.println(ans);
    }

    private static int equalPartition(int N, int[] arr) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            sum = sum + arr[i];
        }
        if (sum % 2 != 0)
            return 0;
        else
            return isSubsetSum(arr, sum / 2, N);
    }

    private static int isSubsetSum(int[] arr, int sum, int n) {
        int dp[][] = new int[n + 1][sum + 1];

        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < sum + 1; j++) {

                if (i == 0)
                    dp[i][j] = 0;

                if (j == 0)
                    dp[i][j] = 1;
            }
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < sum + 1; j++) {

                if (arr[i - 1] <= j) {
                    dp[i][j] = Math.max(dp[i - 1][j - arr[i - 1]], dp[i - 1][j]);
                } else
                    dp[i][j] = dp[i - 1][j];
            }
        }
        return dp[n][sum];
    }
}
