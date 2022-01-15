package com.anupam.challenge.Microsoft.Day2;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class PrerequisiteTask {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), p = sc.nextInt();
        int[][] pre = new int[p][2];
        for (int i = 0; i < p; i++) {
            for (int j = 0; j < 2; j++) {
                pre[i][j] = sc.nextInt();
            }
        }
        if (isPossible(pre, n))
            System.out.println("Yes");
        else
            System.out.println("No");
    }

    private static boolean isPossible(int[][] pre, int n) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] ints : pre) {
            int row = ints[0];
            int col = ints[1];
            adj.get(row).add(col);
        }
        int node = -1;
        for (int i = 0; i < n; i++) {
            if (adj.get(i).size() > 0) {
                node = adj.get(i).get(0);
                break;
            }
        }
        if (node == -1) {
            return false;
        }
        return topological(adj, n, node);
    }

    static boolean topological(ArrayList<ArrayList<Integer>> adj, int n, int first) {
        int v = 0;
        boolean[] visited = new boolean[n];
        Stack<Integer> fin = new Stack<>();
        Stack<Integer> stack = new Stack<>();
        stack.push(first);
        while (v < n && stack.size() > 0) {
            int num = stack.pop();
            Stack<Integer> temp = new Stack<>();
            temp.push(num);
            do {
                boolean check = false;
                for (int ele : adj.get(temp.peek())) {
                    if (!visited[ele]) {
                        temp.push(ele);
                        check = true;
                        break;
                    }

                }
                if (!check) {
                    int pop = temp.pop();
                    visited[pop] = true;
                    v++;
                    fin.push(pop);
                }
                if (temp.size() > n) {
                    return false;
                }
            } while (!temp.isEmpty());
            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    stack.push(i);
                    break;
                }
            }
        }
        return true;
    }
}
