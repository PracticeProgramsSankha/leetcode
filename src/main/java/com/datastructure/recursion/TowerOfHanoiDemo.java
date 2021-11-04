package com.datastructure.recursion;

/**
 * @author sanray on 10/28/2021
 */
public class TowerOfHanoiDemo {

    public static void moveDisk(int numDisk, Character from, Character to, Character inter) {
        if (numDisk == 1) {
            System.out.println(String.format("Moving disk 1 from %c to %c", from, to));
        } else {
            moveDisk(numDisk - 1, from, inter, to);
            System.out.println(String.format("Moving disk %d from %c to %c", numDisk, from, to));
            moveDisk(numDisk - 1, inter, to, from);
        }
    }

    public static void main(String[] args) {
        moveDisk(4, 'A', 'B', 'C');
    }
}
