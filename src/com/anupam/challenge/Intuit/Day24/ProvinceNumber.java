package com.anupam.challenge.Intuit.Day24;

import java.util.Scanner;

public class ProvinceNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[][] ar = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                ar[i][j] = sc.nextInt();
            }
        }

        int ans = findCircleNum(ar);
        System.out.println(ans);
    }

    private static int findCircleNum(int[][] isConnected) {
        int[] visited = new int[isConnected.length];
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (visited[i] == 0) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
    }

    private static void dfs(int[][] M, int[] visited, int i) {
        for (int j = 0; j < M.length; j++) {
            if (M[i][j] == 1 && visited[j] == 0) {
                visited[j] = 1;
                dfs(M, visited, j);
            }
        }
    }
}

