import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day_2_bonus {
    public static String line;
    public static String[] cubes;
    public static Scanner sc;

    public static void main(String[] args){
        int powSum = 0;
        int pow;
        while(sc.hasNextLine())
        {
            NewLine();
            int betweenRed = 1;
            int betweenGreen = 1;
            int betweenBlue = 1;
            for(String cube : cubes)
            {
                boolean checkRed = cube.contains("red");
                boolean checkGreen = cube.contains("green");
                boolean checkBlue = cube.contains("blue");
                int valNum = Integer.parseInt(cube.replaceAll("[^\\d.]", ""));
                if(valNum > betweenRed && checkRed)
                {
                    betweenRed = valNum;
                }
                if (valNum > betweenGreen && checkGreen) {
                    betweenGreen = valNum;
                }
                if (valNum >betweenBlue && checkBlue)
                {
                    betweenBlue = valNum;
                }
            }
            pow = betweenRed * betweenBlue * betweenGreen;
            powSum += pow;

        }
        System.out.println(powSum);
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
