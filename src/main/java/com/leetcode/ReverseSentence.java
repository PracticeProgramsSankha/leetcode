package com.leetcode;

/**
 * @author sanray on 3/4/2022
 */
public class ReverseSentence {

    public static void main(String[] args) {
        ReverseSentence sol = new ReverseSentence();
        System.out.println(sol.reverseSentenceByWords("HELLO WORLD GOOD MORNING"));
    }

    private String reverseSentenceByWords(final String inputString) {
        // Reverse the Entire String
        int len = inputString.length();
        char [] chars = new char[len];

        for(int i = 0; i < len; i++) {
            chars[(len-1)-i] = inputString.charAt(i);
        }

        // Reverse Each Work Now
        StringBuilder builder = new StringBuilder();
        for(int i = 0; i < len;) {
            //StringBuilder word = new StringBuilder();
            int spaceIndex = i;
            while(spaceIndex < len && chars[spaceIndex] != ' ') {
                spaceIndex++;
            }
            for(int j = spaceIndex-1; j >=i ; j--) {
                builder.append(chars[j]);
            }
            i = spaceIndex+1;
            builder.append(' ');
        }
        return builder.toString();
    }

}
