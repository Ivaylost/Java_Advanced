package Advance.Stream;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SumLines {
    public static void main(String[] args) {
        Path inPath = Paths.get("D:\\Advance.Stream\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt");
        try {
            BufferedReader reader = Files.newBufferedReader(inPath);

            String line;
            while ((line = reader.readLine()) != null) {
                int sum = 0;
                for (int i = 0; i < line.length(); i++) {
                    sum += line.charAt(i);
                }
                System.out.println(sum);
            }
        } catch (Exception e){
            System.out.println();
        }
    }
}
