package com.leetcode.challenges;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Random;
import java.util.Set;


/**
 * @author sanray on 11/9/2021
 */
public class RandomPick {

    public static void main(String[] args) {
/*        {
            Solution solution = new Solution(0, new int[] {});
            System.out.println(solution.pick());
        }
        {
            Solution solution = new Solution(1, new int[] {});
            System.out.println(solution.pick());
        }*/
        {
            Solution solution = new Solution(7, new int[] { 2, 3, 5 });
            System.out.println(solution.pick());
            System.out.println(solution.pick());
            System.out.println(solution.pick());
            System.out.println(solution.pick());
            System.out.println(solution.pick());
            System.out.println(solution.pick());
            System.out.println(solution.pick());
            System.out.println(solution.pick());
        }

    }
}

class Solution {

    Set<Integer> setBlackList;
    Map<Integer, Integer> pickMap;
    Random randomizer;
    int n;

    LinkedList linkedList ;


    Solution(int n, int[] blacklist) {

        this.n = n;

        setBlackList = new HashSet<>();

        for (int i : blacklist) {
            setBlackList.add(i);
        }

        linkedList = new LinkedList();
        pickMap = new HashMap<>();
        randomizer = new Random();

        PriorityQueue<Integer> pQueue
                = new PriorityQueue<Integer>();
        pQueue.add(10);
        pQueue.add(10);
        pQueue.add(20);
        pQueue.add(10);
        pQueue.poll();


    }

    public int pick() {
        int item = randomizer.nextInt() % this.n;
        if(!pickMap.containsKey(item)) {
            pickMap.put(item, 1);
            return item;
        } else {
            do {
                item = randomizer.nextInt() % this.n;

            }
            while (true);
        }
        //while (pickMap.containsKey(item));
        //item = (int)linkedList.removeFirst();
        //linkedList.addLast(item);
        //return item;
    }
}
