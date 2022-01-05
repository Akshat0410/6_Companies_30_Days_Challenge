package com.anupam.challenge.GoldmanSachs.Day5;

//Question :- Find max 10 numbers in a list having 10M entries
import java.util.PriorityQueue;
import java.util.Scanner;

public class KLargestNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = kLargest(arr, n, k);
        for (int val : ans)
            System.out.println(val + " ");
    }

    private static int[] kLargest(int[] arr, int n, int k) {
        int[] ans = new int[k];
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            if (i < k) {
                pq.add(arr[i]);
            } else {
                if (pq.peek() < arr[i]) {
                    pq.remove();
                    pq.add(arr[i]);
                }
            }
        }

        int index = k;
        while (pq.size() > 0) {
            ans[--index] = pq.remove();
        }

        return ans;
    }
}
