package com.jkt.algo.graph;

import java.util.HashSet;
import java.util.Set;

public class BoggleGame {

    public static void main(final String args[]) {
        final char[][] boggle = { { 'G', 'I', 'Z' },
                                   {'U','E','K'},
                                   {'Q','S','E'}};


        final Set<String> dictionary = new HashSet<String>();
        dictionary.add("QUIZ");
        dictionary.add("GUEK");
        dictionary.add("GEEKS");
        final BoggleGame boggleGame = new BoggleGame();
        boggleGame.findWord(boggle, dictionary);
    }

    private void findWord(final char[][] boggle, final Set<String> dictionary) {

        for (int row = 0; row < boggle.length; row++) {
            for (int col = 0; col < boggle[0].length; col++) {
                final char prefix[] = new char[200];
                final boolean visited[][] = new boolean[boggle.length][boggle[0].length];
                prefix[0] = boggle[row][col];
                visited[row][col] = true;
                final int index = 0;
                final int length = 1;
                check(boggle, row, col, dictionary, prefix, visited, index, length);
                visited[row][col] = false;
            }
        }

    }

    private void check(final char[][] boggle, final int row, final int col, final Set<String> dictionary, final char prefix[], final boolean[][] visited,
            final int index, final int length) {

        // base check;
        String value = "";
        for (int i = 0; i < length; i++) {
            value = value + prefix[i];
        }
        // System.out.println(value);

        if (dictionary.contains(value)) {
            System.out.println(value);
        }
        final int rows[] = { -1, -1, -1, 0, 0, 1, 1, 1 };
        final int cols[] = { -1, 0, 1, -1, 1, -1, 0, 1 };

        for(int i=0; i< 8; i++) {
            final int newRow = row + rows[i];
            final int newCol = col + cols[i];
            if (allowed(boggle, newRow, newCol, visited)) {
                prefix[index + 1] = boggle[newRow][newCol];
                visited[newRow][newCol] = true;
                check(boggle, newRow, newCol, dictionary, prefix, visited, index + 1, length + 1);
                visited[newRow][newCol] = false;
            }

        }
     }

    private boolean allowed(final char[][] boggle, final int row, final int col, final boolean[][] visited) {
        if (((row >= 0) && (row < boggle.length)) && ((col >= 0) && (col < boggle[0].length))) {
            if (visited[row][col] == false) {
                return true;
            }
        }
        return false;
    }
}
