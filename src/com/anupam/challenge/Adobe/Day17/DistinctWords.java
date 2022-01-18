package com.anupam.challenge.Adobe.Day17;

//Question :- Number of distinct Words with k maximum contiguous vowels

import java.util.Scanner;

public class DistinctWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int ans = kvowelwords(n, k);
        System.out.println(ans);
    }

    private static int kvowelwords(int n, int k) {
        double[][] dp = new double[n + 1][k + 1];
        double MOD = 1e9;
        MOD = MOD + 7;
        for (int i = 0; i <= n; i++) {

            for (int j = 0; j <= k; j++) {
                if (i == 0) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][k] * 21 % MOD;

                    if (j > 0) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * 5 % MOD) % MOD;
                    }
                }

            }

        }
        return (int) dp[n][k];
    }
}
