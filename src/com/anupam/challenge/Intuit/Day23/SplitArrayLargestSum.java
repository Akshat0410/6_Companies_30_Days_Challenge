package com.anupam.challenge.Intuit.Day23;

//Question :- Split Array Largest Sum

import java.util.Scanner;

public class SplitArrayLargestSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int ans = splitArray(nums, m);
        System.out.println(ans);
    }

    private static int splitArray(int[] nums, int m) {
        int L = nums.length;
        int[] S = new int[L + 1];
        S[0] = 0;
        for (int i = 0; i < L; i++)
            S[i + 1] = S[i] + nums[i];

        int[] dp = new int[L];
        for (int i = 0; i < L; i++)
            dp[i] = S[L] - S[i];

        for (int s = 1; s < m; s++) {
            for (int i = 0; i < L - s; i++) {
                dp[i] = Integer.MAX_VALUE;
                for (int j = i + 1; j <= L - s; j++) {
                    int t = Math.max(dp[j], S[j] - S[i]);
                    if (t <= dp[i])
                        dp[i] = t;
                    else
                        break;
                }
            }
        }

        return dp[0];
    }
}
