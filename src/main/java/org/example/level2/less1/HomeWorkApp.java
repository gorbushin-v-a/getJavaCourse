package org.example.level2.less1;

import org.example.level2.less1.barrier.Barrier;
import org.example.level2.less1.barrier.Treadmill;
import org.example.level2.less1.barrier.Wall;
import org.example.level2.less1.entity.Cat;
import org.example.level2.less1.entity.Human;
import org.example.level2.less1.entity.Movable;
import org.example.level2.less1.entity.Robot;

import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

/*
1 Создайте три класса Человек, Кот, Робот, которые не наследуются от одного класса. Эти
классы должны уметь бегать и прыгать (методы просто выводят информацию о действии в
консоль).

2 Создайте два класса: беговая дорожка и стена, при прохождении через которые, участники
должны выполнять соответствующие действия (бежать или прыгать), результат выполнения
печатаем в консоль (успешно пробежал, не смог пробежать и т.д.).

3 Создайте два массива: с участниками и препятствиями, и заставьте всех участников пройти
этот набор препятствий.

4 * У препятствий есть длина (для дорожки) или высота (для стены), а участников ограничения
на бег и прыжки. Если участник не смог пройти одно из препятствий, то дальше по списку он
препятствий не идет.
 */
public class HomeWorkApp {
    private static final int MIN_BARRIERS_LENGHT = 5;
    private static final int MAX_BARRIERS_LENGHT = 15;

    private static final int MIN_TREADMILL_SIZE = 1;
    private static final int MAX_TREADMILL_SIZE = 101;

    private static final int MIN_WALL_SIZE = 1;
    private static final int MAX_WALL_SIZE = 11;

    public static void main(String[] args) {
        Cat cat = new Cat();
        Human human = new Human();
        Robot robot = new Robot();
        Movable[] movables = {cat, human, robot};
        trial(movables);
    }

    private static void trial(Movable[] movables) {

        boolean[] movablesOvercome = new boolean[movables.length];
        Arrays.fill(movablesOvercome, true);

        ThreadLocalRandom tlr = ThreadLocalRandom.current();
        Barrier[] barriers = new Barrier[tlr.nextInt(MIN_BARRIERS_LENGHT, MAX_BARRIERS_LENGHT)];

        for (int i = 0; i < barriers.length; i++) {
            if (i % 2 == 0) {
                barriers[i] = new Treadmill(tlr.nextInt(MIN_TREADMILL_SIZE, MAX_TREADMILL_SIZE));
            } else {
                barriers[i] = new Wall(tlr.nextInt(MIN_WALL_SIZE, MAX_WALL_SIZE));
            }
        }

        for (int i = 0; i < barriers.length; i++) {
            System.out.print(i + " ");
            barriers[i].info();
            if (movablesOvercome[0] && barriers[i].overcome(movables[0])) {
                System.out.println("Кот прошёл препятствие");
            } else {
                movablesOvercome[0] = false;
                System.out.println("Кот выбыл из испытания");
            }

            if (movablesOvercome[1] && barriers[i].overcome(movables[1])) {
                System.out.println("Человек прошёл препятствие");
            } else {
                movablesOvercome[1] = false;
                System.out.println("Человек выбыл из испытания");
            }

            if (movablesOvercome[2] && barriers[i].overcome(movables[2])) {
                System.out.println("Робот прошёл препятствие");
            } else {
                movablesOvercome[2] = false;
                System.out.println("Робот выбыл из испытания");
            }
            System.out.println();
        }
    }
}
