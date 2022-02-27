package com.google;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;


/**
 * @author sanray on 2/23/2022
 * <p>
 * Player 1: 1351
 * Player 2: 1234 -> bulls: 1, cows: 1
 * Player 2: 1322 -> bulls: 2, cows: 0
 * Player 2: 1356 -> bulls: 3, cows: 0
 * Player 2: 3115 -> bulls: 0, cows: 4
 * Player 2: 1111 -> bulls: 2, cows: 0
 * Player 2: 1351 -> bulls: 4, cows: 0
 */
public class BullsAndCows {

    public static void main(String[] args) {
        BullsAndCows bc = new BullsAndCows();
        System.out.println("expected [1,1] : " + bc.guess("1351", "1234"));
        System.out.println("expected [2,0] : " + bc.guess("1351", "1322"));
        System.out.println("expected [3,0] : " + bc.guess("1351", "1356"));
        System.out.println("expected [0,4] : " + bc.guess("1351", "3115"));
        System.out.println("expected [2,0] : " + bc.guess("1351", "1111"));
        System.out.println("expected [4,0] : " + bc.guess("1351", "1351"));
        System.out.println("expected [1,0] : " + bc.guess("11", "01"));
        System.out.println("expected [1,3] : " + bc.guess("1807", "7810"));
        System.out.println("expected [1,1] : " + bc.guess("1123", "0111"));

    }

    List<Integer> guess(String player1, String player2) {
        Map<Character, List<Integer>> m1 = getIndicesMap(player1);
        Map<Character, List<Integer>> m2 = getIndicesMap(player2);

        List<Character> bulls = new ArrayList<>();
        List<Character> cows = new ArrayList<>();
        // Count bulls
        for (Character ch : m1.keySet()) {
            if (m2.containsKey(ch)) {
                for (Integer index : m1.get(ch)) {
                    if (m2.get(ch).contains(index)) {
                        bulls.add(ch);
                        m2.get(ch).remove(index);
                        if(!m2.get(ch).contains(index)) {
                            cows.remove(ch);
                        }
                    }
                    else if (!bulls.contains(ch)) {
                        cows.add(ch);
                    }
                }
            }
        }
        return Arrays.asList(bulls.size(), cows.size());
    }

    public static Map<Character, List<Integer>> getIndicesMap(String s) {
        Map<Character, List<Integer>> m1 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            if (!m1.containsKey(ch)) {
                m1.put(ch, new ArrayList<>());
            }
            List<Integer> indices = m1.get(ch);
            indices.add(i);
        }
        return m1;
    }
}
