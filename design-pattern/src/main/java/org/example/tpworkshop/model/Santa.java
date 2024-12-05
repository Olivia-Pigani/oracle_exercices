package org.example.tpworkshop.model;

public class Santa {

    private static Santa santa;

    private Santa(){}

    public synchronized static Santa getSantaInstance(){
        if (santa == null){
            santa = new Santa();
        }
        return santa;
    }

    public void helloSanta(){
        System.out.println("santa is here");
    }
}
