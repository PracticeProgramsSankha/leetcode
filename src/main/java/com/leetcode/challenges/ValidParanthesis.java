package com.leetcode.challenges;

import java.util.HashMap;
import java.util.Map;


/**
 * @author sanray on 11/12/2021
 */
public class ValidParanthesis {
    public static void main(String[] args) {
        System.out.println(isValid("()"));

    }

    public static boolean isValid(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            switch (c) {
                case '(':
                case '{':
                case '[':
                    map.put(c, map.getOrDefault(c, 0) + 1);
                    break;
                case ')':
                    map.put('(', map.getOrDefault('(', 0) - 1);
                    break;
                case '}':
                    map.put(c, map.getOrDefault('{', 0) - 1);
                    break;
                case ']':
                    map.put(c, map.getOrDefault('[', 0) - 1);
                    break;
                default:
                    break;
            }
        }

        for (Integer count : map.values()) {
            if (count != 0) {
                return false;
            }
        }

        return true;

    }
}
