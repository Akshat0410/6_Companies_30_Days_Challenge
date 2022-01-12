package com.anupam.challenge.Microsoft.Day1;

//Question :- Rotate by 90 degree

import java.util.Arrays;
import java.util.Scanner;

public class RotateMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] matrix=new int[n][n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                matrix[i][j]= sc.nextInt();
            }
        }

        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix));
    }

    private static void rotate(int[][] matrix) {
        int rows=matrix.length;
        int column=matrix[0].length;
        for(int i=0;i<rows;i++){
            for(int j=i;j<column;j++){
                int temp;
                temp=matrix[i][j];
                matrix[i][j]=matrix[j][i];
                matrix[j][i]=temp;
            }
        }


        for(int i=0;i<(rows+1)/2;i++){
            for(int j=0;j<column;j++){
                int temp=matrix[i][j];
                matrix[i][j]=matrix[rows-i-1][j];
                matrix[rows-i-1][j]=temp;
            }
        }

    }
}
