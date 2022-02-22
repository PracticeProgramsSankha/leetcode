package com.datastructure.hackerearth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author sanray on 2/21/2022
 */
public class AnagramsGame {
    public static void main(String[] args) {
        AnagramsGame ag = new AnagramsGame();
        System.out.println(ag.check("abab", "ab"));
    }

    private List<Integer> check(final String s1, final String s2) {
        if(s2 == null || s2.isEmpty()) {
            return null;
        }
        if(s1 == null || s1.isEmpty()) {
            return null;
        }
        if(s1.length() < s2.length()) {
            return null;
        }
        int s2Len = s2.length();
        char[] s2Sorted = s2.toCharArray();
        Arrays.sort(s2Sorted);
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i <s1.length() - s2Len + 1; i++) {
            char[] ch = s1.substring(i, s2Len + i).toCharArray();
            Arrays.sort(ch);
            String subStr = new String(ch);
            if(subStr.equals(new String(s2Sorted))) {
                result.add(i);
            }
        }

        StringBuffer sb = new StringBuffer();
        sb.length()

        return result;
    }
}
