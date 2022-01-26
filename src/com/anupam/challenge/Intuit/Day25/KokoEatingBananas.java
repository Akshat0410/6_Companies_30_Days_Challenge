package com.anupam.challenge.Intuit.Day25;

//Question :- Koko Eating Bananas

import java.util.Scanner;

public class KokoEatingBananas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), H = sc.nextInt();
        int[] piles = new int[n];
        for (int i = 0; i < n; i++) {
            piles[i] = sc.nextInt();
        }

        int ans = minEatingSpeed(piles, H);
        System.out.println(ans);
    }

    private static int minEatingSpeed(int[] piles, int H) {
        int low = 1, high = 1000000000, k = 0;
        while (low <= high) {
            k = (low + high) / 2;
            int m = 0;
            for (int i = 0; i < piles.length; i++)
                m += Math.ceil(1.0 * piles[i] / k);
            if (m > H)
                low = k + 1;
            else
                high = k - 1;
        }
        return low;
    }
}
