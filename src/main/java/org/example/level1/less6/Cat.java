package org.example.level1.less6;

public class Cat extends Animal{

    public Cat(String name) {
        this.name = name;
    }

    @Override
    public void run(int distance) {
        if (distance <= 200) {
            System.out.println(name+" пробежал "+distance+" метров");
        } else {
            System.out.println(name+" не смог пробежать "+distance+" метров");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(name+" не умеет плавать");
    }
}
