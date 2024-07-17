package org.example.level1.less7;

public final class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(final int n) {
        if (food >= n) {
            food -= n;
            return true;
        } else {
            return false;
        }
    }

    public void increaseFood(final int n) {
        food += n;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
