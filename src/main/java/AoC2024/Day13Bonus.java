package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Day13Bonus {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(new File("AoC2024/input13.txt"));

        ArrayList<long[]> arrayList = new ArrayList<>();
        ArrayList<long[]> prizeList = new ArrayList<>();
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            if (line.isEmpty()) continue;
            String[] temporary = line.split(",");
            if (temporary[0].contains("Prize")) {
                prizeList.add(new long[]{Long.parseLong(temporary[0].replaceAll("[^0-9]", ""))+10000000000000L,
                        Long.parseLong(temporary[1].replaceAll("[^0-9]", ""))+10000000000000L});
            } else {
                arrayList.add(new long[]{Long.parseLong(temporary[0].replaceAll("[^0-9]", "")),
                        Long.parseLong(temporary[1].replaceAll("[^0-9]", ""))});
            }
        }

        long totalPrizes = 0;
        int i = 0;
        for (long[] prizes : prizeList) {
            long prizeX = prizes[0];
            long prizeY = prizes[1];
            System.out.println("prizeX: " + prizeX);
            System.out.println("prizeY: " + prizeY);
            long l = prizeY * arrayList.get(i + 1)[0] - arrayList.get(i + 1)[1] * prizeX;
            long k = arrayList.get(i + 1)[0] * arrayList.get(i)[1] - arrayList.get(i + 1)[1] * arrayList.get(i)[0];
            if (k == 0) {
                i += 2;
                continue;
            }
            double x = (double) l / k;
            double y = (double) (prizeX - arrayList.get(i)[0] * (l / (double) k)) / arrayList.get(i + 1)[0];
            if (x >= 0 && x == (long) x && y >= 0 && y == (long) y) {
                totalPrizes += (long) (x * 3);
                totalPrizes += (long) y;
                System.out.println("X: " + x);
                System.out.println("Y: " + y);
                System.out.println();
            }
            i += 2;
        }

        sc.close();
        System.out.println("Total: " + totalPrizes);
    }
}
