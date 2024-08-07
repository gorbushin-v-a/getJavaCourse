package org.example.level1.less6;

/*
1 Создать классы Собака и Кот с наследованием от класса Животное.

2 Все животные могут бежать и плыть. В качестве параметра каждому методу передается длина препятствия.
Результатом выполнения действия будет печать в консоль.
(Например, dogBobik.run(150); -> 'Бобик пробежал 150 м.');

3 У каждого животного есть ограничения на действия (бег: кот 200 м., собака 500 м.; плавание:
кот не умеет плавать, собака 10 м.).

4 * Добавить подсчет созданных котов, собак и животных.
 */
public class HomeWorkApp6 {

    public static void main(String[] args){
        Home home = new Home();
        Cat cat = home.createCat("Tom");
        Dog dog = home.createDog("Fedya");
        cat.swim(3);
        dog.run(479);
        System.out.println("Было заведено "+home.getAnimalCount()+" животных");
    }
}
