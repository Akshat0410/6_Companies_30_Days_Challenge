package com.anupam.challenge.GoldmanSachs.Day5;

//Question :- Decode the string

import java.util.Scanner;
import java.util.Stack;

public class DecodeTheString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String ans = decodedString(s);
        System.out.println(ans);
    }

    private static String decodedString(String s) {

        Stack<Integer> num = new Stack<>();
        Stack<String> ch = new Stack<>();
        StringBuilder ans = new StringBuilder();
        int index = 0;
        while (index < s.length()) {
            if (Character.isDigit(s.charAt(index))) {
                int count = 0;
                while (Character.isDigit(s.charAt(index))) {  //To get the total digits
                    count = 10 * count + s.charAt(index) - '0';
                    index += 1;
                }

                num.push(count);

            } else if (s.charAt(index) == '[') {
                ch.push(ans.toString());
                ans = new StringBuilder();
                index += 1;
            } else if (s.charAt(index) == ']') {

                StringBuilder temp = new StringBuilder(ch.pop());
                int counts = num.pop();
                temp.append(ans.toString().repeat(Math.max(0, counts)));
                ans = new StringBuilder(temp.toString());
                index += 1;
            } else {
                ans.append(s.charAt(index));
                index += 1;
            }
        }
        return ans.toString();
    }
}
