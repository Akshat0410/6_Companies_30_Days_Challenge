package com.anupam.challenge.Amazon.Day9;

//Question :- First non-repeating character in a stream

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.next();
        String ans=FirstNonRepeating(s);
        System.out.println(ans);
    }

    private static String FirstNonRepeating(String A) {
        StringBuilder ret = new StringBuilder();
        int isRepeated[] = new int[26];
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < A.length(); i++) {
            char ch = A.charAt(i);
            if (isRepeated[ch - 'a'] == 0)
                queue.add(ch);

            isRepeated[ch - 'a']++;
            while (!queue.isEmpty() && isRepeated[queue.peek() - 'a'] != 1)
                queue.poll();
            ret.append(queue.isEmpty() ? '#' : queue.peek());

        }
        return  ret.toString();
    }
}
