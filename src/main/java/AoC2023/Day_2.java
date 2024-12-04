package AoC2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Day_2{
    public static String line;
    public static String[] cubes;
    public static Scanner sc;
    public static int gameNum = 1;

    public static void main(String[] args) throws FileNotFoundException {
        int sum = 0;
        NewLine();

        //going through and checking every element in cubes array
        for (int i = 0; i < cubes.length; i++) {
                //number in each element of the array
            int valNum = Integer.parseInt(cubes[i].replaceAll("[^\\d.]", ""));

            //condition for index 0, because it didn't register
            int zeroNum = Integer.parseInt(cubes[0].replaceAll("[^\\d.]", ""));
            if (zeroNum > 12 && cubes[0].contains("red") || zeroNum > 13 && cubes[0].contains("green") || zeroNum > 14 && cubes[0].contains("blue")) {
                NewLine();
                gameNum++;
                i = 0;
            }
            //condition to check each color and if it reaches last element it will add up to sum game number
            else if (valNum > 12 && cubes[i].contains("red") || valNum > 13 && cubes[i].contains("green") || valNum > 14 && cubes[i].contains("blue")) {
                NewLine();
                gameNum++;
                i = 0;
            } else if (i == cubes.length-1){
                sum += gameNum;
                gameNum++;
                System.out.println(Arrays.toString(cubes));
                System.out.println(sum);
                NewLine();
                i = 0;
            }

        }
    }

    //new line and splits it in array by each cubes
    public static void NewLine()
    {
            line = sc.nextLine();
            line = line.replace(";",",");
            line = line.substring(8);
            cubes = line.split(",");
    }
    static {
        try {
            sc = new Scanner(new File("input2.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
