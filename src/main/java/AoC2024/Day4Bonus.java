package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day4Bonus {

    public int wordExists(char[][] board) {
        int numOfWords = 0;

        for (int i = 1; i < board.length-1; i++) {
            for (int j = 1; j < board[i].length-1; j++) {
                if (board[i][j] == 'A') {
                    if (letterExists(board, i, j)) {
                        numOfWords++;
                    }
                }
            }
        }
        return numOfWords;
    }

    public boolean letterExists(char[][] board, int i, int j) {
        if(((board[i+1][j-1] == 'M' && board[i-1][j+1] == 'S') || (board[i+1][j-1] == 'S' && board[i-1][j+1] == 'M'))){
            return (board[i - 1][j - 1] == 'S' && board[i + 1][j + 1] == 'M') || (board[i - 1][j - 1] == 'M' && board[i + 1][j + 1] == 'S');
        }
        return false;
    }

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input4.txt"));
        int numOfLines = 0;
        String oneLine = "";
        while(sc.hasNextLine()){
            numOfLines++;
            oneLine = sc.nextLine();
        }

        char[][] board = new char[numOfLines][oneLine.length()];
        int i = 0;

        Scanner sc2 = new Scanner(new File("AoC2024/input4.txt"));
        while(sc2.hasNextLine())
        {
            String line = sc2.nextLine();
            char[] row = line.toCharArray();
            board[i] = row;
            i++;
        }

        Day4Bonus puzzle = new Day4Bonus();
        System.out.println(puzzle.wordExists(board));
    }
}
