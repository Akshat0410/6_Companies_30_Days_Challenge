package com.anupam.challenge.Microsoft.Day13;

//Question :- Possible Words From Phone Digits

import java.util.ArrayList;
import java.util.Scanner;

public class WordsFromDiigits {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] ar = new int[n];
        for (int i = 0; i < n; i++) ar[i] = sc.nextInt();

        ArrayList<String> ans = possibleWords(ar, n);
        System.out.println(ans);
    }

    private static ArrayList<String> possibleWords(int[] a, int n) {
        ArrayList<String> ans = new ArrayList<>();
        if (n == 0)
            return ans;

        int index = 0;
        String output = "";
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        solve(a, n, index, keypad, output, ans);
        return ans;
    }

    private static void solve(int[] a, int n, int index, String[] keypad, String output, ArrayList<String> ans) {
        if (index >= n) {
            ans.add(output);
            return;
        }

        String temp = keypad[a[index]];
        for (int i = 0; i < temp.length(); i++) {
            char ch = temp.charAt(i);
            solve(a, n, index + 1, keypad, output + ch, ans);
        }

    }
}
