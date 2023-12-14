import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;

public class Day_5 {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("input5.txt"));
        String[] seeds = strings.get(0).replaceAll("[^\\d.]+", " ").trim().split(" ");
        long[] longSeeds = new long[seeds.length];
        long diff;
        long num;
        for(int i = 0; i < seeds.length; i++)
        {
            longSeeds[i] = Long.parseLong(seeds[i]);
        }
        System.out.println(Arrays.toString(longSeeds));
        for (long source : longSeeds) {
            for (int j = 2; j < strings.size(); j++) {
                if (strings.get(j).isEmpty()) j++;
                if (Character.isDigit(strings.get(j).charAt(0))) {
                    String[] srcDest = strings.get(j).trim().split(" ");
                    diff = Long.parseLong(srcDest[1]) - Long.parseLong(srcDest[0]);
                    for (int k = 1; k < Integer.parseInt(srcDest[2]); k++) {
                        num = Long.parseLong(srcDest[1]) + k;
                        if (num == source) {
                            source = num;
                            break;
                        }
                    }
                }
            }
            System.out.println(source);
        }

    }
}
