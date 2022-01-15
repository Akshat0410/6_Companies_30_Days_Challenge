package com.anupam.challenge.Microsoft.Day15;

//Question :- Alien Dictionary

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Stack;

public class AlienDictionary {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        String[] dict = new String[n];
        for (int i = 0; i < n; i++) dict[i] = sc.next();
        String ans = findOrder(dict, n, k);
        System.out.println(ans);
    }

    private static String findOrder(String[] dict, int n, int K) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(i, new ArrayList<>());
        }

        for (int i = 0; i < dict.length - 1; i++) {
            for (int j = 0; j < Math.min(dict[i].length(), dict[i + 1].length()); j++) {
                if (dict[i].charAt(j) != dict[i + 1].charAt(j)) {
                    adj.get(dict[i].charAt(j) - 'a').add(dict[i + 1].charAt(j) - 'a');
                    break;
                }

            }
        }
        String str = topologicalSort(adj, K);


        return str;
    }

    private static String topologicalSort(ArrayList<ArrayList<Integer>> adj, int n) {
        Stack<Integer> st = new Stack<>();
        boolean[] vis = new boolean[n];


        for (int i = 0; i < n; i++) {
            if (!vis[i]) {
                dfsCheck(adj, i, st, vis);
            }
        }

        StringBuilder str = new StringBuilder();
        while (!st.isEmpty()) {
            char c = (char) (st.pop() + 'a');
            str.append(c);
        }

        return str.toString();
    }

    private static void dfsCheck(ArrayList<ArrayList<Integer>> adj, int i, Stack<Integer> st, boolean[] vis) {
        vis[i] = true;

        for (int it : adj.get(i)) {
            if (!vis[it]) {
                dfsCheck(adj, it, st, vis);
            }
        }

        st.push(i);
    }
}
