package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input4.txt");
        List<String> strings = Files.readAllLines(path);
        int powTwo = 0;
        int sum = 0;
        for(String line : strings)
        {
            line = line.replaceAll("[^\\d.]+", " ").trim();
            String[] lineArr = line.split(" ");
            int[] winNums = new int[10];
            int[] heldNums = new int[25];
            int j = 0;
            int k = 0;
                for(int i = 1; i < 36; i++)
                {
                    if(i < 11)
                    {
                        winNums[j] = Integer.parseInt(lineArr[i]);
                        j++;
                    }
                    else
                    {
                        heldNums[k] = Integer.parseInt(lineArr[i]);
                        k++;
                    }
                }
            for(int num : winNums)
            {
                for(int heldNum : heldNums)
                {
                    if(num == heldNum && powTwo == 0) powTwo += 1;
                    else if(num == heldNum) powTwo *= 2;
                }
            }
            sum += powTwo;
            powTwo = 0;
        }
        System.out.println(sum);

    }
}
