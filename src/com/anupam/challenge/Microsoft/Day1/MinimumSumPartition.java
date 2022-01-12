package com.anupam.challenge.Microsoft.Day1;

//Question :- Divide an array into two sets S1 and S2 such that the absolute difference between their sums is minimum and find the minimum difference

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MinimumSumPartition {

    static int ans= Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] ar=new int[n];
        for(int i=0;i<n;i++){
            ar[i]=sc.nextInt();
        }

        int val=minDifference(ar,n);
        System.out.println(val);
    }

    private static int minDifference(int[] ar, int n) {


        int[] dp=new int[n+1];

        Arrays.fill(dp, -1);

        ArrayList<Integer> ar1=new ArrayList<>();
        ArrayList<Integer> ar2=new ArrayList<>();
        int sum1=0,sum2=0;
        subset(0,ar,ar1,ar2,sum1,sum2,dp);

        return ans;
    }

    private static void subset(int index,int[] ar, ArrayList<Integer> ar1, ArrayList<Integer> ar2, int sum1, int sum2,int[] dp) {

        if(index==ar.length){
            int diff=Math.abs(sum1-sum2);

            if(dp[index]!=-1) {
                ans = dp[index];
                return;
            }

            if(diff<ans){
                ans=diff;
                dp[index]=ans;
            }
            return;
        }

        ar1.add(ar[index]);
        subset(index+1,ar,ar1,ar2,sum1+ar[index],sum2,dp);
        ar1.remove(ar1.size()-1);

        ar2.add(ar[index]);
        subset(index+1,ar,ar1,ar2,sum1,sum2+ar[index],dp);
        ar2.remove(ar2.size()-1);



    }


}
