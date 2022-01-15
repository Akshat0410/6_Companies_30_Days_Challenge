package com.anupam.challenge.Microsoft.Day14;

//Question :- Generate Binary Numbers

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class GenerateBinaryNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<String> ans = generate(n);
        System.out.println(ans);
    }

    private static ArrayList<String> generate(int N) {
        ArrayList<String> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        q.add("1");
        for (int i = 0; i < N; i++) {
            ans.add(q.poll());
            q.add(ans.get(i) + "0");
            q.add(ans.get(i) + "1");
        }

        return ans;
    }
}
