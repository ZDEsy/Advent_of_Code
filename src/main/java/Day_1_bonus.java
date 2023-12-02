<<<<<<< HEAD
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
            String leftNum = "";
            int index = 0;
            while (leftNum.isEmpty()) {
                String s = line.substring(0, index);
                leftNum = findNum(line.substring(0, index));
                index++;
            }
            String rightNum = "";
            index = 0;
            while (rightNum.isEmpty()) {
                rightNum = findNum(line.substring(line.length() - index));
                index++;
            }


            line = leftNum + rightNum;
            sum += Integer.parseInt(line);
        }
        sc.close();
        System.out.println(sum);
    }

    private static String findNum(String subString) {
        subString = subString.replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                .replaceAll("[^\\d.]", "");
        return subString;
    }

}
=======
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
            String leftNum = "";
            int index = 0;
            while (leftNum.isEmpty()) {
                String s = line.substring(0, index);
                leftNum = findNum(line.substring(0, index));
                index++;
            }
            String rightNum = "";
            index = 0;
            while (rightNum.isEmpty()) {
                rightNum = findNum(line.substring(line.length() - index));
                index++;
            }
            line = leftNum + rightNum;
            sum += Integer.parseInt(line);
        }
        sc.close();
        System.out.println(sum);
    }

    private static String findNum(String subString) {
        subString = subString.replace("one", "1")
                .replace("two", "2")
                .replace("three", "3")
                .replace("four", "4")
                .replace("five", "5")
                .replace("six", "6")
                .replace("seven", "7")
                .replace("eight", "8")
                .replace("nine", "9")
                .replaceAll("[^\\d.]", "");
        return subString;
    }

}
>>>>>>> 9ada07d4d48efa4bac069035fe20478cf2e51a9c
