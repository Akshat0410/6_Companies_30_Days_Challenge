package com.anupam.challenge.GoldmanSachs.Day4;

// Question:-  Squares in N*N Chessboard

import java.util.Scanner;
public class SquareInAChessBoard {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        long ans = squaresInChessBoard(n);
        System.out.println(ans);
    }

    private static long squaresInChessBoard(long N) {

        return (N * (N + 1) * ((2 * N) + 1)) / 6;
    }
}
