package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Day4 {
    private int currentChar;
    private char[] word;

    public int wordExists(char[][] board, String word) {
        int numOfWords = 0;
        this.word = new char[word.length()];
        currentChar = 0;

        for (int a = 0; a < word.length(); a++) {
            word.getChars(0, word.length(), this.word, 0);
        }

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (this.word.length != 0 && board[i][j] == this.word[currentChar]) {
                    if (letterExists(board, i, j, this.word[++currentChar], "N")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "NE")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "E")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "SE")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "S")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "SW")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "W")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                    if (letterExists(board, i, j, this.word[++currentChar], "NW")) {
                        numOfWords++;
                    }
                    currentChar = 0;
                }
            }
        }
        return numOfWords;
    }

    public boolean letterExists(char[][] board, int i, int j, char letter, String direction) {
        currentChar++;

        if (i - 1 >= 0 && board[i - 1][j] == letter && direction.equals("N")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i - 1, j, word[currentChar], "N");
        } else if (i - 1 >= 0 && j + 1 < board[i].length && board[i - 1][j + 1] == letter && direction.equals("NE")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i - 1, j + 1, word[currentChar], "NE");
        } else if (j + 1 < board[i].length && board[i][j + 1] == letter && direction.equals("E")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i, j + 1, word[currentChar], "E");
        } else if (i + 1 < board.length && j + 1 < board[i + 1].length && board[i + 1][j + 1] == letter && direction.equals("SE")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i + 1, j + 1, word[currentChar], "SE");
        } else if (i + 1 < board.length && board[i + 1][j] == letter && direction.equals("S")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i + 1, j, word[currentChar], "S");
        } else if (i + 1 < board.length && j - 1 >= 0 && board[i + 1][j - 1] == letter && direction.equals("SW")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i + 1, j - 1, word[currentChar], "SW");
        } else if (j - 1 >= 0 && board[i][j - 1] == letter && direction.equals("W")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i, j - 1, word[currentChar], "W");
        } else if (j - 1 >= 0 && i - 1 >= 0 && board[i - 1][j - 1] == letter && direction.equals("NW")) {
            if (currentChar == word.length)
                return true;
            return letterExists(board, i - 1, j - 1, word[currentChar], "NW");
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

        Day4 puzzle = new Day4();
        System.out.println(puzzle.wordExists(board, "XMAS"));
    }
}
