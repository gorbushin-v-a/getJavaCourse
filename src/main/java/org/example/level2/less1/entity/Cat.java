package org.example.level2.less1.entity;

public final class Cat implements Movable {

    private final int run = 100;
    private final int jump = 10;

    @Override
    public int run() {
        return run;
    }

    @Override
    public int jump() {
        return jump;
    }
}
