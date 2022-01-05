package com.anupam.challenge.GoldmanSachs.Day5;

//Question :- Array Pair Sum Divisibility Problem

import java.util.HashMap;
import java.util.Scanner;

public class CanPair {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        boolean possible = canPair(nums, k);
        System.out.println(possible);
    }

    private static boolean canPair(int[] nums, int k) {
        HashMap<Integer, Integer> frequencyMap = new HashMap<>();
        for (int val : nums) {
            int rem = val % k;
            int fq=frequencyMap.getOrDefault(rem,0);
            frequencyMap.put(rem, fq + 1);
        }

        for (int keys : frequencyMap.keySet()) {
            if (keys == 0) {
                if (frequencyMap.get(keys) % 2 != 0) {
                    return false;
                }
            } else if (2 * keys == k) {
                if (frequencyMap.get(keys) % 2 != 0)
                    return false;
            } else {
                int freq = frequencyMap.get(keys);
                int r_freq = frequencyMap.getOrDefault(k - keys,0);
                if (freq != r_freq)
                    return false;
            }
        }
        return true;
    }
}
