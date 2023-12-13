import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day_5 {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("input5.txt"));
        String[] seeds = strings.get(0).replaceAll("[^\\d.]+", " ").trim().split(" ");
        long[] intSeeds = new long[seeds.length];
        for(int i = 0; i < seeds.length; i++)
        {
            intSeeds[i] = Long.parseLong(seeds[i]);
        }
        System.out.println(Arrays.toString(intSeeds));
        for(int i = 0; i < intSeeds.length; i++)
        {
            for(int j = 1; j < strings.size(); j++)
            {
                if(strings.contains("123456789"))
                {
                    String[] srcDest = strings.get(j).trim().split(" ");
                    System.out.println(Arrays.toString(srcDest));
                }
            }
        }

    }
}
