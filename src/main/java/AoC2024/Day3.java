package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Day3 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input3.txt"));

        int sum = 0;
        boolean doString = true;
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            Pattern pattern = Pattern.compile("mul\\(\\d+,\\d+\\)|do\\(\\)|don't\\(\\)");
            Matcher mulMatcher = pattern.matcher(line);
            ArrayList<String> mulArrayList = new ArrayList<>();

            while(mulMatcher.find()){
                System.out.println(mulMatcher.group() + " " + doString);
                if(mulMatcher.group().equals("do()")){
                    doString = true;
                }
                else if(mulMatcher.group().equals("don't()")){
                    doString = false;
                }
                else if(doString){
                    String b = mulMatcher.group();
                    System.out.println("ok");
                    mulArrayList.add(b);
                }
            }

            for(String mulString : mulArrayList){
                String[] splitString = mulString.split(",");
                int firstNum = Integer.parseInt(splitString[0].replaceAll("[^0-9]", ""));
                int secondNum = Integer.parseInt(splitString[1].replaceAll("[^0-9]", ""));
                sum += firstNum*secondNum;
            }
        }
        sc.close();
        System.out.println(sum);
    }
}
