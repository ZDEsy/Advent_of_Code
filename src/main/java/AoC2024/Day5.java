package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day5 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input5.txt"));
        int hashIndex = 0;
        int sum = 0;
        HashMap<Integer, int[]> rules = new HashMap<>();
        ArrayList<ArrayList<Integer>> lines = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if (line.contains("|")){
                String[] rulesArray = line.split("\\|");
                rules.put(hashIndex, new int[]{Integer.parseInt(rulesArray[0]), Integer.parseInt(rulesArray[1])});
                hashIndex++;
            } else if (!line.isEmpty()) {
                int[] oneLineReportArray = Arrays.stream(line.split(",")).mapToInt(Integer::parseInt).toArray();
                ArrayList<Integer> oneLine = new ArrayList<>();
                for(int oneNumber : oneLineReportArray){
                    oneLine.add(oneNumber);
                }
                lines.add(oneLine);
            }
        }
        for(ArrayList<Integer> arrayList : lines){
            if(isValid(rules, arrayList)){
                sum += arrayList.get((int) Math.floor((double) arrayList.size() /2));
            }
        }
        sc.close();
        System.out.println(sum);
    }

    public static boolean isValid(HashMap<Integer, int[]> rules, ArrayList<Integer> line){
        for(int values : rules.keySet()){
            int[] numArray = rules.get(values);
            int numOne = numArray[0];
            int numTwo = numArray[1];
            System.out.println(numOne + " " + numTwo);
            for(int k = 0; k < line.size(); k++){
                if(line.contains(numOne) && line.contains(numTwo) && line.indexOf(numOne) > line.indexOf(numTwo)){
                    return false;
                }
            }
        }
        return true;
    }
}
