package com.anupam.challenge.Walmart.Day30;

//Question :- Largest number in K swaps

import java.util.Scanner;

public class LargestNumberKSwaps {
    static long max;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        String s = sc.next();
        String ans = findMaximumNum(s, k);
        System.out.println(ans);
    }


    private static String findMaximumNum(String s, int k) {
        max = Long.parseLong(s);
        f(s, k);
        return Long.toString(max);
    }

    private static void f(String s, int k) {
        max = Math.max(Long.parseLong(s), max);

        if (k == 0)
            return;

        int n = s.length();

        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (s.charAt(j) > s.charAt(i)) {

                    s = swap(s, i, j);
                    f(s, k - 1);
                    s = swap(s, i, j);
                }
            }
        }
    }

    private static String swap(String s, int i, int j) {
        char[] c = s.toCharArray();

        char ch = c[i];
        c[i] = c[j];
        c[j] = ch;
        return String.valueOf(c);
    }
}
