package org.example.server;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MyServer {

    private static int waitingTime = 2000;
    private static int threadCount = 1000;

    public static void main(String[] args) {

        //call all layers, because we don't use framework like Spring
        InMemoryDatabase db = new InMemoryDatabase();
        EmployeeService employeeService = new EmployeeService(db);
        EmployeeController employeeController = new EmployeeController(employeeService);

        try (ExecutorService executorService = Executors.newVirtualThreadPerTaskExecutor()) {

            for (int i = 0; i < threadCount; i++) {
                executorService.execute(work(employeeController));
            }


        } catch (OutOfMemoryError ex) {
            ex.printStackTrace();
        }


    }


    private static Runnable work(EmployeeController employeeController) {
        return (() -> {
            long startTime = System.currentTimeMillis();

            try {
                Thread.sleep(waitingTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(employeeController.getAllEmployees());

            long endTime = System.currentTimeMillis();
            System.out.println("has waited " + (endTime - startTime) + " ms");
        });
    }
}
