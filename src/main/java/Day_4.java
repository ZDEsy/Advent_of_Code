import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class Day_4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input4.txt");
        List<String> strings = Files.readAllLines(path);
        for(String line : strings)
        {
            line = line.replaceAll("[^\\d.]", " ").trim();
            String[] lineArr = line.split(" ");
            System.out.println(Arrays.toString(lineArr));
            int[] winNums = new int[10];
            int[] heldNums = new int[25];
            int i = 1;
                for(int j = 0; j < winNums.length; j++)
                {
                    if (!Objects.equals(lineArr[i], "")) {
                        winNums[j] = Integer.parseInt(lineArr[i].trim());
                        i++;
                    }
                    else j--; i++;
                }
                for(int k = 0; k < heldNums.length; k++)
                {
                    if (!Objects.equals(lineArr[i], "")) {
                        winNums[k] = Integer.parseInt(lineArr[i].trim());
                        i++;
                    }
                    else k--; i++;
                }
            System.out.println(Arrays.toString(winNums));

        }

    }
}
