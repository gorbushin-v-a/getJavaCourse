package org.example.less7;

public final class Cat {
    private final String name;
    private final int appetite;
    private boolean satiety;

    public Cat(final String name, final int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(final Plate p) {
        satiety = p.decreaseFood(appetite);
    }

    public void info() {
        System.out.println(name + " satiety: " + satiety);
    }
}
