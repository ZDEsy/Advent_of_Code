package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input1.txt"));

        //PART 1
        ArrayList<Integer> firstColumn = new ArrayList<>();
        ArrayList<Integer> secondColumn = new ArrayList<>();
        int sum = 0;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] temporary = line.split(" {3}");
            firstColumn.add(Integer.parseInt(temporary[0]));
            secondColumn.add(Integer.parseInt(temporary[1]));
        }
        Collections.sort(firstColumn);
        Collections.sort(secondColumn);
        for(int i = 0; i < firstColumn.size(); i++){
            sum += Math.abs(firstColumn.get(i) - secondColumn.get(i));
        }

        //PART 2
        int sum2 = 0;
        for (int x : firstColumn) {
            int multiplier = 0;
            for (int j : secondColumn) {
                if (x == j) {
                    multiplier++;
                }
            }

            sum2 += x * multiplier;
        }
        sc.close();
        System.out.println(sum);
        System.out.println(sum2);
    }
}
