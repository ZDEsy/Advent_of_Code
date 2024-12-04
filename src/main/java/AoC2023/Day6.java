package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day6 {
    public static void main(String[] args) throws IOException {
        List<String> lines = Files.readAllLines(Path.of("input6.txt"));
        String[] time = lines.get(0).replaceAll("[^\\d.]+", " ").trim().split(" ");
        String[] distance = lines.get(1).replaceAll("[^\\d.]+", " ").trim().split(" ");

        long timeAll = Long.parseLong(time[0] + time[1] + time[2] + time[3]);
        long distanceAll = Long.parseLong(distance[0] + distance[1] + distance[2] + distance[3]);
        long allWays = 0;
        int totalWins = 0;
        int totalP = 1;
        for (int i = 0; i < time.length; i++) {
            for (int holdSpeed = 1; holdSpeed < Integer.parseInt(time[i])-1; holdSpeed++) {
                int result = (Integer.parseInt(time[i]) - holdSpeed) * holdSpeed;
                if (result > Integer.parseInt(distance[i])) totalWins++;
            }
            totalP *= totalWins;
            totalWins = 0;
        }
        System.out.println(totalP);
        for (long holdSpeed = 1; holdSpeed < timeAll; holdSpeed++)
        {
            long result = (timeAll - holdSpeed) * holdSpeed;
            if (result > distanceAll) allWays++;
        }
        System.out.println(allWays);
    }
}
