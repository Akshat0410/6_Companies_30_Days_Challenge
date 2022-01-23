package com.anupam.challenge.Intuit.Day22;

//Question :- Find the missing no in string

import java.util.Scanner;

public class MissingNoInString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String st = sc.next();
        int ans = missingNumber(st);
        System.out.println(ans);
    }

    private static int missingNumber(String str) {
        if (str.length() == 1) {
            return -1;
        }

        for (int i = 1; i <= Math.min(6, str.length()); i++) {

            int curr = Integer.parseInt(str.substring(0, i));
            int ans = miss(str.substring(i), curr, false);
            if (ans != -1) {
                return ans;
            }
        }
        return -1;
    }

    private static int miss(String str, int prev, boolean bool) {
        if (str.equals("")) {
            if (bool) {
                return 0;
            }
            return -1;
        }
        String curr = "" + (prev + 1);
        if (bool) {
            if (str.startsWith(curr)) {
                return miss(str.substring(curr.length()), prev + 1, true);
            } else {
                return -1;
            }
        } else {
            if (str.startsWith(curr)) {
                return miss(str.substring(curr.length()), prev + 1, false);
            } else {
                curr = (prev + 2) + "";
                if (str.startsWith(curr)) {
                    if (miss(str.substring(curr.length()), prev + 2, true) == 0) {
                        return prev + 1;
                    } else {
                        return -1;
                    }
                } else {
                    return -1;
                }
            }
        }
    }
}
