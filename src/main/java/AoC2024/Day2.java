package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day2 {
    public static void main(String[] args) throws FileNotFoundException {
        int sum = 0;

        Scanner sc = new Scanner(new File("AoC2024/input2Ex.txt"));
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            int[] oneReport = Arrays.stream(line.split(" ")).mapToInt(Integer::parseInt).toArray();
            ArrayList<Integer> oneReportList = new ArrayList<>(Arrays.stream(oneReport).boxed().toList());

            boolean check1 = true;
            boolean check2 = true;

            for(int i = 0; i < oneReportList.size(); i++){
                if(i != oneReportList.size()-1){
                    if(!(oneReportList.get(i) > oneReportList.get(i+1)) || oneReportList.get(i) > oneReportList.get(i+1)+3){
                        check1 = false;
                        break;
                    }
                }
            }

            for(int i = 0; i < oneReportList.size(); i++){
                if(i != oneReportList.size()-1){
                    if(!(oneReportList.get(i) < oneReportList.get(i+1)) || oneReportList.get(i) < oneReportList.get(i+1)-3){
                        check2 = false;
                        break;
                    }
                }
            }
            if(check1 || check2) sum++;
        }
        System.out.println(sum);
    }
}
