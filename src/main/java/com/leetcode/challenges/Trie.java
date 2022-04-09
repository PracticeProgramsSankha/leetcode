package com.leetcode.challenges;

public class Trie {
    public static void main(String[] args) {

        //test2();
        test1();

    }

    private static void test1() {
        System.out.println("TEST1");
        Trie sol = new Trie();
        sol.insert("apple");
        System.out.println(sol.search("applea"));
        System.out.println(sol.startsWith("app"));
        System.out.println(sol.search("app"));
        sol.insert("app");
        System.out.println(sol.search("app"));
        System.out.println(sol.startsWith("app"));
    }

    private static void test2() {
        System.out.println("TEST2");
        Trie sol = new Trie();
        sol.insert("a");
        System.out.println(sol.search("a"));
        System.out.println(sol.startsWith("a"));
    }

    class TrieNode {
        char ch;
        TrieNode[] children;
        boolean isEnd;
        String word;

        TrieNode() {
            this.children = new TrieNode[26];
            ch = '/';
            isEnd = false;
            word = "";
        }

        TrieNode(char ch) {
            this();
            this.ch = ch;
        }
    }

    TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode temp = root;
        for (Character ch : word.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                temp.children[ch - 'a'] = new TrieNode(ch);
            }
            temp = temp.children[ch - 'a'];
        }
        temp.isEnd = true;
        temp.word = word;
    }

    public boolean search(String word) {
        TrieNode temp = root;
        for (Character ch : word.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];

        }
        return temp != null && temp.isEnd;

    }

    public boolean startsWith(String prefix) {
        TrieNode temp = root;
        for (Character ch : prefix.toCharArray()) {
            if (temp.children[ch - 'a'] == null) {
                return false;
            }
            temp = temp.children[ch - 'a'];
        }
        return true;
    }
}
