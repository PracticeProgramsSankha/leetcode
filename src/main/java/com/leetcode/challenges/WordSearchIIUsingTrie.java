package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordSearchIIUsingTrie {

    public static void main(String[] args) {
        WordSearchIIUsingTrie sol = new WordSearchIIUsingTrie();
        System.out.println(sol.findWords(new char[][] { { 'a', 'a' } }, new String[] { "aaa" }));
        System.out.println(sol.findWords(new char[][] { { 'a' } }, new String[] { "a" }));
        System.out.println(sol.findWords(new char[][] { { 'a', 'b' }, { 'c', 'd' } }, new String[] { "abcb" }));
        System.out.println(sol.findWords(
                new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                        { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" }));
    }

    class TrieNode {
        char ch;
        TrieNode[] children;
        String word;
        boolean isEnd;

        TrieNode(char ch) {
            this.ch = ch;
            this.isEnd = false;
            this.children = new TrieNode[26];
            this.word = "";
        }
    }

    public TrieNode insert(TrieNode node, String word) {
        TrieNode temp = node;
        for (Character ch : word.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode(ch);
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
        temp.word = word;
        return node;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode node = new TrieNode('/');
        // Construct Trie with all words
        for (String word : words) {
            node = insert(node, word);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                solve(board, node, i, j, result);
            }
        }
        return result;

    }

    public void solve(char[][] board, TrieNode trie, int i, int j, List<String> result) {
        int temp = board[i][j] - 'a';
        if (board[i][j] == '.' || trie.children[temp] == null) {
            return;
        }
        trie = trie.children[temp];
        if (trie.isEnd) {
            result.add(trie.word);
            trie.isEnd = false;
        }
        char prev = board[i][j];
        board[i][j] = '.';
        if (i - 1 >= 0) {
            solve(board, trie, i - 1, j, result);
        }
        if (i + 1 < board.length) {
            solve(board, trie, i + 1, j, result);
        }
        if (j - 1 >= 0) {
            solve(board, trie, i, j - 1, result);
        }
        if (j + 1 < board[0].length) {
            solve(board, trie, i, j + 1, result);
        }
        board[i][j] = prev;

    }
}
