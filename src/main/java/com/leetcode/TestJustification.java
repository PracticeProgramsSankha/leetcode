package com.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/text-justification/
 * <p>
 * https://www.youtube.com/watch?v=GqXlEbFVTXY
 * 04/11
 */
public class TestJustification {
    public static void main(String[] args) {
        TestJustification sol = new TestJustification();
        check(Arrays.asList(
                        "This    is    an",
                        "example  of text",
                        "justification.  "),
                sol.fullJustify(new String[] { "This", "is", "an", "example", "of", "text", "justification." }, 16));
        System.out.println("All Tests passed..");
    }

    public static void check(List<String> expected, List<String> actual) {
        Assert.assertEquals("Length", expected.size(), actual.size());
        for (int i = 0; i < expected.size(); i++) {
            Assert.assertEquals("Line" + i, expected.get(i), actual.get(i));
        }
    }

    public List<String> fullJustify(String[] words, int maxWidth) {

        int wordIndx = 0;
        int maxWords = words.length;

        List<String> result = new ArrayList<>();

        while (wordIndx < maxWords) {
            int nextIndx = wordIndx + 1;
            int lineLength = words[wordIndx].length();
            // if word length + space needed is less than maxWidth, increment nextIndx
            while (nextIndx < maxWords && (lineLength + words[nextIndx].length() + (nextIndx - wordIndx - 1)
                    < maxWidth)) {
                lineLength += words[nextIndx].length();
                nextIndx++;
            }

            int diff = maxWidth - lineLength;
            int numberOfWords = nextIndx - wordIndx;
            if (numberOfWords == 1 || nextIndx >= maxWords) {
                result.add(leftJustify(words, wordIndx, nextIndx, diff));
            } else {
                result.add(middleJustify(words, wordIndx, nextIndx, diff));
            }
            wordIndx = nextIndx;
        }

        return result;

    }

    private String middleJustify(final String[] words, final int wordIndx, final int nextIndx, final int diff) {
        int spacedNeeded = nextIndx - wordIndx - 1;
        int spacesBetweenWords = diff / spacedNeeded;
        int extraSpaces = diff % spacedNeeded;
        StringBuilder line = new StringBuilder(words[wordIndx]);
        final String space = " ";
        for (int k = wordIndx + 1; k < nextIndx; k++) {
            int spacedToApply = spacesBetweenWords + (extraSpaces-- > 0 ? 1 : 0);
            while (spacedToApply-- > 0) {
                line.append(space);
            }
            line.append(words[k]);
        }
        return line.toString();
    }

    private String leftJustify(final String[] words, final int wordIndx, final int nextIndx, final int diff) {
        int spacesOnRight = diff - (nextIndx - wordIndx - 1);
        final String space = " ";
        StringBuilder line = new StringBuilder(words[wordIndx]);
        for (int k = wordIndx + 1; k < nextIndx; k++) {
            line.append(space + words[k]);
        }
        while (spacesOnRight-- > 0) {
            line.append(space);
        }
        return line.toString();
    }
}
