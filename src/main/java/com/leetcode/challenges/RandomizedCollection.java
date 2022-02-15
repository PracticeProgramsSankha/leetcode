package com.leetcode.challenges;

import java.util.Comparator;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.Map;


/**
 * https://leetcode.com/problems/insert-delete-getrandom-o1-duplicates-allowed/submissions/
 *
 * @author sanray on 12/4/2021
 */
public class RandomizedCollection {
    public static void main(String[] args) {

        //test1();
        test2();
    }

    public static void test1() {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(1);
        rc.insert(1);
        rc.insert(1);
        rc.remove(1);
        System.out.println(rc.getRandom());
    }

    public static void test2() {
        RandomizedCollection rc = new RandomizedCollection();
        rc.insert(1);
        rc.insert(1);
        rc.insert(2);
        System.out.println(rc.getRandom());
        rc.remove(1);
        System.out.println(rc.getRandom());

    }

    public class DataHolder {
        int frequency;
        int randomCalled;


        DataHolder(int f) {
            frequency = f;
            randomCalled = 0;
        }

        public void increaseFreuency() {
            frequency++;
        }

        public int decreaseFreuency() {
            frequency--;
            return frequency;
        }

        public void increaseRandom() {
            randomCalled++;
        }
    }

    Map<Integer, DataHolder> map;

    RandomizedCollection() {
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            DataHolder data = map.get(val);
            data.increaseFreuency();
            return false;
        }
        //map.put(val, new DataHolder(1));
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            DataHolder data = map.get(val);
            if (data.decreaseFreuency() == 0) {
                map.remove(val);
            }
            return true;
        }
        return false;
    }

    public int getRandom() {
        int next = map.entrySet().stream()
                .sorted(Comparator.comparingInt(o -> o.getValue().randomCalled))
                .findFirst()
                .map(Map.Entry::getKey)
                .get();
        map.get(next).increaseRandom();
        return next;
    }
}
