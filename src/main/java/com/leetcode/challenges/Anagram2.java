package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author sanray on 11/2/2021
 */
public class Anagram2 {

    public static void main(String[] args) {
        System.out.println(findAnagrams("abab", "ab"));
    }


    public static List<Integer> findAnagrams(String s, String p) {

        if(s == null || p == null) {
            return null;
        }

        if( p.length() > s.length()) {
            return null;
        }

        int subStringLength = p.length();

        List<Integer> indices = new ArrayList<>();
        for(int i = 0 ; i <= s.length() - subStringLength; i++ ) {
            if(isAnagram(s.substring(i, i + subStringLength), p)) {
                indices.add(i);
            }
        }


        return indices;


    }

    public static boolean isAnagram(String s, String t) {

        if(s == null || t == null) {
            return false;
        }

        if(s.length() != t.length()) {
            return false;
        }

        s = s.toLowerCase();
        t = t.toLowerCase();

        Map<Character, Integer> lettersMap = new HashMap<>();
        for(int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            lettersMap.put(ch, lettersMap.getOrDefault(ch, 0) + 1);
        }

        for(int i = 0; i < t.length(); i++) {
            Character ch = t.charAt(i);
            if(lettersMap.containsKey(ch)) {
                int count = lettersMap.get(ch);
                count--;
                if(count == 0) {
                    lettersMap.remove(ch);
                } else {
                    lettersMap.put(ch, count);
                }
            }
        }


        return lettersMap.size() == 0;


    }


}
