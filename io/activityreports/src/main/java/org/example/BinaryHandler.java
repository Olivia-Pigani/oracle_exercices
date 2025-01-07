package org.example;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class BinaryHandler {

    private final static String JOURNAL_PATH = "src/main/resources/journal.txt";
    private final static String JOURNAL_BACKUP_PATH = "src/main/resources/journal_backup.dat";
    private final static String JOURNAL_SOURCE_BACKUP_PATH = "src/main/resources/source_journal_backup.dat";


    public static void makeBackups(String contentStr) throws IOException {

        byte[] binary = contentStr.getBytes(StandardCharsets.UTF_8);

        try (FileOutputStream out = new FileOutputStream(JOURNAL_SOURCE_BACKUP_PATH)) {

            out.write(binary);

        } catch (FileNotFoundException ex) {
            handleFileNotFound(JOURNAL_SOURCE_BACKUP_PATH);
        } catch (IOException ex) {
            ex.printStackTrace();
        }


        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(JOURNAL_SOURCE_BACKUP_PATH));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(JOURNAL_BACKUP_PATH))) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                out.write(buffer, 0, bytesRead);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
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
