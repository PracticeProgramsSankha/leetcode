package com.PayPay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;


/**
 * @author sanray on 3/20/2022
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(new int[] { 25, 2, 3, 57, 38, 41 }));
        System.out.println(sol.solution(new int[] { 1, 11, 122, 223,345 }));
    }

    int[] solution(int[] nums) {
        int maxFreq = Integer.MIN_VALUE;
        int[] freq = new int[10];
        for (int n : nums) {
            String numString = n + "";
            for (Character ch : numString.toCharArray()) {
                freq[ch - '0']++;
                int currFeq = freq[ch - '0'];
                if (currFeq > maxFreq) {
                    maxFreq = currFeq;
                }
            }
        }
        List<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            if (freq[i] == maxFreq) {
                resultList.add(i);
            }
        }
        System.out.println(resultList);
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }
        return result;
    }

}
