package com.leetcode.challenges;

/**
 * @author sanray on 12/2/2021
 */
public class CompareVersion {

    public static void main(String[] args) {
        //System.out.println(compareVersion("1.01", "1.001"));
        //System.out.println(compareVersion("1.0", "1.0.0"));
        //System.out.println(compareVersion("0.1", "1.1"));
        //System.out.println(compareVersion("1.0.1", "1"));
        System.out.println(compareVersion("1", "1.0.1"));
    }

    public static int compareVersion(String version1, String version2) {
        String[] subversion1 = version1.split("\\.");
        String[] subversion2 = version2.split("\\.");
        int length1 = subversion1.length;
        int length2 = subversion2.length;
        int i = 0;
        int j = 0;
        while (i < length1 && j < length2) {
            int val1 = Integer.parseInt(subversion1[i]);
            int val2 = Integer.parseInt(subversion2[j]);
            if (val1 < val2) {
                return -1;
            } else if (val1 > val2) {
                return 1;
            } else if (i == length1 - 1 && length1 == length2 && val1 == val2) {
                return 0;
            }
            i++;
            j++;
        }
        while (i < length1) {
            if (Integer.parseInt(subversion1[i]) > 0) {
                return 1;
            }
            i++;
        }
        while (j < length2) {
            if (Integer.parseInt(subversion2[j]) > 0) {
                return -1;
            }
            j++;
        }

        return 0;

    }
}
