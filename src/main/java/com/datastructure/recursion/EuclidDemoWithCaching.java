package com.datastructure.recursion;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;


/**
 * @author sanray on 10/28/2021
 */
public class EuclidDemoWithCaching {
    public static void main(String[] args) {
        findGcd(43, 10);
        findGcd(6, 4);
        findGcd(116, 6);
    }

    private static void findGcd(final int a, final int b) {
        Map<Integer, Integer> cache = new HashMap<>();
        System.out.println(String.format("GCD of %d and %d is %d", a, b, gcd(a, b, cache)));
    }

    private static int gcd(final int a, final int b, Map<Integer, Integer> cache) {
        if (b == 0) {
            cache.put(b, a);
            return a;
        }
        if (!cache.containsKey(a % b)) {
            cache.put(b, gcd(b, a % b, cache));
        }
        return cache.get(b);
    }
}
