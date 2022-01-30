package com.anupam.challenge.Walmart.Day29;

//Question :- Sorted subsequence of size 3

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class SortedSubsequence {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(sc.nextInt());
        }

        ArrayList<Integer> ans = find3Numbers(arr, n);
        System.out.println(ans);
    }

    private static ArrayList<Integer> find3Numbers(ArrayList<Integer> arr, int n) {
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr.get(st.peek()) <= arr.get(i)) st.pop();
            next[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (next[i] < n && next[next[i]] < n) {
                list.add(arr.get(i));
                list.add(arr.get(next[i]));
                list.add(arr.get(next[next[i]]));
                return list;
            }
        }
        return list;
    }
}
