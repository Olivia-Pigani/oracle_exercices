package org.example.builder;

public class House {

    private static int idIncrementor = 0;

    private int id;

    private String name;

    private int floorNumber;

    private String genre;

    private boolean isHaveSwimmingPool;

    private String roofType;

    private House(HouseBuilder houseBuilder) {
        this.id = ++idIncrementor;
        this.name = houseBuilder.name;
        this.floorNumber = houseBuilder.floorNumber;
        this.genre = houseBuilder.genre;
        this.isHaveSwimmingPool = houseBuilder.isHaveSwimmingPool;
        this.roofType = houseBuilder.roofType;
    }

    @Override
    public String toString() {
        return "House{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", floorNumber=" + floorNumber +
                ", genre='" + genre + '\'' +
                ", isHaveSwimmingPool=" + isHaveSwimmingPool +
                ", roofType='" + roofType + '\'' +
                '}';
    }

    public static class HouseBuilder{

        private String name;
        private int floorNumber;
        private String genre;
        private boolean isHaveSwimmingPool;
        private String roofType;


        public HouseBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public HouseBuilder setFloorNumber(int floorNumber) {
            this.floorNumber = floorNumber;
            return this;
        }

        public HouseBuilder setGenre(String genre) {
            this.genre = genre;
            return this;
        }

        public HouseBuilder setHaveSwimmingPool(boolean haveSwimmingPool) {
            isHaveSwimmingPool = haveSwimmingPool;
            return this;
        }

        public HouseBuilder setRoofType(String roofType) {
            this.roofType = roofType;
            return this;
        }

        //she can have access to private in House because she's nested in it
        public House build(){
            return new House(this);
        }
    }

}
