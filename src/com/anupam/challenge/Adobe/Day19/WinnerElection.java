package com.anupam.challenge.Adobe.Day19;

// Question :- Elections

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WinnerElection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] ar = new String[n];
        for (int i = 0; i < n; i++) {
            ar[i] = sc.next();
        }
        String[] ans = winner(ar, n);
        System.out.println(Arrays.toString(ans));
    }

    private static String[] winner(String[] arr, int n) {
        HashMap<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }

        int max = Integer.MIN_VALUE;
        String res = "";
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int val = entry.getValue();
            if (val > max) {
                max = val;
                res = key;
            } else if (val == max && res.compareTo(key) > 0) {
                res = key;
            }
        }
        String[] ans = new String[2];
        ans[0] = res;
        ans[1] = Integer.toString(max);
        return ans;
    }
}
