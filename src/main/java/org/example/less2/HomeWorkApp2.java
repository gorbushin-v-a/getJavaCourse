package org.example.less2;

/*
1 Написать метод, принимающий на вход два целых числа и проверяющий, что их сумма лежит
в пределах от 10 до 20 (включительно), если да – вернуть true, в противном случае – false.

2 Написать метод, которому в качестве параметра передается целое число, метод должен
напечатать в консоль, положительное ли число передали или отрицательное. Замечание: ноль
считаем положительным числом.

3 Написать метод, которому в качестве параметра передается целое число. Метод должен
вернуть true, если число отрицательное, и вернуть false если положительное.

4 Написать метод, которому в качестве аргументов передается строка и число, метод должен
отпечатать в консоль указанную строку, указанное количество раз;

5 Написать метод, который определяет, является ли год високосным, и возвращает boolean
(високосный - true, не високосный - false). Каждый 4-й год является високосным, кроме каждого
100-го, при этом каждый 400-й – високосный.
 */
public class HomeWorkApp2 {
    public static void main(String[] args) {
        System.out.println(checkSumValue(10, 3));
        printNumSign(1);
        System.out.println(checkNumSignInvert(2));
        linePrinter("Repeat this 3 times", 3);
        System.out.println(sLeapYear(304));
    }

    private static boolean checkSumValue(int a, int b) {
        int sum = a + b;
        return sum >= 10 && sum <= 20;
    }

    private static void printNumSign(int a) {
        if (a >= 0) {
            System.out.printf("Число %s положительное\n", a);
        } else {
            System.out.printf("Число %s отрицательное\n", a);
        }
    }

    private static boolean checkNumSignInvert(int a) {
        return a < 0;
    }

    private static void linePrinter(String line, int a) {
        for (int i = 0; i < a; i++) {
            System.out.println(line);
        }
    }

    private static boolean sLeapYear(int a) {
        return a % 400 == 0 || (a % 4 == 0 && a % 100 != 0);
    }
}
