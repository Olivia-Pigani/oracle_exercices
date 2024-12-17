package org.me.exo7;

public class MyRunnable implements Runnable{

    private int index;

    public MyRunnable(int index) {
        this.index = index;
    }

    @Override
    public void run() {

        if (index >= 5){
            System.out.println("terminado");
            System.exit(0);
        }

        System.out.println("hey");

    }
}
