import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.spec.RSAOtherPrimeInfo;
import java.util.List;
import java.util.Spliterator;
public class Honzovo_day2 {
    public static void main(String[] args) {
        int id = 1;
        int num = 0;
        int sum = 0;

        String[] split;
        try {
            List<String> allLines = Files.readAllLines(Paths.get("games.txt"));


            for (String line : allLines) {
                // spliting input file one value on each row
                split = line.split(" ");
                boolean possible = true;

                for (int i = 0; i < split.length; i++) {
                    // removing unnecessary string, which is game and game id
                    if (split[i].contains("Game")) {
                        i += 2;
                    }
                    try {
                        num = Integer.parseInt(split[i]);
                    } catch (NumberFormatException e) {
                        // 12 red cubes, 13 green cubes, and 14 blue

                        // checking if the game is possible
                        if (split[i].contains("red") && num > 12) {
                            possible = false;
                        }
                        else if (split[i].contains("green") && num > 13) {
                            possible = false;
                        }
                        else if (split[i].contains("blue") && num > 14) {
                            possible = false;
                        }
                    }
                }
                // adding up ids, when the game was possible
                if (possible) sum += id;
                id++;
                // System.out.println(line);
            }
            System.out.println("Sum: " + sum);
        } catch (IOException ignored) {

        }
    }
}
