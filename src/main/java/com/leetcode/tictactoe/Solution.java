package com.leetcode.tictactoe;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Solution {

    public static List<String> winningMoves = Arrays.asList(
            // Column wise
            "00,01,02", "10,11,12", "20,21,22",
            // Row wise
            "00,10,20", "01,11,21", "02,12,22",
            // Diagonal
            "00,11,22", "02,11,20");

    public static String tictactoe(int[][] moves) {

        final List<String> moveStrings = Stream.of(moves).map(s -> String.format("%s%s",
                Integer.valueOf(s[0]), Integer.valueOf(s[1])))
                .collect(Collectors.toList());
        final Map<Boolean, List<String>> playerMoves = moveStrings.stream()
                .collect(Collectors.partitioningBy(s -> moveStrings.indexOf(s) % 2 == 0));

        boolean playerAWins = isWinningMove(true, playerMoves);
        boolean playerBWins = isWinningMove(false, playerMoves);

        if (moves.length == 9 && playerAWins == false && playerBWins == false) {
            return "Draw";
        }
        if (playerAWins) {
            return "A";
        } else if (playerBWins) {
            return "B";
        }

        return "Pending";
    }

    public static boolean isWinningMove(boolean playerIndex, Map<Boolean, List<String>> playerMovesMap) {
        final List<String> playerMoves = playerMovesMap.get(playerIndex);
        return playerMoves.size() >= 3 && winningMoves.stream()
                .anyMatch(winningMove ->
                        playerMoves.containsAll(Stream.of(winningMove.split(","))
                                .collect(Collectors.toList())));
    }

}
