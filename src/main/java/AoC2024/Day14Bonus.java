package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Array;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.*;

public class Day14Bonus {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(new File("AoC2024/input14.txt"));

        int[][] board = new int[103][101];

        ArrayList<int[]> positions = new ArrayList<>();
        ArrayList<int[]> velocities = new ArrayList<>();

        Path fileName = Path.of("\\Users\\zdene\\IdeaProjects\\Advent_of_Code\\src\\main\\java\\day14Bonus\\0.txt");
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] temporary = line.split(" ");
            String[] positionsString = temporary[0].split(",");
            String[] velocitiesString = temporary[1].split(",");

            positions.add(new int[]{Integer.parseInt(positionsString[1].replaceAll("[^0-9]", "")), Integer.parseInt(positionsString[0].replaceAll("[^\\d.-]", ""))});
            velocities.add(new int[]{Integer.parseInt(velocitiesString[1].replaceAll("[^\\d.-]", "")), Integer.parseInt(velocitiesString[0].replaceAll("[^\\d.-]", ""))});
        }

        fillBoard(board, positions);
        sc.close();


        for(int[] line : board){
            System.out.println(Arrays.toString(line));
        }

        int halfBoardLength = (int) (double) (board.length / 2);
        int halfOneLineLength = (int) (double) (board[0].length / 2);
        int z = 0;
        while(z < 10000){
            for(int j = 0; j < positions.size(); j++){
                positions.set(j, moveRobot(board, positions.get(j), velocities.get(j)));
            }
            z++;

            Files.writeString(fileName, "", StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING);
            for(int[] intArray : board){
                Files.writeString(fileName, Arrays.toString(intArray) + System.lineSeparator(), StandardOpenOption.APPEND);
            }

            fileName = Path.of("\\Users\\zdene\\IdeaProjects\\Advent_of_Code\\src\\main\\java\\day14Bonus\\" + z + ".txt");
        }

        for(int[] line : board){
            System.out.println(Arrays.toString(line));
        }

        int firstQuad = 0;
        int secondQuad = 0;
        int thirdQuad = 0;
        int fourthQuad = 0;

        for(int i = 0; i < board.length; i++){
            board[i][halfOneLineLength] = 0;
        }

        for(int j = 0; j < board[0].length; j++){
            board[halfBoardLength][j] = 0;
        }

        for(int[] line : board){
            System.out.println(Arrays.toString(line));
        }

        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){;
                if(board[i][j] != 0){
                    if(i <= halfBoardLength && j <= halfOneLineLength){
                        firstQuad+=board[i][j];
                    } else if (i <= halfBoardLength && j >= halfOneLineLength) {
                        secondQuad+=board[i][j];
                    }
                    else if(i >= halfBoardLength && j <= halfOneLineLength){
                        thirdQuad+=board[i][j];
                    }
                    else fourthQuad+=board[i][j];
                }
            }
        }

        System.out.println(firstQuad);
        System.out.println(secondQuad);
        System.out.println(thirdQuad);
        System.out.println(fourthQuad);
        int sum = firstQuad*secondQuad*thirdQuad*fourthQuad;
        System.out.println(z);
    }

    public static void fillBoard(int[][] board, ArrayList<int[]> positions){
        boolean found = false;
        for(int i = 0; i < board.length; i ++){
            for(int j = 0; j < board[i].length; j++){
                int[] position = new int[]{i,j};
                found = false;
                for(int[] intArray : positions){
                    if(intArray[0] == position[0] && intArray[1] == position[1]){
                        board[i][j] += 1;
                        found = true;
                    }
                }
                if(!found) board[i][j] = 0;
            }
        }
    }

    public static int[] moveRobot(int[][] board, int[] robotPosition, int[] velocity){
        int[] newPosition = new int[]{robotPosition[0]+velocity[0], robotPosition[1]+velocity[1]};
        if(board.length <= newPosition[0]) {
            System.out.println("here");
            newPosition[0] = newPosition[0]-board.length;
        }
        else if(newPosition[0] < 0) {
            System.out.println("second");
            newPosition[0] = board.length+newPosition[0];
        }
        if(board[0].length <= newPosition[1]) {
            System.out.println("third");
            newPosition[1] = newPosition[1]-board[0].length;
        }
        else if(newPosition[1] < 0) {
            System.out.println("forth");
            newPosition[1] = board[0].length+newPosition[1];
        }

        board[robotPosition[0]][robotPosition[1]]--;
        board[newPosition[0]][newPosition[1]]++;
        return newPosition;
    }
}
