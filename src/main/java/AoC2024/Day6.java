package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Day6 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input6.txt"));

        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            char[] lineArray = line.toCharArray();
            ArrayList<Character> characterList = new ArrayList<>();
            for(char character : lineArray){
                characterList.add(character);
            }
            board.add(characterList);
        }
        sc.close();

        moveGuard(guardsPosition(board), board);

        int sum = 0;
        for(ArrayList<Character> line : board){
            for(char ch : line){
                if(ch == 'X'){
                    sum++;
                }
            }
        }

        System.out.println(sum+1);
    }

    public static int[] guardsPosition(ArrayList<ArrayList<Character>> board){
        for(ArrayList<Character> line : board){
            if(line.contains('^')){
                return new int[]{board.indexOf(line), line.indexOf('^')};
            }
        }
        return null;
    }

    public static void moveGuard(int[] guardsPosition, ArrayList<ArrayList<Character>> board){
        String facingDirection = "N";
        int[] internGuardsPosition = guardsPosition;
        while(true){
            try {
                switch (facingDirection){
                    case "N":
                        if(board.get(internGuardsPosition[0]-1).get(internGuardsPosition[1]) == '#'){
                            facingDirection = "E";
                        }
                        else {
                            board.get(internGuardsPosition[0]).set(internGuardsPosition[1], 'X');
                            internGuardsPosition = new int[]{internGuardsPosition[0]-1, internGuardsPosition[1]};
                        }
                        break;
                    case "E":
                        if(board.get(internGuardsPosition[0]).get(internGuardsPosition[1]+1) == '#'){
                            facingDirection = "S";
                        }
                        else {
                            board.get(internGuardsPosition[0]).set(internGuardsPosition[1], 'X');
                            internGuardsPosition = new int[]{internGuardsPosition[0], internGuardsPosition[1]+1};
                        }
                        break;
                    case "S":
                        if(board.get(internGuardsPosition[0]+1).get(internGuardsPosition[1]) == '#'){
                            facingDirection = "W";
                        }
                        else {
                            board.get(internGuardsPosition[0]).set(internGuardsPosition[1], 'X');
                            internGuardsPosition = new int[]{internGuardsPosition[0]+1, internGuardsPosition[1]};
                        }
                        break;
                    case "W":
                        if(board.get(internGuardsPosition[0]).get(internGuardsPosition[1]-1) == '#'){
                            facingDirection = "N";
                        }
                        else {
                            board.get(internGuardsPosition[0]).set(internGuardsPosition[1], 'X');
                            internGuardsPosition = new int[]{internGuardsPosition[0], internGuardsPosition[1]-1};
                        }
                        break;
                }
            }
            catch (Exception e){
                for(ArrayList<Character> line : board){
                    System.out.println(line);
                }
                break;
            }
        }
    }
}
