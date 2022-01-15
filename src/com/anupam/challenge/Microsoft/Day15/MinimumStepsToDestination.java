package com.anupam.challenge.Microsoft.Day15;

//Question :- Minimum steps to destination

import java.util.Scanner;

public class MinimumStepsToDestination {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int D = sc.nextInt();
        int ans = minSteps(D);
        System.out.println(ans);
    }

    private static int minSteps(int D) {
        D = Math.abs(D);
        int s = 0;
        int i = 1;
        while (s < D || (s - D) % 2 != 0) s += i++;
        return i - 1;
    }
}
