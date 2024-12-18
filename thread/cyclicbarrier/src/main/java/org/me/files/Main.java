package org.me.files;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {

        List<String> pathList = Arrays.asList(
                "src/main/resources/one.txt",
                "src/main/resources/three.txt",
                "src/main/resources/two.txt"
        );

        fusion(pathList);
    }

    private static void fusion(List<String> pathList) {

        StringBuilder finalText = new StringBuilder();

        CyclicBarrier barrier = new CyclicBarrier(pathList.size(), () -> {
            System.out.println("Fusion des données terminée. Tous les threads peuvent continuer, le texte final est " + finalText);
        });

        ExecutorService executorService = Executors.newFixedThreadPool(pathList.size());

        for (int i = 0; i < pathList.size(); i++) {
            String filePath = pathList.get(i);
            executorService.submit(() -> {
                try {
                    System.out.println(Thread.currentThread().getName() + " commence à charger les données.");

                    fillFinalText(finalText, filePath);

                    barrier.await();
                    System.out.println(Thread.currentThread().getName() + " a terminé le chargement des données.");
                } catch (BrokenBarrierException | InterruptedException e) {
                    throw new RuntimeException(e);
                }
            });
        }

        executorService.shutdown();
    }

    private static void fillFinalText(StringBuilder finalText, String filePath) {

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath))) {

            List<String> allTextLine = bufferedReader.lines().toList();
            StringBuilder currentText = new StringBuilder();
            currentText.append(allTextLine).append(" ");

            // finalText.get().append(currentText);

            synchronized (finalText) {
                finalText.append(currentText);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
