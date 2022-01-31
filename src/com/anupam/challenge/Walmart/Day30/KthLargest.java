package com.anupam.challenge.Walmart.Day30;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class KthLargest {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int k=sc.nextInt(),n=sc.nextInt();
        String[] ar=new String[n];
        for(int i=0;i<n;i++) ar[i]=sc.next();

        String ans=kthLargestNumber(ar,k);
        System.out.println(ans);
    }

    private static String kthLargestNumber(String[] nums, int k) {
        Arrays.sort(nums, new Comparator<String>(){
            @Override
            public int compare(String a, String b){
                if(a.length() != b.length()) return a.length() - b.length();
                return a.compareTo(b);
            }
        });
        return nums[nums.length-k];
    }
}
