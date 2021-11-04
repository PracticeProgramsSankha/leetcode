package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author sanray on 11/3/2021
 */
public class AnagramGroups {

    public static void main(String[] args) {

        System.out.println(groupAnagrams(new String[] { "aaaaaaaaaay", "azzzzzzzzzz" }));

        System.out.println(groupAnagrams(new String[] { "eat", "tea", "tan", "ate", "nat", "bat" }));
        //System.out.println(groupAnagrams(new String[]{"bd", "aacc"}));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }

        List<List<String>> listsOfList = new ArrayList<>();
        if (strs.length == 1) {
            List<String> list = new ArrayList<>();
            list.add(strs[0]);
            listsOfList.add(list);
            return listsOfList;
        }

        Map<String, List<String>> map = new HashMap<>();
        String[] keys = new String[strs.length];
        for (int i = 0; i < strs.length; i++) {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String hash = new String(chars);
            String str = getKey(strs[i]);
            keys[i] = str;
            if (!map.containsKey(hash)) {
                map.put(hash, new ArrayList<>());
            }
            map.get(hash).add(strs[i]);
        }

        System.out.println(keys[0].equals(keys[1]));

        listsOfList.addAll(map.values());
        return listsOfList;
    }

    private static String getKey(String str) {
        char [] arr = new char [26];
        for (int i=0; i<str.length(); i++) {
            arr[str.charAt(i)-'a']++;
        }
        return new String(arr);
    }

    public String computeHash(String str) {
        int[] frequencies = new int[26];
        for (int i = 0; i < str.length(); i++) {
            frequencies[str.charAt(i) - 'a']++;
        }

        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < 26; i++) {
            builder.append(frequencies[i] + ",");
        }
        /*
        long hash = 0;
        for(int i = 0 ; i < 26; i++) {
            hash += ((1 << (i + 1)) * (int)Math.pow(256, frequencies[i]));
        }
        return (hash) * str.length();
        */
        return builder.toString();
    }
}
