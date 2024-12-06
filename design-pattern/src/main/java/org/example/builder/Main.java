package org.example.builder;

public class Main {
    public static void main(String[] args) {

        House house1 = new House.HouseBuilder()
                .setName("PIRAINO")
                .setFloorNumber(5)
                .setGenre("traditionnal")
                .setHaveSwimmingPool(true)
                .setRoofType("ancant")
                .build();

        House house2 = new House.HouseBuilder()
                .setName("PIRAINO2")
                .setFloorNumber(5)
                .setGenre("traditionnal")
                .setHaveSwimmingPool(true)
                .setRoofType("ancant")
                .build();

        System.out.println(house1.toString());
        System.out.println(house2.toString());

    }
}
