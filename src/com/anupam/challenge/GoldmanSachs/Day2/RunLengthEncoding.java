package com.anupam.challenge.GoldmanSachs.Day2;
import java.util.Scanner;

public class RunLengthEncoding {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ans=encode(s);
        System.out.println(ans);
    }

    private static String encode(String s) {

        int count = 1, i;
        StringBuilder ans = new StringBuilder();
        for (i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (s.charAt(i) == s.charAt(i + 1)) {
                count++;
            } else {
                ans.append(c).append(count);
                count = 1;
            }

        }

        ans.append(s.charAt(i)).append(count);
        return ans.toString();

    }
}
