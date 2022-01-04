package com.anupam.challenge.GoldmanSachs.Day4;

// Question :- Repeating and Missing Number

import java.util.Scanner;

public class MissingAndRepeating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int[] ans = findTwoElement(arr, n);
        for (int val : ans)
            System.out.print(val);
    }

    private static int[] findTwoElement(int[] arr, int n) {
        int xor = 0;
        int[] ans = new int[2];

        for (int i : arr) xor ^= i;

        for (int i = 1; i <= n; i++) xor ^= i;

        int rsb = (xor & -xor);

        int x = 0, y = 0;
        for (int val : arr) {
            if ((rsb & val) == 0) {
                x ^= val;
            } else {
                y ^= val;
            }
        }

        for (int i = 1; i <= n; i++) {
            if ((i & rsb) == 0) {
                x = x ^ i;
            } else {
                y = y ^ i;
            }
        }

        for (int val : arr) {
            if (val == x) {
                ans[0] = x;
                ans[1] = y;
            } else if (val == y) {
                ans[0] = y;
                ans[1] = x;
            }
        }

        return ans;
    }
}
