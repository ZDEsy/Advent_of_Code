import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Objects;
import java.util.Scanner;

public class Day_2{
    public static String line;
    public static String[] cubes;
    public static Scanner sc;



    public static void main(String[] args) throws FileNotFoundException {
        int gameNum = 1;
        int sum = 0;
        NewLine();

        for (int i = 0; i < cubes.length; i++) {
            if(sc.hasNextLine())
            {
                int valNum = Integer.parseInt(cubes[i].replaceAll("[^\\d.]", ""));
                if (valNum > 12 && cubes[i].contains("red") || valNum > 13 && cubes[i].contains("green") || valNum > 14 && cubes[i].contains("blue")) {
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
    }

    public static void NewLine()
    {
        line = sc.nextLine();
        line = line.replace(";",",");
        cubes = line.split(",");
    }

    static {
        try {
            sc = new Scanner(new File("games.txt"));
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
