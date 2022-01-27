package com.anupam.challenge.Walmart.Day1;

//Question:- Stone Game

import java.util.Scanner;

public class StoneGame {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] pile = new int[n];
        for (int i = 0; i < n; i++)
            pile[i] = sc.nextInt();

        boolean ans = stoneGame(pile);
        System.out.println(ans);
    }

    private static boolean stoneGame(int[] p) {
        int n = p.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) dp[i][i] = p[i];
        for (int d = 1; d < n; d++)
            for (int i = 0; i < n - d; i++)
                dp[i][i + d] = Math.max(p[i] - dp[i + 1][i + d], p[i + d] - dp[i][i + d - 1]);
        return dp[0][n - 1] > 0;
    }
}
