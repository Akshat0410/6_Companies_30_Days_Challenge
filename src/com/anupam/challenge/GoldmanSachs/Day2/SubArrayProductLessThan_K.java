package com.anupam.challenge.GoldmanSachs.Day2;

//Question Count the Sub Arrays having product less than k

import java.util.Scanner;

public class SubArrayProductLessThan_K {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong(), k = sc.nextLong();
        long[] ar = new long[(int) n];
        for (long i = 0; i < n; i++) {
            ar[(int) i] = sc.nextLong();
        }


        int ans = countSubArrayProductLessThanK(ar, n, k);
        System.out.println(ans);
    }

    private static int countSubArrayProductLessThanK(long[] ar, long n, long k) {

        long prod = 1;
        int res = 0, left = 0, right = 0;
        while (right < n) {
            prod *= ar[right];
            while (prod >= k) {
                prod /= ar[left];
                left++;
            }
            res += right - left + 1;
            right++;
        }

        return res;
    }
}
