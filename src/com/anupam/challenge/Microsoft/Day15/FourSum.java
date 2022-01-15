package com.anupam.challenge.Microsoft.Day15;

//Question :- Find All Four Sum Numbers

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class FourSum {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();

        ArrayList<ArrayList<Integer>> ans = fourSum(ar, k);
        System.out.println(ans);
    }

    private static ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        Arrays.sort(arr);
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();

        if (arr.length == 0)
            return res;

        int n = arr.length;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int target = k - (arr[i] + arr[j]);
                int front = j + 1, back = n - 1;
                while (front < back) {
                    int twosum = arr[front] + arr[back];
                    if (twosum < target) {
                        front++;
                    } else if (twosum > target) {
                        back--;
                    } else {
                        ArrayList<Integer> quad = new ArrayList<>();
                        quad.add(arr[i]);
                        quad.add(arr[j]);
                        quad.add(arr[front]);
                        quad.add(arr[back]);
                        res.add(quad);

                        while (front < back && arr[front] == quad.get(2)) ++front;

                        while (front < back && arr[back] == quad.get(3)) --back;
                    }

                }

                while (j + 1 < n && arr[j + 1] == arr[j]) ++j;
            }

            while (i + 1 < n && arr[i + 1] == arr[i]) ++i;
        }

        return res;
    }
}
