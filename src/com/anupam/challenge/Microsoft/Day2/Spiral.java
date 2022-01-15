package com.anupam.challenge.Microsoft.Day2;

//Question :- Given a matrix of size r*c. Traverse the matrix in spiral form.

import java.util.ArrayList;
import java.util.Scanner;

public class Spiral {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt(),c=sc.nextInt();
        int[][] ar=new int[r][c];
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                ar[i][j]=sc.nextInt();
            }
        }

        ArrayList<Integer> ans=spirallyTraverse(ar,r,c);
        System.out.println(ans);
    }

    private static ArrayList<Integer> spirallyTraverse(int[][] matrix, int r, int c) {
        ArrayList<Integer> arr = new ArrayList<>();
        int m = 0;
        int n = 0;
        int count = 0;
        for(int i = 0 ; i < r*c ; i ++)
        {
            arr.add(matrix[m][n]);
            if((m == count) && (n < (c - count - 1)))
            {
                n++;
            }
            else if((n == c - 1 - count) && (m < (r - count - 1)))
            {
                m++;
            }
            else if((m == r - 1 - count) && (n > count))
            {
                n--;
            }
            else if((n == count) && (m > count))
            {
                m--;
                if(m == count)
                {
                    count++;
                    m = count;
                    n = count;
                }
            }
        }
        return arr;
    }


}
