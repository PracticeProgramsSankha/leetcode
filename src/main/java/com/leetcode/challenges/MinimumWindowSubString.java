package com.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;
import javax.print.DocFlavor;


/**
 * https://leetcode.com/problems/minimum-window-substring/
 *
 * @author sanray on 3/20/2022
 */
public class MinimumWindowSubString {
    public static void main(String[] args) {
        MinimumWindowSubString sol = new MinimumWindowSubString();
        System.out.println(sol.minWindow("ADOBECODEBANC", "ABC"));
    }

    public String minWindow(String s, String t) {

        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = getMap(t);
        int targetLength = t.length();
        int sourceLength = s.length();

        if (targetLength > sourceLength) {
            return "";
        }
        if (s.equals(t)) {
            return s;
        }
        int start = 0, end = Integer.MAX_VALUE;
        int i = 0, j = -1;
        while (j < sourceLength) {
            if (doesContain(sMap, tMap)) {
                if (j - i < end - start) {
                    start = i;
                    end = j;
                }
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) - 1);
                i++;
            } else {
                j++;
                if (j < sourceLength) {
                    sMap.put(s.charAt(j), sMap.getOrDefault(s.charAt(j), 0) + 1);
                }
            }
        }

        if (start == 0 && end == Integer.MAX_VALUE) {
            return "";
        } else {
            return s.substring(start, end + 1);
        }
    }

    private boolean doesContain(final HashMap<Character, Integer> sMap, final HashMap<Character, Integer> tMap) {
        for (Map.Entry<Character, Integer> entry : tMap.entrySet()) {
            if (!sMap.containsKey(entry.getKey()) || sMap.get(entry.getKey()) < entry.getValue()) {
                return false;
            }
        }
        return true;
    }

    private HashMap<Character, Integer> getMap(final String s) {
        HashMap<Character, Integer> freq = new HashMap<>();
        for (Character c : s.toCharArray()) {
            freq.put(c, freq.getOrDefault(c, 0) + 1);
        }
        return freq;
    }
}
