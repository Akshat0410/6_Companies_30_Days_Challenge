package com.anupam.challenge.Microsoft.Day3;

//Question :- Stock span problem

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

public class StockSpan {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] price = new int[n];
        for (int i = 0; i < n; i++) price[i] = sc.nextInt();

        int[] ans = calculateSpan(price, n);
        System.out.println(Arrays.toString(ans));
    }

    private static int[] calculateSpan(int[] price, int n) {
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int[] span = new int[n];
        span[0] = 1;

        for (int i = 1; i < n; i++) {
            while (st.size() > 0 && price[i] >= price[st.peek()]) {
                st.pop();
            }
            if (st.size() == 0)
                span[i] = i + 1;
            else
                span[i] = i - st.peek();

            st.push(i);
        }
        return span;
    }
}
