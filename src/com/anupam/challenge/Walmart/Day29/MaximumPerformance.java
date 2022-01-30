package com.anupam.challenge.Walmart.Day29;

//Question:- Maximum Performance of a Team

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class MaximumPerformance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] speed = new int[n], efficiency = new int[n];
        for (int i = 0; i < n; i++) speed[i] = sc.nextInt();
        for (int i = 0; i < n; i++) efficiency[i] = sc.nextInt();
        int k = sc.nextInt();
        int ans = maxPerformance(n, speed, efficiency, k);
        System.out.println(ans);
    }

    private static int maxPerformance(int n, int[] speed, int[] efficiency, int k) {
        int[][] ess = new int[n][2];
        for (int i = 0; i < n; ++i)
            ess[i] = new int[]{efficiency[i], speed[i]};
        Arrays.sort(ess, (a, b) -> b[0] - a[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>(k, (a, b) -> a - b);
        long res = 0, sumS = 0;
        for (int[] es : ess) {
            pq.add(es[1]);
            sumS = (sumS + es[1]);
            if (pq.size() > k) sumS -= pq.poll();
            res = Math.max(res, (sumS * es[0]));
        }
        return (int) (res % (long) (1e9 + 7));
    }
}
