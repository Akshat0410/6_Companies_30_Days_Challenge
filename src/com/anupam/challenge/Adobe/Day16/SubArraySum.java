package com.anupam.challenge.Adobe.Day16;

//Question :- Find a continuous sub-array which adds to a given number S.

import java.util.ArrayList;
import java.util.Scanner;

public class SubArraySum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = subArraySum(arr, n, s);
        System.out.println(ans);
    }

    private static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        int sum = 0;
        int front = 1;
        int rear = 1;
        for (int a = 1; a <= n; a++) {
            sum += arr[a - 1];
            if (sum == s) {
                break;
            }
            if (sum > s) {
                ++front;
                sum = 0;
                rear = front;
                a = front - 1;
            } else {
                ++rear;
            }
        }

        ArrayList<Integer> abc = new ArrayList<>();
        if (rear > n) {
            abc.add(-1);
        } else {
            abc.add(front);
            abc.add(rear);
        }
        return abc;
    }
}
