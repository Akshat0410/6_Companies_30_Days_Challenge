package com.anupam.challenge.Walmart.Day30;

//Question :- Find Array Given Subset Sums

import java.util.Arrays;
import java.util.Scanner;

public class GivenSubsetSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] sums = new int[n];
        for (int i = 0; i < n; i++) sums[i] = sc.nextInt();
        int[] ans = recoveryArray(n, sums);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] recoveryArray(int n, int[] sums) {
        Arrays.sort(sums);
        int m = sums.length;
        int[] res = new int[n];
        int new_zero_spot = 0;
        for (int i = 0; i < n; ++i) {
            int diff = sums[1] - sums[0], p = 0, k = 0;
            for (int j = 0; j < m; ++j) {
                if (k < p && sums[k] == sums[j]) k++;
                else sums[p++] = sums[j] + diff;
            }
            if (Arrays.binarySearch(sums, 0, m / 2, new_zero_spot) >= 0) {
                res[i] = -diff;
            } else {
                res[i] = diff;
                new_zero_spot += diff;
            }
            m /= 2;
        }
        return res;
    }
}
