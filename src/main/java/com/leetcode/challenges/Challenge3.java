package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sanray on 10/20/2021
 */
public class Challenge3 {
    public int lengthOfLongestSubstring(String s) {

        if (s == null || s.length() == 0) {
            return 0;
        }

        List<Character> consecutive = new ArrayList<>();
        int maxSize = 0;
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (consecutive.contains(ch)) {
                int index = consecutive.indexOf(ch);
                maxSize = Math.max(maxSize, consecutive.size());
                for (int r = 0; r <= index; r++) {
                    consecutive.remove(0);
                }
            }
            consecutive.add(ch);
        }

        return Math.max(maxSize, consecutive.size());
    }
}
