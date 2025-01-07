package org.example;

import org.example.pojo.Activity;

import java.io.*;

public class TextHandler {

    private final static String JOURNAL_PATH = "src/main/resources/journal.txt";

    public static void addActivity(Activity newActivity) throws IOException {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(JOURNAL_PATH))) {

            writer.write(newActivity.toString());

        } catch (FileNotFoundException ex) {

            handleFileNotFound(JOURNAL_PATH);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

    }

    public static String getActivities() throws IOException {

        StringBuilder activities = new StringBuilder();

        try (BufferedReader reader = new BufferedReader(new FileReader(JOURNAL_PATH))){

            String line;

            while ((line = reader.readLine()) != null) {
                activities.append(line);
            }

        } catch (FileNotFoundException ex) {

            handleFileNotFound(JOURNAL_PATH);

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return activities.toString();

    }

    private static void handleFileNotFound(String filePath) throws IOException {
        System.out.println("there is no such file yet, let's produce it !");
        File newFile = new File(filePath);
        boolean isFileMade = newFile.createNewFile();
        if (isFileMade) {
            System.out.println("the file has been made");
        }
    }

}
