import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Day_1_bonus {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("input.txt"));
        int sum = 0;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            line = line.replaceAll("one", String.valueOf(1));
            line = line.replaceAll("two", String.valueOf(2));
            line = line.replaceAll("three", String.valueOf(3));
            line = line.replaceAll("four", String.valueOf(4));
            line = line.replaceAll("five", String.valueOf(5));
            line = line.replaceAll("six", String.valueOf(6));
            line = line.replaceAll("seven", String.valueOf(7));
            line = line.replaceAll("eight", String.valueOf(8));
            line = line.replaceAll("nine", String.valueOf(9));
            line = line.replaceAll("[^\\d.]", "");
            System.out.println(line);

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
        System.out.println(sum);
    }
}
