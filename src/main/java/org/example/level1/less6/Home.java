package org.example.level1.less6;

public class Home {

    private int AnimalCount = 0;

    public int getAnimalCount() {
        return AnimalCount;
    }

    public Cat createCat(String name) {
        AnimalCount++;
        return new Cat(name);
    }

    public Dog createDog(String name) {
        AnimalCount++;
        return new Dog(name);
    }


}
