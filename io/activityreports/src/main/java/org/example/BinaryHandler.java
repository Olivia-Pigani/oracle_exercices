package org.example;

import java.io.*;

public class BinaryHandler {

    private final static String JOURNAL_PATH = "src/main/resources/journal.txt";
    private final static String BINARY_PATH = "src/main/resources/journal_backup.dat";

    public static void makeBackup() {
        try (BufferedReader br = new BufferedReader(new FileReader(JOURNAL_PATH));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(BINARY_PATH))) {

            String line;
            while ((line = br.readLine()) != null){
                out.write(line.getBytes());
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void readBackup(){
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(BINARY_PATH))){
            int b;
            while((b = in.read()) != -1){
                System.out.print((char)b);
            }
        }catch (IOException ex) {
            ex.printStackTrace();
        }
    }


}
