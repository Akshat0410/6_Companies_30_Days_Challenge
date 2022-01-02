
// Question :- Print Anagrams Together

package com.anupam.challenge.GoldmanSachs.Day1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class PrintAnagramTogether {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        String[] st = new String[n];
        for (int i = 0; i < n; i++) {
            st[i] = sc.next();
        }

        List<List<String>> ans = Anagrams(st);

        System.out.println(ans.toString());
    }

    private static List<List<String>> Anagrams(String[] st) {

        List<List<String>> ansFinal = new ArrayList<>();
        HashMap<HashMap<Character, Integer>, List<String>> bigMap = new HashMap<>();


        for (String s : st) {
            HashMap<Character, Integer> frequencyMap = new HashMap<>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                frequencyMap.put(ch, frequencyMap.getOrDefault(ch, 0) + 1);
            }

            if (!bigMap.containsKey(frequencyMap)) {
                List<String> ans = new ArrayList<>();
                ans.add(s);
                bigMap.put(frequencyMap, ans);
            } else {
                List<String> exists = bigMap.get(frequencyMap);
                exists.add(s);
            }

            ansFinal = new ArrayList<>(bigMap.values());

        }
        return ansFinal;
    }


}
