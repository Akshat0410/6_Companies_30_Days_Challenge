package com.anupam.challenge.Amazon.Day8;

import java.util.Scanner;

public class LongestMountain {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];

        for(int i=0;i<n;i++)  ar[i]=sc.nextInt();

        int ans=longestMountain(ar);
        System.out.println(ans);
    }

    private static int longestMountain(int[] ar) {

        int count,ans=Integer.MIN_VALUE;
        boolean enter=false;
        for(int i=1;i<=ar.length-2;i++){
            count=1;
            if(ar[i]>ar[i-1] && ar[i]>ar[i+1]) {
                enter=true;
                int left = i;
                while (left > 0 && ar[left] > ar[left - 1]) {
                    left--;
                    count++;
                }
                int right = i;
                while (right < ar.length - 1 && ar[right] > ar[right + 1]) {
                    right++;
                    count++;
                }
            }
            ans = Math.max(ans, count);
        }
        return enter ? ans : 0;
    }
}
