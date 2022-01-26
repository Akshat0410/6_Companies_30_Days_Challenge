package com.anupam.challenge.Intuit.Day25;

//Question :- Minimum Swaps to Arrange a Binary Grid

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class MinimumSwaps {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] grid = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = minSwaps(grid);
        System.out.println(ans);
    }

    private static int minSwaps(int[][] grid) {
        int n = grid.length, res = 0;
        List<Integer> row = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            int trailingZeroCnt = 0;
            for (int j = n - 1; j > -1 && grid[i][j] == 0; j--) trailingZeroCnt++;
            row.add(trailingZeroCnt);
        }
        for (int curRowIdx = 0, minTrailingZeros = n - 1; curRowIdx < n; curRowIdx++, minTrailingZeros--) {
            int satisfiedRowIdx = curRowIdx;
            while (satisfiedRowIdx < n && row.get(satisfiedRowIdx) < minTrailingZeros) satisfiedRowIdx++;
            if (satisfiedRowIdx == n) return -1;
            int toRemove = row.remove(satisfiedRowIdx);
            row.add(curRowIdx, toRemove);
            res += satisfiedRowIdx - curRowIdx;
        }
        return res;

    }
}
