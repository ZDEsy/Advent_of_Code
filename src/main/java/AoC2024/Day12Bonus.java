package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day12Bonus {
    public static int area = 0;
    public static int perimeter = 0;
    public static int total = 0;
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input12Ex.txt"));

        ArrayList<ArrayList<Character>> board = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            ArrayList<Character> oneLine = new ArrayList<>();
            for(char ch : line.toCharArray()){
                oneLine.add(ch);
            }
            board.add(oneLine);
        }
        sc.close();

        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        String replaceChars = "abcdefghijklmnopqrstuvwxyz";

        int x = 0;
        int totalArea = 0;
        int totalPerimeter = 0;
        for(char ch : chars.toCharArray()){
            System.out.println(ch);
            for(int i = 0; i < board.size(); i++){
                for(int j = 0; j < board.get(i).size(); j++){
                    if(board.get(i).get(j) == ch){
                        countArea(board, ch, replaceChars.charAt(x), i, j);
                    }
                    if(perimeter != 0) System.out.println(perimeter);
                    if(area != 0) System.out.println(area);
                    total += area*perimeter;
                    area = 0;
                    perimeter = 0;
                }
            }
            x++;
        }

        for(ArrayList<Character> arrayList : board){
            System.out.println(arrayList);
        }
        System.out.println(totalArea);
        System.out.println(totalPerimeter);
        System.out.println(total);
    }

    public static void countArea(ArrayList<ArrayList<Character>> board, char ch, char replaceChar, int i, int j){
        area++;
        countPerimeter(board, ch, replaceChar, i, j);
        board.get(i).set(j, replaceChar);

        if(j != board.get(i).size()-1 && board.get(i).get(j+1) == ch){
            countArea(board, ch, replaceChar, i, j+1);
        }
        if(i != board.size()-1 && board.get(i+1).get(j) == ch){
            countArea(board, ch, replaceChar, i+1, j);
        }
        if(j != 0 && board.get(i).get(j-1) == ch){
            countArea(board, ch, replaceChar, i, j-1);
        }
        if(i != 0 && board.get(i-1).get(j) == ch){
            countArea(board, ch, replaceChar, i-1, j);
        }
    }

    public static void countPerimeter(ArrayList<ArrayList<Character>> board, char ch, char replaceChar, int i, int j){

        if((i == 0 && j == 0) || (i == 0 && j == board.get(i).size()-1) || (i == board.size()-1 && j == 0) || (i == board.size()-1 && j == board.get(i).size()-1)){
            perimeter++;
        }
        else {
            if(j != 0 && i != 0 && j != board.get(i).size()-1 && i != board.size()-1){
                if(checkCorner(board, i, j-1, ch, replaceChar, true) && checkCorner(board, i-1, j, ch, replaceChar, true) && checkCorner(board, i+1, j+1, ch, replaceChar, false)){
                    perimeter++;
                }
                if(checkCorner(board, i, j+1, ch, replaceChar, true) && checkCorner(board, i-1, j, ch, replaceChar, true) && checkCorner(board, i+1, j-1, ch, replaceChar, false)){
                    perimeter++;
                }
                if(checkCorner(board, i, j+1, ch, replaceChar, true) && checkCorner(board, i+1, j, ch, replaceChar, true) && checkCorner(board, i-1, j-1, ch, replaceChar, false)){
                    perimeter++;
                }
                if(checkCorner(board, i, j-1, ch, replaceChar, true) && checkCorner(board, i+1, j, ch, replaceChar, true) && checkCorner(board, i-1, j+1, ch, replaceChar, false)){
                    perimeter++;
                }
            }
        }

        if(i != 0 && j == board.get(i).size()-1 && checkCorner(board, i-1,j,ch,replaceChar, false)) perimeter++;
        if(i != board.size()-1 && j == board.get(i).size()-1 && checkCorner(board, i+1, j, ch, replaceChar, false)) perimeter++;
        if(i != board.size()-1 && j == 0 && checkCorner(board, i+1, j, ch, replaceChar, false)) perimeter++;
        if(i != 0 && j == 0 && checkCorner(board, i-1,j,ch,replaceChar, false)) perimeter++;

        if(j != 0 && i != 0 && checkCorner(board, i, j-1, ch, replaceChar, true) && checkCorner(board, i-1, j, ch, replaceChar, true) && checkCorner(board, i-1, j-1, ch, replaceChar, false)){
            perimeter++;
        }
        if(j != 0 && i != board.size()-1 && checkCorner(board, i, j-1, ch, replaceChar, true) && checkCorner(board, i+1, j, ch, replaceChar, true) && checkCorner(board, i+1, j-1, ch, replaceChar, false)){
            perimeter++;
        }
        if(j != board.get(i).size()-1 && i != 0 && checkCorner(board, i, j+1, ch, replaceChar, true) && checkCorner(board, i-1, j, ch, replaceChar, true) && checkCorner(board, i-1, j+1, ch, replaceChar, false)){
            perimeter++;
        }
        if(j != board.get(i).size()-1 && i != board.size()-1 && checkCorner(board, i, j+1, ch, replaceChar, true) && checkCorner(board, i+1, j, ch, replaceChar, true) && checkCorner(board, i+1, j+1, ch, replaceChar, false)){
            perimeter++;
        }
    }

    public static boolean checkCorner(ArrayList<ArrayList<Character>> board, int i, int j, char ch, char replaceChar, boolean isChar){
        if(isChar){
            return board.get(i).get(j) == ch || board.get(i).get(j) == replaceChar;
        }
        else return board.get(i).get(j) != ch && board.get(i).get(j) != replaceChar;
    }
}
