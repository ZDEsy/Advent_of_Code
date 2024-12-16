package AoC2024;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.HashMap;
class Day11Bonus {

    static final int STEP_COUNT = 75;

    public static void main(String[] args)
            throws FileNotFoundException
    {
        Scanner sc = new Scanner(new File("AoC2024/input11.txt"));
        ArrayList<Long> numbers = new ArrayList<>();
        String line = sc.nextLine();
        String[] temporary = line.split(" ");
        for (String string : temporary) {
            numbers.add(Long.parseLong(string));
        }

        HashMap<Long, Long> cache = new HashMap<>();
        for (Long n : numbers) {
            cache.merge(n, 1L, Long::sum);
        }

        for (int step = 1; step <= STEP_COUNT; ++step) {
            HashMap<Long,Long> next = new HashMap<>();
            for (long stone: cache.keySet()) {
                ArrayList<Long> new_stones = change(stone);
                for (long new_stone: new_stones) {
                    next.merge(new_stone, cache.getOrDefault(stone, 1L), Long::sum);
                }
            }
            cache = next;
        }
        long sum = 0;
        for (long v: cache.values()) sum += v;
        System.out.println(sum);
    }

    public static ArrayList<Long> change(Long n) {
        if (n == 0L) {
            return new ArrayList<>(List.of(1L));
        }

        double log = Math.ceil(Math.log10(n.doubleValue() + 1F));
        long length = (long) log;
        if (length % 2 == 0) {
            long pow = ((Double)Math.pow(10, (double) length / 2)).longValue();
            long n2 = n % pow;
            long n1 = (n - n2) / pow;
            return new ArrayList<>(List.of(n1, n2));
        }

        return new ArrayList<>(List.of(n * 2024));
    }
}