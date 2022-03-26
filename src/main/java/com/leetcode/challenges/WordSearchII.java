package com.leetcode.challenges;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class WordSearchII {

    public static void main(String[] args) {
        WordSearchII sol = new WordSearchII();
        System.out.println(sol.findWords(new char[][] { { 'a', 'a' } }, new String[] { "aaa" }));
        System.out.println(sol.findWords(new char[][] { { 'a' } }, new String[] { "a" }));
        System.out.println(sol.findWords(new char[][] { { 'a', 'b' }, { 'c', 'd' } }, new String[] { "abcb" }));
        System.out.println(sol.findWords(
                new char[][] { { 'o', 'a', 'a', 'n' }, { 'e', 't', 'a', 'e' }, { 'i', 'h', 'k', 'r' },
                        { 'i', 'f', 'l', 'v' } }, new String[] { "oath", "pea", "eat", "rain" }));
    }

    public List<String> findWords(char[][] board, String[] words) {
        Set<String> result = new HashSet<>();
        for (String word : words) {
            Set<String> visited = new HashSet<>();
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    if (board[i][j] == word.charAt(0) && backTrack(board, word, i, j, 0, visited)) {
                        result.add(word);
                    }
                }
            }
            visited.clear();
        }

        return new ArrayList<>(result);
    }

    private boolean backTrack(final char[][] board, final String word, final int i, final int j, final int idx,
            final Set<String> visited) {
        final String pos = String.format("%d|%d", i, j);
        if (i < 0 || i > board.length - 1 || j < 0 || j > board[0].length - 1 || idx > word.length() - 1
                || board[i][j] != word.charAt(idx) || visited.contains(pos)) {
            return false;
        }
        if (board[i][j] == word.charAt(idx) && idx == word.length() - 1) {
            return true;
        }
        visited.add(pos);
        boolean result = backTrack(board, word, i - 1, j, idx + 1, visited) ||
                backTrack(board, word, i + 1, j, idx + 1, visited) ||
                backTrack(board, word, i, j - 1, idx + 1, visited) ||
                backTrack(board, word, i, j + 1, idx + 1, visited);
        visited.remove(pos);
        return result;
    }
}
