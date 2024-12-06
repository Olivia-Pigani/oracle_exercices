package org.example.tpworkshop;

import org.example.tpworkshop.model.*;
import org.example.tpworkshop.model.impl.FragileToyFactory;
import org.example.tpworkshop.model.impl.SolidToyFactory;
import org.example.tpworkshop.model.impl.ToyFactory;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Workshop workshop = Workshop.getWorkshopInstance();
        workshop.helloWorkshop();

        Santa santa = Santa.getSantaInstance();
        santa.helloSanta();

        Observer elf1 = new Elf("bob");
        Observer elf2 = new Elf("alice");

        workshop.setSanta(santa);
        workshop.addElfObserver(elf1);
        workshop.addElfObserver(elf2);

        ToyFactory fragileToyFactory = new FragileToyFactory();
        ToyFactory solidToyFactory = new SolidToyFactory();

        IToy fragileIToy1 = fragileToyFactory.makeToy();
        fragileIToy1.make();
        workshop.notifyObserver("toy has been made : " + fragileIToy1);

        IToy fragileIToy2 = fragileToyFactory.makeToy();
        fragileIToy2.make();
        workshop.notifyObserver("toy has been made : " + fragileIToy2);

        IToy solidIToy1 = solidToyFactory.makeToy();
        solidIToy1.make();
        workshop.notifyObserver("toy has been made : " + solidIToy1);

        workshop.setToyList(Arrays.asList(fragileIToy1, solidIToy1));

        //pimp a toy
        IToy pimpedToy = new PimpedDecorator(fragileIToy1);
        System.out.println(pimpedToy.getDescription());

    }
}
