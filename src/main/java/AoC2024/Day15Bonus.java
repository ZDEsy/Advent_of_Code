package AoC2024;

import org.checkerframework.checker.units.qual.A;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Day15Bonus {
    public static boolean isValid = true;
    public static ArrayList<int[]> positions = new ArrayList<>();
    public static void main(String[] args) throws FileNotFoundException, InterruptedException {
        Scanner sc = new Scanner(new File("AoC2024/input15.txt"));
        char[][] board;

        ArrayList<ArrayList<char[]>> boardList = new ArrayList<>();
        ArrayList<Character> movement = new ArrayList<>();
        boolean startMovement = false;


        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if(!line.isEmpty() && !startMovement){
                char[] oneLineOfWareHouse = line.toCharArray();
                ArrayList<char[]> tempList = new ArrayList<>();
                for(char ch : oneLineOfWareHouse){
                    switch (ch){
                        case '#':
                            tempList.add(new char[]{'#', '#'});
                            break;
                        case '.':
                            tempList.add(new char[]{'.', '.'});
                            break;
                        case 'O':
                            tempList.add(new char[]{'[', ']'});
                            break;
                        case '@':
                            tempList.add(new char[]{'@', '.'});
                            break;
                    }
                }
                boardList.add(tempList);
                continue;
            }
            else startMovement = true;

            for(char ch : line.toCharArray()){
                movement.add(ch);
            }
        }
        board = new char[boardList.size()][boardList.getFirst().size()*2];
        int i = 0;
        int j = 0;
        for(ArrayList<char[]> charList : boardList){
            for(char[] charArray : charList){
                for(char ch : charArray){
                    board[i][j] = ch;
                    j++;
                }
            }
            j = 0;
            i++;
        }
        sc.close();

        Visualizer visualizer = new Visualizer(board, 17);
        int x = 0;
        for(char ch : movement){
            int[] robotPosition = getRobotPosition(board);
            assert robotPosition != null;
            moveRobot(board, ch, robotPosition[0], robotPosition[1]);
            visualizer.updateBoard(board);
            if(x % 10 == 0){
                drawBoard(board);
                Thread.sleep(1);
            }
            x++;
        }

        drawBoard(board);
        //System.out.println(countBoxes(board));
    }

    public static int countBoxes(char[][] board){
        int sum = 0;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == '['){
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

        if(isValid){
            board[posX][posY] = '.';
            moveBoxes(board, moveDir);
            board[upcomingI][upcomingJ] = '@';
        }
        positions.clear();
        isValid = true;
    }

    public static void moveBoxes(char[][] board, char dir){
        if(dir == '^'){
            positions.sort(Comparator.comparingInt(o -> o[0]));
        }
        else positions.sort((o1, o2) -> Integer.compare(o2[0], o1[0]));
        for(int[] position : positions){
            moveBox(board, position[0], position[1], dir);
        }
    }

    public static void moveBox(char[][] board, int i, int j, int dir){
        switch (dir){
            case '^':
                board[i-1][j] = '[';
                board[i-1][j+1] = ']';
                board[i][j] = '.';
                board[i][j+1] = '.';
                break;
            case '<':
                board[i][j-1] = '[';
                board[i][j] = ']';
                break;
            case '>':
                board[i][j+2] = ']';
                board[i][j+1] = '[';
                break;
            case 'v':
                board[i+1][j] = '[';
                board[i+1][j+1] = ']';
                board[i][j] = '.';
                board[i][j+1] = '.';
                break;
        }
    }

    public static void checkUpcomingPos(char[][] board, char dir, int i, int j){
        char boardChar = board[i][j];
        if(boardChar == '#'){
            isValid = false;
        }
        else if(boardChar == '[' || boardChar == ']'){
            if(boardChar == '[') {
                positions.add(new int[]{i, j});
            }
            else positions.add(new int[]{i, j-1});
            int upcomingI = i;
            int upcomingJ = j;
            switch (dir){
                case '<':
                    upcomingJ = j-1;
                    break;
                case 'v':
                    upcomingI = i+1;
                    checkUpcomingPos(board, dir, upcomingI, boardChar == '[' ? j+1 : j-1);
                    break;
                case '^':
                    upcomingI = i-1;
                    checkUpcomingPos(board, dir, upcomingI, boardChar == '[' ? j+1 : j-1);
                    break;
                case '>':
                    upcomingJ = j+1;
                    break;
            }
            checkUpcomingPos(board, dir, upcomingI, upcomingJ);
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

    public static void drawBoard(char[][] board) {
        for (char[] chars : board) {
            for (char ch : chars) {
                System.out.print(ch);
            }
            System.out.println();
        }
    }
}

class Visualizer extends JPanel{
    private char[][] board;
    private int cellSize;

    public Visualizer(char[][] board, int cellSize) {
        this.board = board;
        this.cellSize = cellSize;
        JFrame frame = new JFrame("Robot Board Visualizer");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setSize(board[0].length * cellSize, (board.length+3) * cellSize - cellSize/2 - 5);
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
    }

    public void updateBoard(char[][] newBoard) {
        this.board = newBoard;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char ch = board[i][j];
                if (ch == '#') {
                    g.setColor(Color.BLACK);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (ch == '.') {
                    g.setColor(Color.WHITE);
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                } else if (ch == '[') {
                    g.setColor(Color.ORANGE);
                    g.fillRect(j * cellSize, i * cellSize, cellSize * 2, cellSize);
                } else if (ch == '@') {
                    g.setColor(Color.RED); // Robot
                    g.fillRect(j * cellSize, i * cellSize, cellSize, cellSize);
                }
                g.setColor(Color.GRAY);
                if(ch == '[') g.drawRect(j * cellSize, i * cellSize, cellSize*2, cellSize);
                else if(ch != ']') g.drawRect(j * cellSize, i * cellSize, cellSize, cellSize);
            }
        }
    }
}
