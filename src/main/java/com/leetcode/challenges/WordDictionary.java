package com.leetcode.challenges;

import java.util.HashMap;


/*
https://leetcode.com/problems/design-add-and-search-words-data-structure/
   @sanray

 */
class WordDictionary {

    public static void main(String[] args) {
        test1();
        WordDictionary wordDictionary = new WordDictionary();
        wordDictionary.addWord("bad");
        wordDictionary.addWord("dad");
        wordDictionary.addWord("mad");
        wordDictionary.addWord("sankha");
        System.out.println(wordDictionary.search("pad")); // return False
        System.out.println(wordDictionary.search("bad")); // return True
        System.out.println(wordDictionary.search(".ad")); // return True
        System.out.println(wordDictionary.search("b..")); // return True
        System.out.println(wordDictionary.search("san...")); // return True
    }

    private static void test1() {
    }

    class TrieNode {
        Character value;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnding;

        TrieNode() {
            this.value = null;
            this.isEnding = false;
        }
    }

    private TrieNode rootNode;

    public WordDictionary() {
        rootNode = new TrieNode();

    }

    public void addWord(String word) {
        TrieNode temp = rootNode;
        for (Character ch : word.toCharArray()) {
            if (!temp.children.containsKey(ch)) {
                temp.children.put(ch, new TrieNode());
            }
            temp = temp.children.get(ch);
        }
        temp.isEnding = true;

    }

    public boolean search(String word) {

        return helper(rootNode, word, 0);
    }

    public boolean helper(TrieNode node, String word, int idx) {
        if (idx == word.length()) {
            return node.isEnding;
        }
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (Character key : node.children.keySet()) {
                if (helper(node.children.get(key), word, idx + 1)) {
                    return true;
                }
            }
        } else {
            if (node.children.containsKey(ch) && helper(node.children.get(ch), word, idx + 1)) {
                return true;
            }
        }
        return false;
    }
}
