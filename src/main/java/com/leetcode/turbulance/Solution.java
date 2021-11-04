package com.leetcode.turbulance;

import java.util.Map;
import java.util.function.BiPredicate;
import com.google.common.collect.ImmutableMap;


public class Solution {

    private Map<Boolean, BiPredicate<Integer, Integer>> predicatesMap = new ImmutableMap.Builder<Boolean,
            BiPredicate<Integer, Integer>>()
            .put(Boolean.TRUE, (elem1, elem2) -> elem1 >= elem2)
            .put(Boolean.FALSE, (elem1, elem2) -> elem1 <= elem2)
            .build();

    public int maxTurbulenceSize(int[] arr) {
        if(arr.length == 0) {
            return 0;
        }

        if(arr.length == 1) {
            return 1;
        }
        int maxSize = 0;
        boolean comparator = true; // denotes
        int ans = 1;
        int anchor =0, c;
        for (int i = 0; i < arr.length - 1; i++) {
            c = Integer.compare(arr[i], arr[i+1]);

            if(c == 0) {
                anchor = i;
            } else if(i == arr.length - 2 || c * Integer.compare(arr[i+1], arr[i+2]) != -1) {
                ans = Math.max(ans, i - anchor + 1);
                anchor = i;
            }


/*            if (isValid(arr[i], arr[i + 1], comparator)) {
                maxSize++;
            } else {
                // Start from beginning
                maxSize = 0;
                comparator = i % 2 != 0;
            }*/
        }
        //return maxSize;
        return ans;
    }

    public boolean isValid(int elem1, int elem2, boolean comparator) {
        return predicatesMap.get(comparator).test(elem1, elem2);
    }
}
