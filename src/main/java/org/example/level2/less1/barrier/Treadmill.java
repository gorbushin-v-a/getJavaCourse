package org.example.level2.less1.barrier;

import org.example.level2.less1.entity.Movable;

public final class Treadmill implements Barrier {
    private final int size;

    public Treadmill(int size) {
        this.size = size;
    }

    @Override
    public boolean overcome(Movable movable) {
        return movable.run() > size;
    }

    @Override
    public void info() {
        System.out.println("Испытание: дорога, размер: " + size);
    }
}
