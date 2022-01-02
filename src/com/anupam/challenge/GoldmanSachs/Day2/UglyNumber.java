package com.anupam.challenge.GoldmanSachs.Day2;

//Print the nth ugly number

import java.util.Scanner;

public class UglyNumber {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long ans = getNthUglyNumber(n);
        System.out.println(ans);
    }

    private static long getNthUglyNumber(int n) {

        long[] ans = new long[n + 1];
        ans[1] = 1;

        int f_ptr = 1, s_ptr = 1, t_ptr = 1;


        for (int i = 2; i <= n; i++) {
            long val1 = ans[f_ptr] * 2;
            long val2 = ans[s_ptr] * 3;
            long val3 = ans[t_ptr] * 5;
            long min = Math.min(val1, Math.min(val3, val2));

            ans[i] = min;

            if (min == val1)
                f_ptr++;

            if (min == val2)
                s_ptr++;

            if (min == val3)
                t_ptr++;


        }

        return ans[n];
    }
}
