import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;

public class Day_3 {
    public static int i = 0;
    public static int j = 0;
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input3.txt");
        List<String> lineMid = Files.readAllLines(path);
        String num = "";
        for(String line : lineMid)
        {
            int lineNum = lineMid.indexOf(line);
            String lineUp = "";
            String lineDown = "";
            if(lineNum != 0)
            {
                lineUp = lineMid.get(lineNum-1);
            }
            if(lineNum != 139)
            {
                lineDown = lineMid.get(lineNum+1);
            }
            System.out.println(lineUp);
            System.out.println(line);
            System.out.println(lineDown);
            if(line.charAt(i) >= '0' && line.charAt(i) <= '9')
            {
                num += line.charAt(i);
            }
            i++;
            num = "";
        }
    }
    public static boolean isChar(String lineUp, List<String> lineMid, String lineDown)
    {
        return lineUp.indexOf(i) != '.' || lineUp.indexOf(i-1) != '.' || lineUp.indexOf(i+1) != '.' || lineMid.indexOf(i-1) != '.' || lineMid.indexOf(i+1) != '.'
                || lineDown.indexOf(i) != '.' || lineDown.indexOf(i-1) != '.' || lineDown.indexOf(i+1) != '.' || isDigit(lineUp) || isDigit(lineDown);
    }

    public static boolean isDigit(String line)
    {
    return !Character.isDigit(line.charAt(i)) || !Character.isDigit(line.charAt(i+1)) || !Character.isDigit(line.charAt(i-1));
    }
}
