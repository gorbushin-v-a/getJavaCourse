package org.example.level1.less5;

public class Person {
    private final String name;
    private final String position;
    private final String email;
    private final String phone;
    private final int salary;
    private final int age;

    public int getAge() {
        return age;
    }

    public Person(String name, String position, String email, String phone, int salary, int age){
        this.name = name;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.salary = salary;
        this.age = age;
    }

    public void printInfo(){
        System.out.println("Информация о сотруднике:");
        System.out.println("ФИО: "+name);
        System.out.println("Должность: "+position);
        System.out.println("Почта: "+email);
        System.out.println("Номер телефона: "+phone);
        System.out.println("Зарплата: "+salary);
        System.out.println("Возраст: "+age);
        System.out.println();
    }
}
