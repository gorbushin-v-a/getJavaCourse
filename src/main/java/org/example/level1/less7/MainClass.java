package org.example.level1.less7;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(27);

        Cat[] catArray = new Cat[5];
        catArray[0] = new Cat("Barsik", 5);
        catArray[1] = new Cat("Barsik2", 6);
        catArray[2] = new Cat("Barsik3", 7);
        catArray[3] = new Cat("Barsik4", 8);
        catArray[4] = new Cat("Barsik5", 9);

        for (Cat cat : catArray) {
            cat.eat(plate);
            cat.info();
            plate.info();
        }

        plate.increaseFood(8);
        plate.info();
        catArray[4].eat(plate);
        catArray[4].info();
        plate.info();
    }
}
