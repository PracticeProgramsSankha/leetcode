package com.leetcode.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.TreeSet;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;


/**
 * https://leetcode.com/problems/word-break/
 **/

public class WordBreak {

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        Assert.assertEquals("TEST1", true, sol.wordBreak("applepie", Arrays.asList("apple", "apple", "pear", "pie")));
        Assert.assertEquals("TEST2", false, sol.wordBreak("applepeer", Arrays.asList("apple", "apple", "pear", "pie")));
        Assert.assertEquals("TEST3", true,sol.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));  // true
        Assert.assertEquals("TEST4", true,sol.wordBreak("leetcode", Arrays.asList("leet", "code"))); //true
        Assert.assertEquals("TEST5", true,sol.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); //true
        Assert.assertEquals("TEST6", false,
                sol.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); //false

        System.out.println("all test passed");
    }

    class TrieNode {
        TrieNode[] children;
        Character ch;
        String word;
        boolean isEnd;

        TrieNode(Character ch) {
            this.ch = ch;
            this.children = new TrieNode[26];
            this.word = "";
            this.isEnd = false;
        }

        public boolean isChildren(Character ch) {
            return this.children[ch - 'a'] != null;
        }
    }

    TrieNode insert(TrieNode root, String word) {

        if (root == null) {
            root = new TrieNode('/');
        }

        TrieNode temp = root;

        for (Character ch : word.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode(ch);
            }
            temp = temp.children[ch - 'a'];
        }
        temp.word = word;
        temp.isEnd = true;
        return root;
    }

    TrieNode trie = new TrieNode('/');
    boolean[] visited;

    public boolean wordBreak(String inputStr, List<String> wordDict) {
        trie = getTrieNode(wordDict);
        visited = new boolean[inputStr.length()];

        return traverse(inputStr, 0);
    }

    private boolean traverse(final String inputStr, int idx) {

        TrieNode curr = trie;
        //end state
        if (idx == inputStr.length()) {
            return true;
        }

        if (visited[idx] == true) {
            return false;
        }
        visited[idx] = true;

        //traverse
        while (idx < inputStr.length() && curr.isChildren(inputStr.charAt(idx))) {
            curr = curr.children[inputStr.charAt(idx) - 'a'];
            if (curr.isEnd) {
                // As soon as we reach to leaf node, iterate over the trie until the input string comes to end
                // e,g apple with be at end, the pie will start from beg.
                boolean answer = traverse(inputStr, idx + 1);
                if (answer) {
                    return true;
                }
            }
            idx++;
        }

        //not found, back track or possibly exit
        return false;
    }

    private TrieNode getTrieNode(final List<String> wordDict) {
        TrieNode head = new TrieNode('/');
        for (String word : wordDict) {
            insert(head, word);
        }
        return head;
    }
}
