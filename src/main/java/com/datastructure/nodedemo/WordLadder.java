package com.datastructure.nodedemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;


/**
 * @author sanray on 12/14/2021
 */
public class WordLadder {
    public static void main(String[] args) {

        test1();

    }

    private static void test1() {
        System.out.println(ladderLength("hit", "cog",
                Arrays.asList("hot", "dot", "dog", "lot", "log", "cog")));
    }

    public static int ladderLength(String beginWord, String endWord, List<String> wordList) {

        if (!wordList.contains(endWord)) {
            return 0;
        }

        Stack<String> stack = new Stack<>();
        stack.push(beginWord);
        List<String> result = new ArrayList<>();
        if(!wordList.contains(beginWord)) {
            result.add(beginWord);
        }

        HashMap<String, List<String>> differsByOne = new HashMap<>();
        for (int i = 0; i < wordList.size() - 1; i++) {
            int[] freq1 = getFrequency(wordList.get(i));
            for (int j = 1; j < wordList.size(); j++) {
                int[] freq2 = getFrequency(wordList.get(j));
                if (doesDiffersByOne(freq1, freq2)) {
                    if (!differsByOne.containsKey(wordList.get(i))) {
                        differsByOne.put(wordList.get(i), new ArrayList<>());
                    }
                    differsByOne.get(wordList.get(i)).add(wordList.get(j));

                    if (!differsByOne.containsKey(wordList.get(j))) {
                        differsByOne.put(wordList.get(j), new ArrayList<>());
                    }
                    differsByOne.get(wordList.get(j)).add(wordList.get(i));
                }
            }
        }

        return 0;
    }

    public static int[] getFrequency(String s) {
        int[] freq = new int[26];
        for (Character c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        return freq;
    }

    public static boolean doesDiffersByOne(int[] freq1, int[] freq2) {
        int totalDiffs = 0;
        for (int i = 0; i < freq1.length; i++) {
            totalDiffs += Math.abs(freq1[i] - freq2[i]);
        }
        return totalDiffs == 2;
    }
}
