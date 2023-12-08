import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

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
            String lineUp = line;
            String lineDown = line;
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
                    while(Character.isDigit(line.charAt(i)))
                    {
                        num += line.charAt(i);
                        if(i != 0 && i != 140)
                        {
                            if(isChar(lineUp, line, lineDown, i)) isValid = true;
                        }
                        i++;
                    }
                    if(isValid) sum += Integer.parseInt(num);
                    System.out.println(sum);
                    num = "";
                }
            }
        }
    }
    public static boolean isChar(String lineUp, String line, String lineDown, int i)
    {
        lineUp = lineUp.replace("0123456789", ".");
        lineDown = lineDown.replace("0123456789", ".");
        return lineUp.indexOf(i) != '.' || lineUp.indexOf(i-1) != '.' || lineUp.indexOf(i+1) != '.' ||
                lineDown.indexOf(i) != '.' || lineDown.indexOf(i-1) != '.' || lineDown.indexOf(i+1) != '.' || (line.indexOf(i-1) != '.' &&
                !Character.isDigit(line.charAt(i-1))) || (line.indexOf(i+1) != '.' && !Character.isDigit(line.charAt(i+1)));
    }

    public static boolean isDigit(String line)
    {
        return !Character.isDigit(line.charAt(i+1)) && !Character.isDigit(line.charAt(i-1));
    }
}
