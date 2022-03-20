package com.Zolando;

/**
 * @author sanray on 3/20/2022
 */
public class Solution3 {
    public static void main(String[] args) {
        Solution3 sol = new Solution3();
        System.out.println(sol.solution("CBACD"));
        System.out.println(sol.solution("CABABD"));
    }

    public String solution(String S) {
        // write your code in Java SE 8
        String inputStr = S;
        StringBuilder str = new StringBuilder();
        while (str.length() != inputStr.length() && inputStr.length() > 0) {
            Character c = inputStr.charAt(0);
            str.append(c);
            for (int i = 1; i < inputStr.length(); i++) {
                if ((str.charAt(str.length() - 1) == 'A' && inputStr.charAt(i) == 'B') || (
                        str.charAt(str.length() - 1) == 'B' && inputStr.charAt(i) == 'A')) {
                    str.deleteCharAt(str.length() - 1);
                    // Remove Both
                    continue;
                } else if ((str.charAt(str.length() - 1) == 'C' && inputStr.charAt(i) == 'D') || (
                        str.charAt(str.length() - 1) == 'D'
                                && inputStr.charAt(i) == 'C')) {
                    str.deleteCharAt(str.length() - 1);
                    continue;
                } else {
                    str.append(inputStr.charAt(i));
                }
            }
            inputStr = str.toString();
        }
        return str.toString();
    }
}
