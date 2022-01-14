package com.anupam.challenge.Microsoft.Day3;

import java.util.Scanner;

public class UnitAreaOfLargestOne {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int column = sc.nextInt();
        int[][] grid = new int[rows][column];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < column; j++) {
                grid[i][j] = sc.nextInt();
            }
        }

        int ans = findMaxArea(grid);
        System.out.println(ans);
    }

    private static int findMaxArea(int[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int num = search(i, j, grid);
                    result = Math.max(result, num);
                }
            }
        }
        return result;
    }

    private static int search(int i, int j, int[][] grid) {

        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0)
            return 0;

        grid[i][j] = 0;
        int sum = 0;
        sum += search(i + 1, j, grid);
        sum += search(i, j + 1, grid);
        sum += search(i, j - 1, grid);
        sum += search(i - 1, j, grid);

        sum += search(i + 1, j + 1, grid);
        sum += search(i - 1, j - 1, grid);
        sum += search(i + 1, j - 1, grid);
        sum += search(i - 1, j + 1, grid);
        return sum + 1;

    }
}
