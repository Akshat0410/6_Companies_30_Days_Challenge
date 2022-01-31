package com.anupam.challenge.Walmart.Day30;

//Question:- Divide Two Integers

import java.util.Scanner;

public class DivideTwoIntegers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int dividend = sc.nextInt(), divisor = sc.nextInt();
        int ans = divide(dividend, divisor);
        System.out.println(ans);
    }

    private static int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        if (dividend > 0 && divisor > 0) return divideHelper(-dividend, -divisor);
        else if (dividend > 0) return -divideHelper(-dividend, divisor);
        else if (divisor > 0) return -divideHelper(dividend, -divisor);
        else return divideHelper(dividend, divisor);
    }

    private static int divideHelper(int dividend, int divisor) {
        // base case
        if (divisor < dividend) return 0;
        // get highest digit of divisor
        int cur = 0, res = 0;
        while ((divisor << cur) >= dividend && divisor << cur < 0 && cur < 31) cur++;
        res = dividend - (divisor << cur - 1);
        if (res > divisor) return 1 << cur - 1;
        return (1 << cur - 1) + divide(res, divisor);
    }
}