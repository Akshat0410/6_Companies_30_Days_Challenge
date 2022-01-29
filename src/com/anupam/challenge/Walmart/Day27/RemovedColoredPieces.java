package com.anupam.challenge.Walmart.Day27;

//Question :-  Remove Colored Pieces if Both Neighbors are the Same Color

import java.util.Scanner;

public class RemovedColoredPieces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String color = sc.next();
        boolean ans = winnerOfGame(color);
        System.out.println(ans);
    }

    private static boolean winnerOfGame(String colors) {
        char prev = 'C';
        int a = 0, b = 0;
        for (int i = 0, cnt = 0; i < colors.length(); ++i) {
            char cur = colors.charAt(i);
            if (cur == prev) {
                if (++cnt > 2) {
                    if (cur == 'A') {
                        ++a;
                    } else {
                        ++b;
                    }
                }
            } else {
                cnt = 1;
            }
            prev = cur;
        }
        return a > b;
    }
}
