package com.Zolando;

import java.util.HashSet;


/**
 * @author sanray on 3/19/2022
 */
public class Solution2 {
    public static void main(String[] args) {
        Solution2 sol = new Solution2();
        System.out.println(sol.solution(new String[] {
                "...Xv",
                "AX..^",
                ".XX.."
        }));

        System.out.println(sol.solution(new String[] {
                "X.....>",
                "..v..X.",
                ".>..X..",
                "A......"
        }));
    }

    final Character EMPTY = '.';
    final Character OBSTACLE = 'X';
    final Character GUARD_RIGHT = '>';
    final Character GUARD_LEFT = '<';
    final Character GUARD_UP = '^';
    final Character GUARD_DOWN = 'v';
    final Character ASSASSIN = 'A';

    HashSet<Integer> lookingDown = new HashSet<>(); // Columns
    HashSet<Integer> lookingUp = new HashSet<>(); // Columns
    HashSet<Integer> lookingLeft = new HashSet<>(); // Row
    HashSet<Integer> lookingRight = new HashSet<>(); // Row
    HashSet<int[]> obstacles = new HashSet<>(); // both

    public boolean solution(String[] B) {
        // write your code in Java SE 8
        int n = B.length;
        int m = B[0].length();
        Character[][] mat = new Character[n][m];
        int i = 0, j = 0;
        int[] assassin_pos = null;
        for (String row : B) {
            j = 0;
            for (Character c : row.toCharArray()) {
                mat[i][j] = c;
                if (c == GUARD_DOWN) {
                    lookingDown.add(j);
                } else if (c == GUARD_UP) {
                    lookingUp.add(j);
                } else if (c == GUARD_RIGHT) {
                    lookingRight.add(i);
                } else if (c == GUARD_LEFT) {
                    lookingLeft.add(i);
                } else if (c == OBSTACLE) {
                    obstacles.add(new int[] { i, j });
                } else if (c == ASSASSIN) {
                    assassin_pos = new int[] { i, j };
                }
                j++;
            }
            i++;
        }
        if (assassin_pos == null) {
            // No Assassin fond
            return false;
        }
        if (mat[n - 1][m - 1] != EMPTY) {
            // Last cell is not empty
            return false;
        }
        //printMat(mat);
        return backTrack(mat, assassin_pos);
    }

    public boolean backTrack(Character[][] mat, int[] assassin_pos) {

        if (assassin_pos[0] < 0 || assassin_pos[0] >= mat.length || assassin_pos[1] < 0
                || assassin_pos[1] >= mat[0].length) {
            return false;
        }
        // If left move possible
        int ass_x = assassin_pos[0];
        int ass_y = assassin_pos[1];
        if (ass_x == mat.length - 1 && ass_y == mat[0].length - 1) {
            // Reached
            return true;
        }

        char temp = mat[ass_x][ass_y];
        mat[ass_x][ass_y] = ' ';
        boolean leftMove = false;
        boolean rightMove = false;
        boolean upMove = false;
        boolean downMove = false;

        if (canMove(mat, assassin_pos, 0, -1)) { // Left
            leftMove = backTrack(mat, new int[] { assassin_pos[0], assassin_pos[1] - 1 });
        }
        if (canMove(mat, assassin_pos, 0, 1)) { // Right
            rightMove = backTrack(mat, new int[] { assassin_pos[0], assassin_pos[1] - 1 });
        }
        if (canMove(mat, assassin_pos, -1, 0)) { // Up
            upMove = backTrack(mat, new int[] { assassin_pos[0] - 1, assassin_pos[1] });
        }
        if (canMove(mat, assassin_pos, 1, 0)) { // Down
            downMove = backTrack(mat, new int[] { assassin_pos[0] + 1, assassin_pos[1] });
        }
        mat[ass_x][ass_y] = temp;

        return leftMove || rightMove || upMove || downMove;
    }

    public boolean canMove(final Character[][] mat, int[] pos, int x, int y) {

        int new_x = pos[0] + x;
        int new_y = pos[1] + y;
        if (new_x < 0 || new_x >= mat.length || new_y < 0 || new_y >= mat[0].length) {
            return false;
        }
        if (mat[pos[0]][pos[1]] != EMPTY) {
            return false;
        }
        if(mat[x][y] == ' ') {
            return false;
        }
        int curr_x = pos[0]; // row
        int curr_y = pos[1]; // column
        return !lookingLeft.contains(curr_x) && !lookingRight.contains(curr_x) && !lookingUp.contains(curr_y)
                && !lookingDown.contains(curr_y) && !obstacles.contains(pos);
    }

    private void printMat(Character[][] mat) {
        System.out.println("matrix===");
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[0].length; j++) {
                System.out.print(mat[i][j] + " ");
            }
            System.out.println();
        }
    }
}
