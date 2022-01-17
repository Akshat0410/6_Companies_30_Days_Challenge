package com.anupam.challenge.Adobe.Day16;

//Question :- Find the length of the Longest Arithmetic Progression (LAP) in it.

import java.util.HashMap;
import java.util.Scanner;

public class LongestArithmeticProgression {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.nextInt();
        }

        int ans = lengthOfLongestAP(ar, n);
        System.out.println(ans);
    }

    private static int lengthOfLongestAP(int[] A, int n) {
        HashMap<Integer, Integer>[] dp = new HashMap[n];
        int ans = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            dp[i] = new HashMap<>();
            for (int j = 0; j < i; j++) {
                int diff = A[i] - A[j];
                dp[i].put(diff, dp[j].getOrDefault(diff, 1) + 1);
                ans = Math.max(ans, dp[i].get(diff));
            }
        }
        return ans;
    }
}
