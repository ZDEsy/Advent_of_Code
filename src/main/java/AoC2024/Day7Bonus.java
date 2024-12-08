package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Day7Bonus {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input7.txt"));
        long sum = 0;

        ArrayList<Long> results = new ArrayList<>();
        ArrayList<ArrayList<Long>> numbersToOperate = new ArrayList<>();

        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            String[] temporary = line.split(": | ");
            ArrayList<Long> temporaryList = new ArrayList<>();
            for(int i = 0; i < temporary.length; i++){
                if(i == 0) results.add(Long.parseLong(temporary[i]));
                else temporaryList.add(Long.parseLong(temporary[i]));
            }
            numbersToOperate.add(temporaryList);
        }

        char[] operators = new char[]{'+', '*', '|'};
        int k = 0;
        for(ArrayList<Long> list : numbersToOperate){
            ArrayList<String> combinationsOfOperators = new ArrayList<>();
            fillAllCombsOfOperands(operators, "", 3, list.size()-1, combinationsOfOperators);
            for(String oneComb : combinationsOfOperators){
                long tempSum = 0;
                ArrayList<Character> oneCombArrayList = new ArrayList<>();

                for(char ch : oneComb.toCharArray()){
                    oneCombArrayList.add(ch);
                }

                char ch = 'X';
                if(!oneCombArrayList.isEmpty()) ch = oneCombArrayList.get(0);


                System.out.println(list);
                for(int i = 0; i < list.size(); i++){
                    if(i == 0){
                        tempSum += list.get(i);
                    }
                    else if(ch == '+'){
                        tempSum += list.get(i);
                    }
                    else if(ch == '*'){
                        tempSum *= list.get(i);
                    }
                    else if(ch == '|'){
                        tempSum = Long.parseLong(tempSum + String.valueOf(list.get(i)));
                    }

                    System.out.println(tempSum);
                    if(i != oneCombArrayList.size() && !(i > oneCombArrayList.size()) && i != 0){
                        ch = oneCombArrayList.get(i);
                    }
                }
                if(tempSum == results.get(k)){
                    System.out.println(tempSum);
                    sum += tempSum;
                    break;
                }
            }
            k++;
        }
        sc.close();
        System.out.println("Final sum: " + sum);
    }

    public static void fillAllCombsOfOperands(char[] set, String prefix, int arrayLenght, int numOfChars, ArrayList<String> allCombs)
    {
        if (numOfChars == 0)
        {
            allCombs.add(prefix);
            return;
        }
        for (int i = 0; i < arrayLenght; ++i)
        {
            String newPrefix = prefix + set[i];
            fillAllCombsOfOperands(set, newPrefix,
                    arrayLenght, numOfChars - 1, allCombs);
        }
    }
}
