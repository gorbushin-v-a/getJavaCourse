package org.example.less5;

/*
1 Создать класс "Сотрудник" с полями: ФИО, должность, email, телефон, зарплата, возраст.

2 Конструктор класса должен заполнять эти поля при создании объекта.

3 Внутри класса «Сотрудник» написать метод, который выводит информацию об объекте в консоль.

4 Создать массив из 5 сотрудников.
Пример:
Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
persArray[0] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
30000, 30); // потом для каждой ячейки массива задаем объект
persArray[1] = new Person(...);
...
persArray[4] = new Person(...);

5 С помощью цикла вывести информацию только о сотрудниках старше 40 лет.
 */
public class HomeWorkApp5 {

    public static void main(String[] args){
        Person[] persArray = new Person[5]; // Вначале объявляем массив объектов
        persArray[0] = new Person("Ivanov Pavel", "Engineer", "ivivan@mailbox.com", "892312312",
                30000, 27); // потом для каждой ячейки массива задаем объект
        persArray[1] = new Person("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312",
                40000, 30);
        persArray[2] = new Person("Ivanov Petr", "Engineer", "ivivan@mailbox.com", "892312312",
                50000, 55);
        persArray[3] = new Person("Ivanov Maxim", "Engineer", "ivivan@mailbox.com", "892312312",
                20000, 42);
        persArray[4] = new Person("Ivanov Konstantin", "Engineer", "ivivan@mailbox.com", "892312312",
                60000, 38);

        for (Person person : persArray){
            if(person.getAge() >= 40){
                person.printInfo();
            }
        }
    }
}
