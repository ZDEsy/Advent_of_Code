import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Day_4 {
    public static void main(String[] args) throws IOException {
        Path path = Path.of("input4.txt");
        List<String> strings = Files.readAllLines(path);
    }
}
