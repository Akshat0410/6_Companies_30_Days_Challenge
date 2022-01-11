package com.anupam.challenge.Amazon.Day10;

//Question :- Is Sudoku Valid

import java.util.HashSet;
import java.util.Scanner;

public class isSudokuValid {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] mat = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                mat[i][j] = sc.nextInt();
            }
        }
        int ans = isValid(mat);
        System.out.println(ans);
    }

    private static int isValid(int[][] mat) {
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                int val = mat[i][j];
                if (val != 0) {
                    if (!set.add(val + "found in row " + i) || !set.add(val + "found in column " + j) || !set.add(val + "found in sub box " + i / 3 + "-" + j / 3))
                        return 0;
                }
            }
        }

        return 1;
    }
}
