package org.example.level1.less6;

public class Dog extends Animal{

    public Dog(String name) {
        this.name = name;
    }

    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(name+" пробежал "+distance+" метров");
        } else {
            System.out.println(name+" не смог пробежать "+distance+" метров");
        }
    }

    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(name+" проплыл "+distance+" метров");
        } else {
            System.out.println(name+" не смог проплыть "+distance+" метров");
        }
    }
}
