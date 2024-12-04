package AoC2023;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day_3 {
    public static int i;
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input3.txt");
        List<String> lineMid = Files.readAllLines(path);
        String num = "";
        int sum = 0;
        boolean isValid = false;
        for(String line : lineMid)
        {
            int lineNum = lineMid.indexOf(line);
            String lineUp = line.replaceAll("[0123456789]",".");
            String lineDown = line.replaceAll("[0123456789]",".");
            if(lineNum != 0)
            {
                lineUp = lineMid.get(lineNum-1);
            }
            if(lineNum != 139)
            {
                lineDown = lineMid.get(lineNum+1);
            }
            for(i = 0; i < line.length(); i++)
            {
                if(Character.isDigit(line.charAt(i)))
                {
                    while(Character.isDigit(line.charAt(i)) && i < 139)
                    {
                        num += line.charAt(i);
                        if(i == 138 && Character.isDigit(line.charAt(i+1))) num += line.charAt(i+1);
                        if(i > 0)
                        {
                            if(isChar(lineUp, line, lineDown, i)) isValid = true;
                        }
                        i++;
                    }
                    if(isValid) sum += Integer.parseInt(num);
                    System.out.println(num);
                    System.out.println("Sum: " + sum);
                    num = "";
                    isValid = false;
                }
            }
        }
    }
    public static boolean isChar(String lineUp, String line, String lineDown, int i)
    {
        if(lineUp.charAt(i) != '.' && !Character.isDigit(lineUp.charAt(i))) return true;
        else if(lineUp.charAt(i-1) != '.' && !Character.isDigit(lineUp.charAt(i-1))) return true;
        else if(lineUp.charAt(i+1) != '.' && !Character.isDigit(lineUp.charAt(i+1))) return true;
        else if(lineDown.charAt(i) != '.' && !Character.isDigit(lineUp.charAt(i))) return true;
        else if(lineDown.charAt(i-1) != '.' && !Character.isDigit(lineDown.charAt(i-1))) return true;
        else if(lineDown.charAt(i+1) != '.' && !Character.isDigit(lineDown.charAt(i+1))) return true;
        else if(line.charAt(i-1) != '.' && !Character.isDigit(line.charAt(i-1))) return true;
        else return line.charAt(i + 1) != '.' && !Character.isDigit(line.charAt(i + 1));
    }
}
