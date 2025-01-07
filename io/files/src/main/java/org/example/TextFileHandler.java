package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class TextFileHandler {

    // Read
    public List<String> textReader() {
        System.out.println("Let's read the text file");
        String filePath = "src/main/resources/myText.txt";
        List<String> stringList = new ArrayList<>();

        // Read file
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int javaCount = 0;

            System.out.println("The text file contains:");
            while ((line = reader.readLine()) != null) {
                line = line.toLowerCase();
                System.out.println(line);
                stringList.add(line);

                if (line.contains("java")) {
                    javaCount++;
                }
            }

            System.out.println("There are " + javaCount + " lines that contain the word 'java'.");

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return stringList;
    }

    public void textWriter(List<String> stringList) {
        String filePath = "src/main/resources/result.txt";

        // Write file
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (String str : stringList) {
                writer.write(str);
                writer.newLine();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
