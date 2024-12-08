package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day8 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input8.txt"));

        ArrayList<Character> chars = new ArrayList<>();
        ArrayList<int[]> positions = new ArrayList<>();
        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        int lineIndex = 0;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            char[] characters = line.toCharArray();
            ArrayList<Character> lineList = new ArrayList<>();
            for(char ch : characters){
                lineList.add(ch);
            }

            for(int i = 0; i < characters.length; i++){
                if(characters[i] != '.'){
                    chars.add(characters[i]);
                    positions.add(new int[]{lineIndex, i});
                }
            }

            board.add(lineList);
            lineIndex++;
        }

        ArrayList<int[]> correctPositions = new ArrayList<>();
        for(int i = 0; i < chars.size(); i++){
            for(int j = 0; j < chars.size(); j++){
                if(i != j && chars.get(i) == chars.get(j)  && chars.get(i) != '.' && chars.get(j) != '.'){
                    int[] distance = new int[]{positions.get(j)[0] - positions.get(i)[0], positions.get(j)[1] - positions.get(i)[1]};
                    int[] newPosition = new int[]{positions.get(j)[0] + distance[0], positions.get(j)[1] + distance[1]};
                    if(newPosition[0] >= 0 && newPosition[1] >= 0 && newPosition[0] < board.size() && newPosition[1] < board.get(newPosition[0]).size()){
                        if(board.get(newPosition[0]).get(newPosition[1]) == '.'){
                            board.get(newPosition[0]).set(newPosition[1], '#');
                            int[] correctPosition = new int[]{newPosition[0], newPosition[1]};
                            correctPositions.add(correctPosition);
                        }
                        else if(board.get(newPosition[0]).get(newPosition[1]) != '.' && board.get(newPosition[0]).get(newPosition[1]) != '#'){
                            int[] correctPosition = new int[]{newPosition[0], newPosition[1]};
                            correctPositions.add(correctPosition);
                        }
                    }
                }
            }
        }
        sc.close();

        for(int i = 0; i < correctPositions.size(); i++){
            for(int j = 0; j < correctPositions.size(); j++){
                if (i != j && correctPositions.get(i)[0] == correctPositions.get(j)[0] && correctPositions.get(i)[1] == correctPositions.get(j)[1]) {
                    correctPositions.remove(j);
                }
            }
        }

        System.out.println("Sum: " + correctPositions.size());
        System.out.println();
        for(ArrayList<Character> line : board){
            System.out.println(line);
        }
    }
}
