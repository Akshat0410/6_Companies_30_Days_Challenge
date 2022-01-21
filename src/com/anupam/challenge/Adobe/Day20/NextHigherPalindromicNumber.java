package com.anupam.challenge.Adobe.Day20;

//Question :- Smallest palindromic number greater than N using the same set of digits as in N.

import java.util.Scanner;

public class NextHigherPalindromicNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        String ans = nextPalin(st);
        System.out.println(ans);
    }

    private static String nextPalin(String str) {

        if (str.length() <= 2)
            return ("-1");

        int[] arr = new int[str.length() / 2];

        for (int i = 0; i < str.length() / 2; i++)
            arr[i] = (int) str.charAt(i) - 48;

        for (int i = (str.length() / 2) - 1; i >= 1; i--) {
            if (arr[i] > arr[i - 1]) {
                int index = findIndex(arr[i - 1], i, (str.length() / 2) - 1, arr);
                swap(i - 1, index, arr);
                reverse(arr, i, (str.length() / 2) - 1);
                break;
            }
        }

        int[] ans = new int[str.length()];
        for (int i = 0; i < arr.length; i++) {
            ans[i] = arr[i];
            ans[str.length() - i - 1] = arr[i];
        }
        if (str.length() % 2 != 0)
            ans[(str.length() / 2)] = (int) (str.charAt(str.length() / 2)) - 48;
        StringBuilder sb = new StringBuilder();
        for (int an : ans) sb.append(an);
        String s = sb.toString();
        return (s.equals(str) ? "-1" : s);
    }

    public static int findIndex(int num, int s, int e, int[] arr) {
        int i = s;
        while (i <= e && arr[i] > num)
            i++;
        return (i - 1);
    }

    public static void swap(int i, int j, int[] arr) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void reverse(int[] arr, int s, int e) {
        int i = s;
        int j = e;
        while (i <= j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }
}
