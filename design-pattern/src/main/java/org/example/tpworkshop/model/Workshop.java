package org.example.tpworkshop.model;

import org.example.tpworkshop.Observer;
import org.example.tpworkshop.model.impl.ToyFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Workshop {

    private static Workshop workshop;

    private Santa santa;

    private List<Observer> elfList = new ArrayList<>();

    private List<IToy> IToyList = new ArrayList<>();

   // private Map<String, ToyFactory> toyFactoryMap = new HashMap<>();

    private Workshop() {
    }

    public synchronized static Workshop getWorkshopInstance() {
        if (workshop == null) {
            workshop = new Workshop();
        }
        return workshop;
    }


    public void helloWorkshop() {
        System.out.println("workshop ready to work");
    }

    public Santa getSanta() {
        return santa;
    }

    public void setSanta(Santa santa) {
        this.santa = santa;
    }

    public List<Observer> getElfList() {
        return elfList;
    }

    public void addElfObserver(Observer elf) {
        elfList.add(elf);
    }

    public void removeElfObserver(Observer observer) {
        elfList.remove(observer);
    }

    public void notifyObserver(String message) {
        elfList.forEach(e -> e.toyMakingNotification(message));
    }

    public List<IToy> getToyList() {
        return IToyList;
    }

    public void setToyList(List<IToy> IToyList) {
        this.IToyList = IToyList;
    }

//    public void registerFactory(String factoryName){
//    ToyFactory factory = toyFactoryMap.get(factoryName);
//    }

}
