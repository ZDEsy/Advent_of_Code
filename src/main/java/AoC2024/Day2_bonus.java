package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2_bonus {
    public static void main(String[] args) throws FileNotFoundException {
        int sum = 0;

        Scanner sc = new Scanner(new File("AoC2024/input2.txt"));
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            int[] oneReport = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> onReportList = new ArrayList<>(Arrays.stream(oneReport).boxed().toList());
            ArrayList<Integer> tempList;

            if(isValid(onReportList)){
                sum++;
            }
            else {
                for(int i = 0; i < onReportList.size(); i++){
                    tempList = new ArrayList<>(onReportList);
                    tempList.remove(i);
                    if(isValid(tempList)){
                        sum++;
                        break;
                    }
                }
            }
        }
        System.out.println(sum);
    }

    public static boolean isIncreasing(ArrayList<Integer> list){
        return list.get(0) < list.get(1);
    }


    public static boolean isValid(ArrayList<Integer> list){
        boolean valid = true;
        if(isIncreasing(list)){
            for(int i = 0; i < list.size(); i++){
                if(i < list.size()-1){
                    int diff = list.get(i) - list.get(i+1);
                    if (!(-3 <= diff && diff <= -1)) {
                        valid = false;
                        break;
                    }
                }
            }
        }
        else {
            for(int i = 0; i < list.size(); i++){
                if(i < list.size()-1){
                    int diff = list.get(i) - list.get(i+1);
                    if (!(1 <= diff && diff <= 3)) {
                        valid = false;
                        break;
                    }
                }
            }
        }
        return valid;
    }
}