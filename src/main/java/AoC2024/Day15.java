package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Day15 {
    public static int boxCount = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input15.txt"));

        ArrayList<char[]> boardList = new ArrayList<>();
        ArrayList<Character> movement = new ArrayList<>();
        char[][] board;
        int sum = 0;
        boolean startMovement = false;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if(!line.isEmpty() && !startMovement){
                char[] oneLineOfWareHouse = line.toCharArray();
                boardList.add(oneLineOfWareHouse);
                continue;
            }
            else startMovement = true;

            for(char ch : line.toCharArray()){
                movement.add(ch);
            }
        }
        board = new char[boardList.getFirst().length][boardList.size()];
        int i = 0;
        for(char[] charArray : boardList){
            board[i] = charArray;
            i++;
        }
        sc.close();

        for(char ch : movement){
            System.out.println(ch);
            drawBoard(board);
            System.out.println();
            int[] robotPosition = getRobotPosition(board);
            assert robotPosition != null;
            moveRobot(board, ch, robotPosition[0], robotPosition[1]);
            boxCount = 0;
        }


        System.out.println();
        drawBoard(board);
        System.out.println();
        System.out.println();
        System.out.println(countBoxes(board));
    }

    public static int countBoxes(char[][] board){
        int sum = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == 'O'){
                    sum += 100*i + j;
                }
            }
        }
        return sum;
    }

    public static void moveRobot(char[][] board, char moveDir, int posX, int posY){
        int upcomingI = posX;
        int upcomingJ = posY;
        switch (moveDir){
            case '<':
                upcomingJ = posY-1;
                break;
            case 'v':
                upcomingI = posX+1;
                break;
            case '^':
                upcomingI = posX-1;
                break;
            case '>':
                upcomingJ = posY+1;
                break;
        }

        checkUpcomingPos(board, moveDir, upcomingI, upcomingJ);
        int boxesToMove = boxCount;
        System.out.println("TO MOVE: " + boxesToMove);

        if(boxesToMove == 0){
            board[posX][posY] = '.';
            board[upcomingI][upcomingJ] = '@';
        }
        else if(boxesToMove > 0){
            board[posX][posY] = '.';
            board[upcomingI][upcomingJ] = '@';
            moveBoxes(board, moveDir, boxesToMove, upcomingI, upcomingJ);
        }
    }

    public static void moveBoxes(char[][] board, char dir, int boxesToMove, int initialI, int initialJ){
        for(int i = 1; i <= boxesToMove; i++){
            switch (dir){
                case '<':
                    board[initialI][initialJ-i] = 'O';
                    break;
                case 'v':
                    board[initialI+i][initialJ] = 'O';
                    break;
                case '^':
                    board[initialI-i][initialJ] = 'O';
                    break;
                case '>':
                    board[initialI][initialJ+i] = 'O';
                    break;
            }
        }
    }

    public static void checkUpcomingPos(char[][] board, char dir, int i, int j){
        System.out.println(board[i][j]);
        switch (board[i][j]){
            case '.':
                return;
            case '#':
                boxCount = -1;
                return;
            case 'O':
                boxCount++;
                int upcomingI = i;
                int upcomingJ = j;
                switch (dir){
                    case '<':
                        upcomingJ = j-1;
                        break;
                    case 'v':
                        upcomingI = i+1;
                        break;
                    case '^':
                        upcomingI = i-1;
                        break;
                    case '>':
                        upcomingJ = j+1;
                        break;
                }
                checkUpcomingPos(board, dir, upcomingI, upcomingJ);
                break;
        }
    }

    public static int[] getRobotPosition(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '@') return new int[]{i, j};
            }
        }
        return null;
    }

    public static void drawBoard(char[][] board){
        for (char[] chars : board) {
            System.out.println(Arrays.toString(chars));
        }
    }
}
