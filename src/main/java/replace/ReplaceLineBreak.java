package replace;

import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ReplaceLineBreak {
    public static void main(String[] args) throws IOException {

        String fileString = new String(Files.readAllBytes(Paths.get("src/main/resources/file.txt")));
        System.out.println(fileString.replace("\n", ","));

        PrintWriter writer = new PrintWriter("src/main/resources/output.txt", "UTF-8");
        writer.append(fileString.replace("\n", ","));
        writer.close();


    }
}
