package com.anupam.challenge.Amazon.Day8;

// Question : Maximum of all sub arrays of size k

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class MaximumOfSubArraysOfSizeK {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

        ArrayList<Integer> ans = max_of_subarrays(arr, n, k);
        System.out.println(ans);
    }

    private static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k) {

        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];

        st.push(arr.length - 1);
        nge[arr.length - 1] = arr.length;

        for (int i = arr.length - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= arr[st.peek()]) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = arr.length;
            } else {
                nge[i] = st.peek();
            }

            st.push(i);
        }

        for (int i = 0; i <= arr.length - k; i++) {
            int j = i;
            while (nge[j] < i + k) {
                j = nge[j];
            }
            ans.add(arr[j]);

        }

        return ans;
    }
}

