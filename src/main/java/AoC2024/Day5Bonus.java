package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.*;

public class Day5Bonus {
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

        ArrayList<ArrayList<Integer>> modified = new ArrayList<>();
        for(ArrayList<Integer> arrayList : lines){
            modified.add(isValid(rules, arrayList));
        }

        for(ArrayList<Integer> arrayList : modified){
            sum += arrayList.get((int) Math.floor((double) arrayList.size() /2));
        }
        sc.close();
        System.out.println(sum);
    }

    public static ArrayList<Integer> isValid(HashMap<Integer, int[]> rules, ArrayList<Integer> line){
        boolean modified = false;
        for(int values = 0; values < rules.keySet().size(); values++){
            int[] numArray = rules.get(values);
            int numOne = numArray[0];
            int numTwo = numArray[1];
            for(int k = 0; k < line.size(); k++){
                if (line.contains(numOne) && line.contains(numTwo) && line.indexOf(numOne) > line.indexOf(numTwo)){
                    line.set(line.indexOf(numOne), numTwo);
                    line.set(line.indexOf(numTwo), numOne);
                    values = 0;
                    modified = true;
                }
            }
        }
        ArrayList<Integer> nullArray = new ArrayList<>();
        nullArray.add(0);
        return !modified ? nullArray : line;
    }
}
