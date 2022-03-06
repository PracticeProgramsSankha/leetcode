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
        HashMap<String, HashMap<Character, Integer>> mapWords1 = new HashMap<>();
        for (String word : words1) {
            mapWords1.put(word, createMap(word));
        }

        // Create Map
        HashMap<String, HashMap<Character, Integer>> mapWords2 = new HashMap<>();
        for (String word : words2) {
            mapWords2.put(word, createMap(word));
        }

        String w2 = String.join("", Arrays.asList(words2));
        HashMap<Character, Integer> multiplicity = createMap(w2);

        // Now Check m2 in m1
        HashSet<String> set = new HashSet<>();
        for (Map.Entry<String, HashMap<Character, Integer>> entry : mapWords2.entrySet()) {
            HashMap<Character, Integer> m1Value = entry.getValue();
            set.addAll(getMatches(mapWords1, m1Value, multiplicity));
        }

        return new ArrayList<>(set);

    }

    public HashSet<String> getMatches(HashMap<String, HashMap<Character, Integer>> m1, Map<Character, Integer> m2,
            final HashMap<Character, Integer> multiplicity) {
        HashSet<String> set = new HashSet<>();
        for (String key : m1.keySet()) {
            Map<Character, Integer> m1Val = m1.get(key);

            if (m1Val.size() < m2.size()) {
                continue;
            }

            boolean found = true;
            for (Character m2Char : m2.keySet()) {
                if (m1Val.containsKey(m2Char)) {
                    if (m1Val.get(m2Char) >= m2.get(m2Char) &&
                            checkMulti(key, multiplicity.keySet()) /*&&
                            m1Val.get(m2Char) >= multiplicity.get(m2Char)*/) {
                        found &= true;
                    } else {
                        found &= false;
                    }
                }
            }
            if (found && m1Val.keySet().containsAll(m2.keySet()) && m1Val.keySet().containsAll(multiplicity.keySet())) {
                set.add(key);
            }
        }
        return set;
    }

    private boolean checkMulti(final String key, final Set<Character> multiplicity) {
        for(Character ch : multiplicity) {
            if(key.indexOf(ch) == -1) {
                return false;
            }
        }
        return true;
    }

    public HashMap<Character, Integer> createMap(String input) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (Character ch : input.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        return map;
    }
}
