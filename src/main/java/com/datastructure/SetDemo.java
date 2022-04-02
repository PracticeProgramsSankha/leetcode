package com.datastructure;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;


public class SetDemo {

    public static void main(String[] args) {
        demoHastSet();
        demoTreeSet();
        demoSortedTreeSet();
        // demoSortedHashsSet(); // Nothing as such
    }

    private static void demoSortedTreeSet() {
        SortedSet<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(50);
        treeSet.add(9);

        System.out.println("\nSortedtreeHashSet");
        System.out.println("=============");
        for(int n : treeSet) {
            System.out.print(n + " ");
        }
        System.out.println("\n=============");
    }

    private static void demoTreeSet() {
        Set<Integer> treeSet = new TreeSet<>();
        treeSet.add(10);
        treeSet.add(20);
        treeSet.add(11);
        treeSet.add(50);
        treeSet.add(9);

        System.out.println("\ntreeHashSet");
        System.out.println("=============");
        for(int n : treeSet) {
            System.out.print(n + " ");
        }
        System.out.println("\n=============");
    }

    private static void demoHastSet() {
        Set<Integer> hashSet = new HashSet<>();
        hashSet.add(10);
        hashSet.add(20);
        hashSet.add(11);
        hashSet.add(50);
        hashSet.add(9);

        System.out.println("\ndemoHashSet");
        System.out.println("=============");
        for(int n : hashSet) {
            System.out.println(n + " ");
        }
        System.out.print("\n=============");
    }
}
