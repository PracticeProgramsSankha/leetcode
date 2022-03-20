package com.PayPay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;


/**
 * @author sanray on 3/20/2022
 */
public class Solution1 {
    public static void main(String[] args) {
        Solution1 sol = new Solution1();
        System.out.println(sol.solution("hit", "cog",
                new String[] { "hot", "dot", "dog", "lot", "log", "cog" }));
    }

    int solution(String beginWord, String endWord, String[] wordList) {
        Set<String> wordsSet = new HashSet<>(Arrays.asList(wordList));
        if (!wordsSet.contains(endWord)) {
            return 0;
        }
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);

        Set<String> visited = new HashSet<>();
        queue.add(beginWord);

        int numChanges = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return numChanges;
                }

                for (int j = 0; j < word.length(); j++) {
                    for (int k = 'a'; k < 'z'; k++) {
                        char chArr[] = word.toCharArray();
                        chArr[j] = (char) k;

                        String str = new String(chArr);
                        if (wordsSet.contains(str) && !visited.contains(str)) {
                            queue.add(str);
                            visited.add(str);
                        }
                    }
                }
            }
            numChanges++;
        }
        return 0;

    }
}

