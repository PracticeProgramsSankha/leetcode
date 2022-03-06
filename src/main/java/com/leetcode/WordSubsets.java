package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author sanray on 3/7/2022
 */
public class WordSubsets {

    public static void main(String[] args) {
        WordSubsets sol = new WordSubsets();
        /**
         * ["facebook","google","leetcode"]
         * ["google","leetcode"]
         * ["facebook","google"]
         */
        System.out.println(sol.wordSubsets(new String[] {
                        "amazon", "apple", "facebook", "google", "leetcode" },
                new String[] { "e", "o" }));

        System.out.println(sol.wordSubsets(new String[] {
                        "amazon", "apple", "facebook", "google", "leetcode" },
                new String[] { "lo", "eo" }));

        System.out.println(sol.wordSubsets(new String[] {
                        "amazon", "apple", "facebook", "google", "leetcode" },
                new String[] { "e", "oo" }));
    }

    public List<String> wordSubsets(String[] words1, String[] words2) {

        // Create Map
        HashMap<Character, Integer> mapWords2 = new HashMap<>();
        for (String word : words2) {
            HashMap<Character, Integer> curr = new HashMap<>();
            for (Character ch : word.toCharArray()) {
                curr.put(ch, curr.getOrDefault(ch, 0) + 1);
                mapWords2.put(ch, Math.max(mapWords2.getOrDefault(ch, 0), curr.get(ch)));
            }
        }

        List<String> result = new ArrayList<>();
        HashMap<Character, Integer> mapWords1 = new HashMap<>();
        for (String word : words1) {

            mapWords1 = createMap(word);

            boolean isUniversal = true;

            for (Character ch : mapWords2.keySet()) {
                if (!mapWords1.containsKey(ch) || mapWords1.get(ch) < mapWords2.get(ch)) {
                    isUniversal = false;
                    break;
                }
            }

            if (isUniversal) {
                result.add(word);
            }
        }

        return result;

    }

    public HashMap<Character, Integer> createMap(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }
}
