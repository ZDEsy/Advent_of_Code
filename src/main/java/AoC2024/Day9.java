package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Day9 {
    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<String> lineArrayList = getStrings();

        int mod = 1;
        for(String s : lineArrayList){
            if(s.equals(".")){
                lineArrayList.set(lineArrayList.indexOf(s), lineArrayList.get(lineArrayList.size()-mod));
                mod++;
            }
        }
        System.out.println(lineArrayList);
        while (mod > 1){
            lineArrayList.remove(lineArrayList.size()-1);
            mod--;
        }

        long sum = 0;
        ArrayList<Integer> integerArrayList = stringToIntList(lineArrayList);
        for(int i = 0; i < integerArrayList.size(); i++){
            sum += (long) i *integerArrayList.get(i);
        }
        System.out.println(lineArrayList);
        System.out.println(sum);
    }

    private static ArrayList<String> getStrings() throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input9.txt"));
        String originalLine = sc.nextLine();
        char[] originalLineArray = originalLine.toCharArray();
        ArrayList<String> lineArrayList = new ArrayList<>();

        int id = 0;
        for(int i = 0; i < originalLineArray.length; i++){
            int count = Integer.parseInt(String.valueOf(originalLineArray[i]));
            String string;
            if(i % 2 == 0){
                string = String.valueOf(id++);
            }
            else {
                string = ".";
            }
            for(int x = 0; x < count; x++){
                lineArrayList.add(string);
            }
        }
        return lineArrayList;
    }

    public static ArrayList<Integer> stringToIntList(ArrayList<String> stringArrayList){
        ArrayList<Integer> integerArrayList = new ArrayList<>();
        for(String s : stringArrayList){
            integerArrayList.add(Integer.parseInt(s));
        }
        return integerArrayList;
    }
}
