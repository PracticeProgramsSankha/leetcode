package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.List;


/**
 * @author sanray on 3/4/2022
 */
public class RestoreIPAddress {
    public static void main(String[] args) {
        RestoreIPAddress sol = new RestoreIPAddress();
        System.out.println(sol.restoreIpAddresses("25525511135"));
    }

    List<String> result = new ArrayList<>();

    public List<String> restoreIpAddresses(String s) {

        for (int i = 0; i < s.length(); i++) {

        }
        return null;

    }

    private void dp(String input, int count, int startIndex, List<String> builder) {
        if (count > 4) {
            return;
        }
        // Check is in range
        String subnet = input.substring(startIndex, startIndex + 1);
        if (isInRange(subnet)) {
            builder.add(subnet);
        }
        if (builder.size() == 4) {
            return;
        }
        //
        dp(input, count + 1, startIndex + 1, builder);
        dp(input, count + 1, startIndex + 2, builder);
    }

    boolean isInRange(String subnet) {
        Integer in = Integer.parseInt(subnet);
        return in >= 0 && in <= 255;
    }

/*
    private void createCombination(String s, String ip,
            int i, int n_unused, int numDots, List<String> ipList) {
        if(numDots == 0) {
            //handle base case
            if(i == s.length()) {
                ipList.add(ip);
            }
            return;
        }

        for(int k=i+1; k<=s.length(); k++) {
            String octet = s.substring(i, k);
            if(octet.length() > 3) return;
            if(octet.length() > 1 && octet.charAt(0) == '0') {
                return;
            }
            int numOctet = Integer.parseInt(octet);
            if(numOctet >= 0 && numOctet < 256) {
                if(numDots == 1) {
                    createCombination(s, ip+octet, k, n_unused, numDots-1, ipList);
                } else {
                    createCombination(s, ip+octet+".", k, n_unused, numDots-1, ipList);
                }
            }
        }

    }*/
}
