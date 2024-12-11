package AoC2024;



import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day10 {
    public static int sum = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input10.txt"));

        ArrayList<ArrayList<Integer>> board = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            ArrayList<Integer> oneLine = new ArrayList<>();
            for(char ch : line.toCharArray()){
                oneLine.add(ch - '0');
            }
            board.add(oneLine);
            System.out.println(oneLine);
        }

        ArrayList<int[]> zeroPositions = new ArrayList<>();
        for(int i = 0; i < board.size(); i++){
            for(int j = 0; j < board.get(i).size(); j++){
                if(board.get(i).get(j) == 0){
                    zeroPositions.add(new int[]{i, j});
                }
            }
        }
        for(int[] zeroPosition : zeroPositions){
            wayToGo(0, zeroPosition[1], zeroPosition[0], board);
            for (ArrayList<Integer> integers : board) {
                for (int j = 0; j < integers.size(); j++) {
                    if (integers.get(j) == -1) {
                        integers.set(j, 9);
                    }
                }
            }
        }

        System.out.println(sum);
    }

    public static void wayToGo(int number, int xPos, int yPos,ArrayList<ArrayList<Integer>> board){
        if(number == 9){
            sum++;
            board.get(yPos).set(xPos, -1);
        }
        else if(number == 10) return;

        ++number;
        if(xPos != 0 && board.get(yPos).get(xPos-1) == number){
            wayToGo(number, xPos-1, yPos, board);
        }
        if(xPos != board.get(yPos).size()-1 && board.get(yPos).get(xPos+1) == number){
            wayToGo(number, xPos+1, yPos, board);
        }
        if(yPos != board.size()-1 && board.get(yPos+1).get(xPos) == number){
            wayToGo(number, xPos, yPos+1, board);
        }
        if(yPos != 0 && board.get(yPos-1).get(xPos) == number){
            wayToGo(number, xPos, yPos-1, board);
        }
    }
}

