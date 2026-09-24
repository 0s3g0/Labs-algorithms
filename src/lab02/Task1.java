package lab02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Task1 {

    static void main() throws IOException {

        //Task 01

        int k;
        while (true){
           IO.println("Write K which is an integer");
            String strK = IO.readln();
            try {
                k = Integer.parseInt(strK);
            } catch (NumberFormatException error){
               IO.println("Error, incorrect K");
                continue;
            }
            if (k > 0){
                break;
            }
           IO.println("Error, incorrect K");
        }

       IO.println("Write path to your file starting from src/lab02/<your file>");
        Path path = Paths.get(IO.readln()); //  src/lab02/b.txt
        if (!Files.exists(path) || Files.isDirectory(path)){
            Exit("Error, can't open file");
        } else if (Files.size(path) <= 0){
            Exit("Error, file is empty");
        }

        List<String> lines = Files.readAllLines(path);

        if (lines.size() < k) {
            Exit("Error: K is larger than the total number of lines in the file");
        }

        List<String> remainingLines = lines.subList(0, lines.size() - k);
        IO.println("Successfully deleted K lines");
        Files.write(path, remainingLines);

        //Task 02

        IO.println("Write a search word");
        String searchWord = IO.readln();
        int count = 0;

        for (String line : remainingLines){
            if (line.trim().isEmpty()){
                continue;
            }

            String[] words = line.split("[\\s\\p{Punct}]+");
            for (String word : words){
                if (word.equals(searchWord)){
                    count++;
                }
            }
        }

        if (count > 0) {
            IO.println("Your word was found: " + count + " times");
        } else {
            IO.println("Your word wasn't found in file.");
        }
    }


    public static void Exit(String reason){
       IO.println(reason);
        System.exit(0);
    }

}
