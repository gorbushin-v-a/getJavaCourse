package org.example.level2.less1.entity;

public final class Human implements Movable {

    private final int run = 10000;
    private final int jump = 5;

    @Override
    public int run() {
        return run;
    }

    @Override
    public int jump() {
        return jump;
    }
}
