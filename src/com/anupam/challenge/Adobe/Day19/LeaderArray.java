package com.anupam.challenge.Adobe.Day19;

//Question :- Leaders in Array

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class LeaderArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> ans = leaders(arr, n);
        System.out.println(ans);
    }

    private static ArrayList<Integer> leaders(int[] arr, int n) {
        ArrayList<Integer> ans = new ArrayList<>();
        Stack<Integer> st = new Stack<>();
        int[] nge = new int[n];
        nge[n - 1] = -1;
        st.push(arr[n - 1]);
        for (int i = n - 2; i >= 0; i--) {
            while (st.size() > 0 && arr[i] >= st.peek()) {
                st.pop();
            }

            if (st.size() == 0) {
                nge[i] = -1;
            } else {
                nge[i] = st.peek();
            }

            st.push(arr[i]);
        }

        for (int i = 0; i < nge.length; i++) {
            if (nge[i] == -1) {
                ans.add(arr[i]);
            }
        }

        return ans;
    }
}
