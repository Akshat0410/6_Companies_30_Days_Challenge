package com.anupam.challenge.Adobe.Day18;

//Question :- Implement Atoi

import java.util.Scanner;

public class Atoi {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int ans = atoi(s);
        System.out.println(ans);
    }

    private static int atoi(String str) {

        int n = str.length(), res = 0;
        boolean flag = false;
        for (int i = 0; i < n; i++) {
            char c = str.charAt(i);
            if (c == '-') {
                flag = true;
                continue;
            }
            if (Character.isDigit(c)) {
                if (i <= 1)
                    res = (int) (res * (Math.pow(10, i)) + Integer.parseInt(String.valueOf(c)));
                else
                    res = res * 10 + Integer.parseInt(String.valueOf(c));
            } else {
                return -1;
            }
        }
        if (flag)
            return -1 * res;

        return res;
    }
}