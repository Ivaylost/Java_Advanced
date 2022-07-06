package Advance.Stream;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class AllCapitals {
    public static void main(String[] args) {
        String inPath = "D:\\Advance.Stream\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\input.txt";
        String outputPath = "D:\\Advance.Stream\\01._Sum Lines_Ресурси\\04. Java-Advanced-Files-and-Streams-Exercises-Resources\\output.txt";
        try {
            BufferedReader reader = new BufferedReader(new FileReader(inPath));
            PrintWriter writer = new PrintWriter(new FileWriter(outputPath));

            String line;
            while ((line = reader.readLine()) != null) {
                line = line.toUpperCase();
                writer.println(line);
            }
            writer.close();
        } catch (Exception e){
            System.out.println();
        }
    }
}
