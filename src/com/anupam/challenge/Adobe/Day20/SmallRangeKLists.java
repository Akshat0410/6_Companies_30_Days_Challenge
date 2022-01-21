package com.anupam.challenge.Adobe.Day20;

//Question :- Smallest range in K lists

import java.util.PriorityQueue;
import java.util.Scanner;

public class SmallRangeKLists {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        int[] range;
        int[][] sorted=new int[k][n];
        for(int i=0;i<k;i++){
            for(int j=0;j<n;j++){
                sorted[i][j]=sc.nextInt();
            }
        }

        range=new Solution().findSmallestRange(sorted,n,k);
        System.out.println(range[0]+" "+range[1]);

    }
}

class Solution
{
    static class Element implements Comparable<Element> {
        int val;
        int ind;
        int row;
        Element (int val, int ind, int row) {
            this.val= val;
            this.ind= ind;
            this.row= row;
        }
        public int compareTo(Element e){
            return this.val- e.val;
        }
    }
    int[] findSmallestRange(int[][] KSortedArray,int n,int k)
    {
        int length, low= Integer.MAX_VALUE, high, max= Integer.MIN_VALUE;
        PriorityQueue<Element> pq= new PriorityQueue<>();
        for(int i=0; i<k; i++){
            max= Math.max(max, KSortedArray[i][0]);
            pq.add(new Element(KSortedArray[i][0], 0, i));
        }
        assert pq.peek() != null;
        length= max- pq.peek().val;
        low= pq.peek().val;
        high= max;
        while(true){
            Element x= pq.poll();
            int row= x.row;
            int ind= x.ind;
            if(!(ind+1<n)){
                break;
            } else {
                Element ne= new Element(KSortedArray[row][ind+1], ind+1, row);
                pq.add(ne);
                max= Math.max(max, KSortedArray[row][ind+1]);
                assert pq.peek() != null;
                if(length> max- pq.peek().val){
                    length= max- pq.peek().val;
                    low= pq.peek().val;
                    high= max;
                }
            }
        }
        return new int[]{low, high};
    }
}