package com.leetcode.challenges;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;


/**
 * https://leetcode.com/problems/word-break/
 **/

public class WordBreak {

    public static void main(String[] args) {
        WordBreak sol = new WordBreak();
        System.out.println(sol.wordBreak("bb", Arrays.asList("a", "b", "bbb", "bbbb")));  // true
        System.out.println(sol.wordBreak("leetcode", Arrays.asList("leet", "code"))); //true
        System.out.println(sol.wordBreak("applepenapple", Arrays.asList("apple", "pen"))); //true
        System.out.println(sol.wordBreak("catsandog", Arrays.asList("cats", "dog", "sand", "and", "cat"))); //false
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

        //traversea
        while (idx < inputStr.length() && curr.isChildren(inputStr.charAt(idx))) {
            curr = curr.children[inputStr.charAt(idx) - 'a'];
            if (curr.isEnd) {
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
