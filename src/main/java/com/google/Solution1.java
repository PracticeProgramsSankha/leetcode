package com.google;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import org.apache.commons.lang3.StringUtils;
import com.datastructure.nodedemo.Node;


/**
 * @author sanray on 2/22/2022
 */

public class Solution1 {
    class Node {
        String data;
        int frequency;
        Node(String data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        
        List<String> words = Arrays.asList("apple pie",
                "apple tree",
                "orange tree",
                "I like apple pie",
                "apple store"
                );
        Solution1 sol1 = new Solution1();
        HashMap<String, PriorityQueue<Node>> map = sol1.createPredictor(words);
        predictNextWord("apple", map);

    }

    private static String predictNextWord(final String word, final HashMap<String, PriorityQueue<Node>> map) {
        if(!map.containsKey(word)) {
            return "";
        }
        return map.get(word).peek().data;
    }

    private HashMap<String, PriorityQueue<Node>> createPredictor(final List<String> words) {
        if(words == null || words.isEmpty()) {
            return null;
        }

        HashMap<String, PriorityQueue<Node>> map = new HashMap<>();
        for(String word : words) {
            String[] tokens = word.split(" ");
            for(int i = 0; i < tokens.length - 1; i++) {
                String s1 = tokens[i];
                String s2 = tokens[i+1];
                if(!map.containsKey(s1)) {
                    map.put(s1, new PriorityQueue<Node>((n1, n2) ->
                    {
                        if (n1.data.equals(n2.data)) {
                            n1.frequency++;
                            return 1;
                        }
                        return n1.frequency > n2.frequency ? 1 : 0;

                    }

                    ));
                }
                PriorityQueue<Node> nodes = map.get(s1);
                nodes.offer(new Node(s2));
            }
        }
        return map;
    }
}
