package org.example.level2.less1.entity;

public final class Robot implements Movable {

    private final int run = 10;
    private final int jump = 100;

    @Override
    public int run() {
        return run;
    }

    @Override
    public int jump() {
        return jump;
    }
}
