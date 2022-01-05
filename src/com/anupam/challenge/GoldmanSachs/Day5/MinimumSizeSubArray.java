package com.anupam.challenge.GoldmanSachs.Day5;

//Question :- Minimum Size SubArray

import java.util.Scanner;

public class MinimumSizeSubArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int target = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();
        int ans = minSubArrayLen(n, target, nums);
        System.out.println(ans);

    }

    private static int minSubArrayLen(int n, int target, int[] nums) {

        int max = Integer.MAX_VALUE;
        int left = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum = sum + nums[i];

            while (sum >= target) {
                max = Math.min(max, (i + 1) - left);
                sum -= nums[left];
                left++;
            }
        }

        return max == Integer.MAX_VALUE ? 0 : max;
    }
}
