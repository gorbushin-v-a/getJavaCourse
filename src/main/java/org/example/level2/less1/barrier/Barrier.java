package org.example.level2.less1.barrier;

import org.example.level2.less1.entity.Movable;

public interface Barrier {
    boolean overcome(Movable movable);

    void info();
}
