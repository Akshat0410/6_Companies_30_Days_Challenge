package com.anupam.challenge.GoldmanSachs.Day4;

//Question :- Print Minimum Number for pattern

import java.util.Scanner;
import java.util.Stack;

public class NumberFollowingPattern {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = printMinNumberForPattern(s);
        System.out.println(ans);

    }

    private static String printMinNumberForPattern(String S) {
        Stack<Integer> st = new Stack<Integer>();
        int num = 1;
        String ans = "";
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == 'D') {
                st.push(num);
                num++;
            } else {
                st.push(num);
                num++;
                while (st.size() > 0) {
                    ans = ans + st.pop();
                }
            }
        }

        st.push(num);

        while (st.size() > 0) {
            ans = ans + st.pop();
        }

        return ans;

    }
}
