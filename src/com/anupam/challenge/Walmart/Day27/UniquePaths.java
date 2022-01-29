package com.anupam.challenge.Walmart.Day27;

//Question : - Number of Unique Paths

import java.util.Scanner;

public class UniquePaths {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int a=sc.nextInt(),b=sc.nextInt();
        int ans=NumberOfPath(a,b);
        System.out.println(ans);
    }

    private static int NumberOfPath(int a, int b) {
        int N = a+b-2;
        int r= a-1;
        double res = 1;
        for(int i=1;i<=r;i++){
            res = res * (N-r+i)/i;
        }
        return (int)res;
    }
}
