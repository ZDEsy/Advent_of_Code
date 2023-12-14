import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Logger;

public class Day_5 {
    public static void main(String[] args) throws IOException {
        List<String> strings = Files.readAllLines(Path.of("input5.txt"));
        String[] seeds = strings.get(0).replaceAll("[^\\d.]+", " ").trim().split(" ");
        long[] longSeeds = new long[seeds.length];
        long source;
        long finalSource = 999999999;
        for(int i = 0; i < seeds.length; i++)
        {
            longSeeds[i] = Long.parseLong(seeds[i]);
        }
        System.out.println(Arrays.toString(longSeeds));
        for (long seed : longSeeds) {
            source = seed;
            long plusNum;
            long tempSource;
            long tempDest;
            int i = 3;
            while(i < 190)
            {
                if(strings.get(i).isEmpty()) i += 2;
                String[] line = strings.get(i).split(" ");
                plusNum = Long.parseLong(line[2]);
                tempSource = Long.parseLong(line[1]);
                tempDest = Long.parseLong(line[0]);
                for(int x = 0; x < plusNum; x++)
                {
                    if(source == tempSource)
                    {
                        source = tempDest;
                        if(i < 188){
                            while(!strings.get(i+1).isEmpty() && i < 188) i++;
                        }
                        break;
                    }
                    tempSource += 1;
                    tempDest += 1;
                }
                i++;
            }
            System.out.println("Final of seed: " + source);
            if(finalSource > source)
            {
                finalSource = source;
                System.out.println("Found lower: " + source);
            }
        }
    }
}
