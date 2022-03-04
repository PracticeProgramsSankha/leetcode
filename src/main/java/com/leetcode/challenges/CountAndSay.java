package com.leetcode.challenges;

/**
 * @author sanray on 3/4/2022
 */
public class CountAndSay {
    public static void main(String[] args) {
        CountAndSay sol = new CountAndSay();
        System.out.println("Expected 1:, Found" + sol.countAndSay(1));
        System.out.println("1211, " + sol.countAndSay(4));
        System.out.println("111221, " + sol.countAndSay(5));
    }

    private String countAndSay(final int max) {
        countInternal("1", max, 1);
        return result;
    }

    String result;
    private void countInternal(String in, int max, int count) {
        if(count == max) {
            result = in;
            return;
        }
        StringBuilder builder = new StringBuilder();
        char[] chars = in.toCharArray();
        for(int i = 0 ; i < chars.length; i++) {
            int inc = 1;
            Character c = chars[i];
            while( i + 1 < chars.length && c == chars[i+1]) {
                inc++;
                i++;
            }
            builder.append(inc).append(c);
        }
        countInternal(builder.toString(), max, count+1);
    }
}
