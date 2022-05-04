package com.amazon;/*
in/p = Hello = true, hllo = false
dict[] = "hello", "world"

*/
//1 . 

import org.junit.Assert;


public class Solution1 {

    public static void main(String[] args) {

        Solution1 sol = new Solution1();
        Assert.assertEquals(true, sol.lookupWord("hello"));
        Assert.assertEquals(false, sol.lookupWord("hell"));

        System.out.println("All test passed!!");
    }

    Solution1() {
        String[] dict = {"hello", "world"};
        for(String word : dict) {
            insert(word);
        }
    }
     class TrieNode {
         char letter;
         TrieNode[] children;  // Assuming we only have a-z
         boolean isEnd;
         String finalWord;
         
         TrieNode() {
             letter = '/';
             isEnd = false;
             finalWord = "";
             children = new TrieNode[26];
         }

         public TrieNode(final Character ch) {
             this();
             this.letter = ch;
         }
     }
     
     TrieNode root = new TrieNode();

     public void insert(String word) {
         TrieNode temp = root;
         for (Character ch : word.toCharArray()) {
             if (temp.children[ch - 'a'] == null) {
                 temp.children[ch - 'a'] = new TrieNode(ch);
             }
             temp = temp.children[ch - 'a'];
         }
         temp.isEnd = true;
         temp.finalWord = word;
     }
     public boolean lookupWord(String searchWord) {
         TrieNode traverse = root;
         for (Character ch : searchWord.toCharArray()) {
             if(traverse.children[ch - 'a'] == null) {
                 return false;
             }
            traverse = traverse.children[ch - 'a'];
         }
         
         return traverse.isEnd && traverse.finalWord.equals(searchWord);
         
     }
}