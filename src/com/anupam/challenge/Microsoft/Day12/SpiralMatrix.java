package com.anupam.challenge.Microsoft.Day12;

//Question:- Given a matrix of size r*c. Traverse the matrix in spiral form.

import java.util.ArrayList;
import java.util.Scanner;

public class SpiralMatrix {

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

        ArrayList<Integer> ans=new ArrayList<>();
        int minr=0,minc=0,maxr=matrix.length,maxc=matrix[0].length,cnt=0,tno=r*c;

        while(cnt<tno){

            //top wall

            for(int i=minc;i<maxc && cnt<tno;i++){
              ans.add(matrix[minr][i]);
              cnt++;
            }
            minr++;

            //right wall

            for(int i=maxc,j=minr;j<maxr && cnt<tno;j++){
                ans.add(matrix[j][i]);
                cnt++;
            }
            maxc--;

            //bottom wall

            for(int j=maxr,i=maxc;i>=minc && cnt<tno;i--){
                ans.add(matrix[j][i]);
                cnt++;
            }

            maxr--;


            //left wall

            for(int j=maxr,i=minc;j>=minr && cnt<tno;j--){
                ans.add(matrix[j][i]);
                cnt++;
            }

            minc++;
        }

        return ans;
    }
}
