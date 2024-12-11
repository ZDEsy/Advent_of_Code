package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day11 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input11.txt"));

        ArrayList<Long> numbers = new ArrayList<>();
        int sum = 0;
        String line = sc.nextLine();
        String[] temporary = line.split(" ");
        for(String string : temporary){
            numbers.add(Long.parseLong(string));
        }

        for(int i = 0; i < 25; i++){
            System.out.println(numbers);
            for(int j = 0; j < numbers.size(); j++){
                if(numbers.get(j) == 0){
                    numbers.set(j, 1L);
                }
                else if(String.valueOf(numbers.get(j)).length() % 2 == 0){
                    int splitIndex = String.valueOf(numbers.get(j)).length()/2;
                    String[] splitted = new String[]{String.valueOf(numbers.get(j)).substring(0, splitIndex), String.valueOf(numbers.get(j)).substring(splitIndex)};
                    numbers.set(j, Long.parseLong(splitted[0]));
                    numbers.add(j+1, Long.parseLong(splitted[1]));
                    j++;
                }
                else {
                    numbers.set(j, numbers.get(j)*2024);
                }
            }
        }
        sc.close();

        System.out.println(numbers.size());
    }
}
