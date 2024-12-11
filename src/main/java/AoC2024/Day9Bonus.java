package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9Bonus {
    public static void main(String[] args) throws FileNotFoundException {
        // Read input file
        Scanner sc = new Scanner(new File("AoC2024/input9.txt"));
        String originalLine = sc.nextLine();
        char[] originalLineArray = originalLine.toCharArray();
        ArrayList<String> lineArrayList = new ArrayList<>();

        int id = 0;
        for (int i = 0; i < originalLineArray.length; i++) {
            int count = Integer.parseInt(String.valueOf(originalLineArray[i]));
            String value = (i % 2 == 0) ? String.valueOf(id++) : ".";
            for (int x = 0; x < count; x++) {
                lineArrayList.add(value);
            }
        }

        id--;
        System.out.println("line " + lineArrayList);

        int timesNumber = 0;
        int timesDot = 0;
        int dotIndex = 0;
        for (int i = lineArrayList.size()-1; i >= 0; i--) {
            if(lineArrayList.get(i).equals(".") || Integer.parseInt(lineArrayList.get(i)) > id) continue;
            if (lineArrayList.get(i).equals(String.valueOf(id))) {
                timesNumber++;
                if(i != 0 && lineArrayList.get(i-1).equals(String.valueOf(id))){
                    continue;
                }
            }

            for (int j = 0; j < i; j++) {
                if(!lineArrayList.get(j).equals(".")) continue;
                if(dotIndex == 0) dotIndex = j;
                timesDot++;
                if(j != lineArrayList.size()-1 && lineArrayList.get(j+1).equals(".")){
                    continue;
                }

                if (timesDot >= timesNumber) {
                    for (int x = 0; x < timesNumber; x++) {
                        lineArrayList.set(dotIndex+x, String.valueOf(id));
                    }
                    for (int y = 0; y < timesNumber; y++) {
                        lineArrayList.set(i + y, ".");
                    }
                    timesDot = 0;
                    dotIndex = 0;
                    break;
                }
                timesDot = 0;
                dotIndex = 0;
            }
            id--;
            System.out.println(id);
            timesNumber = 0;
        }

        long checksum = 0;
        for (int i = 0; i < lineArrayList.size(); i++) {
            if (!lineArrayList.get(i).equals(".")) {
                checksum += (long) i * Integer.parseInt(lineArrayList.get(i));
            }
        }

        System.out.println("Final Line: " + lineArrayList);
        System.out.println("Checksum: " + checksum);
    }
}
