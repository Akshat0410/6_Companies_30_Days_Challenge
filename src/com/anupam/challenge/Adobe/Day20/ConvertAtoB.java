package com.anupam.challenge.Adobe.Day20;

//Question :- Minimum operations to convert array A to B

import java.util.*;
public class ConvertAtoB {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();
        int[] A = new int[n];
        int[] B = new int[m];
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        for (int i = 0; i < m; i++) {
            B[i] = sc.nextInt();
        }
        int ans = minInsAndDel(A, B, n, m);
        System.out.println(ans);
    }

    private static int minInsAndDel(int[] A, int[] B, int N, int M) {
        List<Integer> a = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < M; i++) {
            set.add(B[i]);
        }
        for (int i = 0; i < N; i++) {
            if (set.contains(A[i])) {
                a.add(A[i]);
            }
        }
        int l = minInsertionDeletion(a.stream().mapToInt(Integer::intValue).toArray());
        return N - l + M - l;
    }

    private static int minInsertionDeletion(int[] arr) {
        if (arr.length == 0) {
            return 0;

        }
        int[] tail = new int[arr.length];
        int len = 1;
        tail[0] = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > tail[len - 1]) {
                tail[len++] = arr[i];
            } else {
                int id = Arrays.binarySearch(tail, 0, len - 1, arr[i]);
                if (id < 0) {
                    id = -1 * id - 1;
                }
                tail[id] = arr[i];
            }
        }
        return len;
    }
}
