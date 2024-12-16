package org.me.exo3;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Callable<String> one = new CalculateurCallable(1);
        Callable<String> two = new CalculateurCallable(2);
        Callable<String> three = new CalculateurCallable(3);
        Callable<String> four = new CalculateurCallable(4);
        Callable<String> five = new CalculateurCallable(5);

        Future<String> result1 = executorService.submit(one);
        Future<String> result2 = executorService.submit(two);
        Future<String> result3 = executorService.submit(three);
        Future<String> result4 = executorService.submit(four);
        Future<String> result5 = executorService.submit(five);

        String resultOne = result1.get();
        String resultTwo = result2.get();
        String resultThree = result3.get();
        String resultFour = result4.get();
        String resultFive = result5.get();

        System.out.println(resultOne);
        System.out.println(resultTwo);
        System.out.println(resultThree);
        System.out.println(resultFour);
        System.out.println(resultFive);

        executorService.shutdown();

    }
}
