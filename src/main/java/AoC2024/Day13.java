package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Day13 {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input13.txt"));

        ArrayList<int[]> arrayList = new ArrayList<>();
        ArrayList<int[]> prizeList = new ArrayList<>();
        while(sc.hasNextLine())
        {
            String line = sc.nextLine();
            if(line.isEmpty()) continue;
            String[] temporary = line.split(",");
            if(temporary[0].contains("Prize")){
                prizeList.add(new int[]{Integer.parseInt(temporary[0].replaceAll("[^0-9]", "")),
                        Integer.parseInt(temporary[1].replaceAll("[^0-9]", ""))});
            }
            else {
                arrayList.add(new int[]{Integer.parseInt(temporary[0].replaceAll("[^0-9]", "")),
                        Integer.parseInt(temporary[1].replaceAll("[^0-9]", ""))});
            }
        }

        int totalPrizes = 0;
        int x = 0;
        for(int[] prizes : prizeList){
            int prizeX = prizes[0];
            int prizeY = prizes[1];
            for(int i = 0; i < 100; i++){
                for(int j = 0; j < 100; j++){
                    if(arrayList.get(x)[0]*i + arrayList.get(x+1)[0]*j == prizeX && arrayList.get(x)[1]*i + arrayList.get(x+1)[1]*j == prizeY){
                        totalPrizes += i*3;
                        totalPrizes += j;

                        System.out.println("x: " + i);
                        System.out.println("y: " + j);
                        System.out.println();
                    }
                }
            }
            x+=2;
        }
        sc.close();
        System.out.println(totalPrizes);
    }
}
