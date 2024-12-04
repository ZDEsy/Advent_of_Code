package AoC2023;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day1 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input1.txt"));
        int sum = 0;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            line = line.replaceAll("[^\\d.]", "");
            if(line.length() == 1)
            {
                line += line;
                sum += Integer.parseInt(line);
            } else if (line.length() > 2) {
                line = line.charAt(0) + line.substring(line.length() - 1);
                sum += Integer.parseInt(line);
            }
            else
            {
                sum += Integer.parseInt(line);
            }
        }
        sc.close();
        System.out.println(sum);
    }


}
