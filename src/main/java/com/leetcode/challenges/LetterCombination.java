package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;


/**
 * https://leetcode.com/problems/letter-combinations-of-a-phone-number/submissions/
 * @author sanray on 11/13/2021
 */
public class LetterCombination {
    public static void main(String[] args) {

        System.out.println(letterCombinations("234"));

    }

    public static List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        Map<Character, List<String>> letterMap = new HashMap<>();
        letterMap.put('1', new ArrayList<>());
        letterMap.put('2', Arrays.asList("a", "b", "c"));
        letterMap.put('3', Arrays.asList("d", "e", "f"));
        letterMap.put('4', Arrays.asList("g", "h", "i"));
        letterMap.put('5', Arrays.asList("j", "k", "l"));
        letterMap.put('6', Arrays.asList("m", "n", "o"));
        letterMap.put('7', Arrays.asList("p", "q", "r", "s"));
        letterMap.put('8', Arrays.asList("t", "u", "v"));
        letterMap.put('9', Arrays.asList("w", "x", "y", "z"));

        if (digits.length() == 1) {
            return letterMap.get(digits.charAt(0));
        }

        List<String> result = new ArrayList<>();
        Stack<String> stack = new Stack<>();
        List<String> letters = letterMap.get(digits.charAt(digits.length() - 1));
        for (String letter : letters) {
            stack.push(letter);
        }
        for (int i = digits.length() - 2; i >= 0; i--) {
            List<String> rr = new ArrayList<>();
            while (!stack.isEmpty()) {
                String item = stack.pop();
                letters = letterMap.get(digits.charAt(i));
                for (String letter : letters) {
                    rr.add(letter + item);
                }
            }
            stack.addAll(rr);
        }

        result.addAll(stack);

        return result;
    }

}
