package org.example.level2.less1.barrier;

import org.example.level2.less1.entity.Movable;

public final class Wall implements Barrier {
    private final int size;

    public Wall(int size) {
        this.size = size;
    }

    @Override
    public boolean overcome(Movable movable) {
        return movable.jump() > size;
    }

    @Override
    public void info() {
        System.out.println("Испытание: стена, размер: " + size);
    }
}
