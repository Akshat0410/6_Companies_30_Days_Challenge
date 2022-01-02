
// Question :- Overlapping Intervals

package com.anupam.challenge.GoldmanSachs.Day1;

import java.util.Scanner;

public class OverlappingRectangle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] l1 = new int[2];
        int[] l2 = new int[2];
        int[] r1 = new int[2];
        int[] r2 = new int[2];
        for (int i = 0; i < 2; i++) {
            l1[i] = sc.nextInt();
            r1[i] = sc.nextInt();
            l2[i] = sc.nextInt();
            r2[i] = sc.nextInt();
        }
        int ans = doOverlap(l1, r1, l2, r2);
        if (ans == 1)
            System.out.println("The rectangles overlap");
        else
            System.out.println("The rectangles do not overlap");
    }

    private static int doOverlap(int[] L1, int[] R1, int[] L2, int[] R2) {
        Point p1 = new Point(L1[0], L1[1]);
        Point p2 = new Point(L2[0], L2[1]);
        Point p3 = new Point(R1[0], R1[1]);
        Point p4 = new Point(R2[0], R2[1]);

        if (p1.x > p4.x || p2.x > p3.x)
            return 0;


        if (p1.y < p4.y || p2.y < p3.y)
            return 0;

        return 1;
    }
}

class Point {

    int x, y;

    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
