package com.anupam.challenge.GoldmanSachs.Day3;

//Question:- Find Positions

import java.util.Scanner;

public class FindPosition {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();
        int ans=findPosition(n,m,k);
        System.out.println(ans);
    }

    private static int findPosition(int n, int m, int k) {

        //To check if the no of items to be delivered is less than the remaining people in the circle starting from k

        if (m <= (n - k) + 1)
            return k + m - 1;

        m = m - (n - k + 1); //Calculating the remaining items after delivering once in the complete circle

        return m % n == 0 ? n : m % n;
    }
}
