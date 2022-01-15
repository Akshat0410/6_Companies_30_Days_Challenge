package com.anupam.challenge.Microsoft.Day15;

//Question :- Bridge edge in a graph

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class BridgeEdge {

    static int isBridge(int V, ArrayList<ArrayList<Integer>> adj, int c, int d) {
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        q.offer(c);

        vis[c] = true;

        //removing c fron d and d from c
        adj.get(c).remove(Integer.valueOf(d));
        adj.get(d).remove(Integer.valueOf(c));

        // Simple BFS
        while (!q.isEmpty()) {
            int it = q.poll();
            for (Integer v : adj.get(it)) {
                if (!vis[v]) {
                    q.offer(v);
                    vis[v] = true;
                }
            }
        }

        // Only check for vis[d]
        if (vis[d])
            return 0;
        return 1;
    }
}
