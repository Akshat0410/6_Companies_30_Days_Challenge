package com.anupam.challenge.Walmart.Day28;

//Question :- Power Of Numbers

import java.util.Scanner;

public class PowerOfNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), r = sc.nextInt();
        long ans = power(n, r);
        System.out.println(ans);
    }

    private static long power(int N, int R) {
        return computePowerRecursive(N, R) % 1000000007;

    }

    private static long computePowerRecursive(int N, int R) {
        if (R == 0)
            return 1;

        long result = power(N, R / 2);
        result = (result * result) % 1000000007;
        if (R % 2 == 0)
            return result;
        else
            return result * N;
    }
}
