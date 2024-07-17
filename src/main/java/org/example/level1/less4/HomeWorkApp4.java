package org.example.level1.less4;

import java.util.Random;
import java.util.Scanner;

/*
1 Полностью разобраться с кодом, попробовать переписать с нуля, стараясь не подглядывать в
методичку.

2 Переделать проверку победы, чтобы она не была реализована просто набором условий,
например, с использованием циклов.

3 * Попробовать переписать логику проверки победы, чтобы она работала для поля 5х5 и
количества фишек 4 Очень желательно не делать это просто набором условий для каждой из
возможных ситуаций;

4 *** Доработать искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
public class HomeWorkApp4 {

    private static final int SIZE = 5;
    private static final int DOTS_TO_WIN = 3;
    private static final char DOT_EMPTY = '•';
    private static final char DOT_X = 'X';
    private static final char DOT_O = 'O';
    private static char[][] map;
    private static final Scanner SC = new Scanner(System.in);
    private static final Random RAND = new Random();

    public static void main(String[] args) {
        initMap();
//        paintMap();
        printMap();
        while (true) {
            humanTurn();
            printMap();
            if (checkWin(DOT_X)) {
                System.out.println("Победил человек");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
            aiTurn();
            printMap();
            if (checkWin(DOT_O)) {
                System.out.println("Победил Искуственный Интеллект");
                break;
            }
            if (isMapFull()) {
                System.out.println("Ничья");
                break;
            }
        }
        System.out.println("Игра закончена");
    }

    public static boolean isMapFull() {
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isCellValid(int x, int y) {
        if (x < 0 || x >= SIZE || y < 0 || y >= SIZE) {
            return false;
        }
        return map[y][x] == DOT_EMPTY;
    }

    public static void initMap() {
        map = new char[SIZE][SIZE];
        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                map[i][j] = DOT_EMPTY;
            }
        }
    }

    public static void printMap() {
        for (int i = 0; i <= SIZE; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < SIZE; i++) {
            System.out.print((i + 1) + " ");
            for (int j = 0; j < SIZE; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void humanTurn() {
        int x;
        int y;
        do {
            System.out.println("Введите координаты в формате X Y");
            x = SC.nextInt() - 1;
            y = SC.nextInt() - 1;
        } while (!isCellValid(x, y));
        map[y][x] = DOT_X;
    }

    public static void aiTurn() {
        if (aiTurnLine()) {
            int x, y;
            do {
                x = RAND.nextInt(SIZE);
                y = RAND.nextInt(SIZE);
            } while (!isCellValid(x, y));
            aiTurnAnswer(x, y);
        }
    }

    /**
     * Вариант блокировки ходов игрока.
     * Блокируются последовательности больше 2 по вертикали и горизонтали (но не по диагонали).
     * Сначала считается последовательность, и следующий символ - не часть последовательности,
     * то предпринимается попытка вставить символ (1), или с другой стороны (2).
     * Если следующего символа нет (поле закончилось), то в конце так же предпринимается попытка
     * поставить символ с другой стороны (3)
     */
    // TODO Можно добавить такую же проверку по диагоналям.
    //  Так же можно сделать, чтобы "ИИ" ходил всегда рядом с игроком.
    //  Ещё вариант - сделать вариант составления линий.
    public static boolean aiTurnLine() {
        // счётчик направления горизонтальной оси
        int countToWinX = 0;
        // счётчик направления вертикальной оси
        int countToWinY = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == DOT_X) {
                    countToWinX++;
                } else {
                    if (countToWinX >= 2) {
                        // (1 - ось X)
                        if (isCellValid(j, i)) {
                            aiTurnAnswer(j, i);
                            return false;
                        // (2 - ось X)
                        } else if (isCellValid(j - countToWinX, i)) {
                            aiTurnAnswer(j - countToWinX, i);
                            return false;
                        }
                    }
                    countToWinX = 0;
                }
                if (map[j][i] == DOT_X) {
                    countToWinY++;
                } else {
                    if (countToWinY >= 2) {
                        // (1 - ось Y)
                        if (isCellValid(i, j)) {
                            aiTurnAnswer(i, j);
                            return false;
                        // (2 - ось Y)
                        } else if (isCellValid(i, j - countToWinY)) {
                            aiTurnAnswer(i, j - countToWinY);
                            return false;
                        }
                    }
                    countToWinY = 0;
                }
            }
            // (3 - ось X)
            if (countToWinX >= 2 && isCellValid(SIZE - 1 - countToWinX, i)) {
                aiTurnAnswer(SIZE - 1 - countToWinX, i);
                return false;
            }
            // (3 - ось Y)
            if (countToWinY >= 2 && isCellValid(i, SIZE - 1 - countToWinY)) {
                aiTurnAnswer(i, SIZE - 1 - countToWinY);
                return false;
            }
            countToWinX = 0;
            countToWinY = 0;
        }
        return true;
    }

    public static void aiTurnAnswer(int x, int y) {
        System.out.println("Компьютер походил в точку " + (x + 1) + " " + (y + 1));
        map[y][x] = DOT_O;
    }

    /**
     * Метод проверки условия для победы.
     */
    // TODO 3 метода проверки можно сократить до одного
    //  путём оптимизированного выбора условий цикла и индексов.
    public static boolean checkWin(char symb) {
        if (checkWinXY(symb)) {
            return true;
        }
        if (checkWinDUpper(symb)) {
            return true;
        }
        return checkWinDLower(symb);
    }

    /**
     * Проверка по горизонтали и вертикали.
     */
    public static boolean checkWinXY(char symb) {
        // счётчик направления горизонтальной оси
        int countToWinX = 0;
        // счётчик направления вертикальной оси
        int countToWinY = 0;
        // максимальные зарегистрированные длины
        int countToWinXMax = 0;
        int countToWinYMax = 0;

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE; j++) {
                if (map[i][j] == symb) {
                    countToWinX++;
                } else {
                    if (countToWinX > countToWinXMax) {
                        countToWinXMax = countToWinX;
                    }
                    countToWinX = 0;
                }
                if (map[j][i] == symb) {
                    countToWinY++;
                } else {
                    if (countToWinY > countToWinYMax) {
                        countToWinYMax = countToWinY;
                    }
                    countToWinY = 0;
                }
            }
            // проверка в случае, если последовательность заканчивается вместе с линией
            if (countToWinX > countToWinXMax) {
                countToWinXMax = countToWinX;
            }
            if (countToWinY > countToWinYMax) {
                countToWinYMax = countToWinY;
            }
            if (countToWinXMax >= DOTS_TO_WIN || countToWinYMax >= DOTS_TO_WIN) {
                return true;
            } else {
                countToWinX = 0;
                countToWinY = 0;
                countToWinXMax = 0;
                countToWinYMax = 0;
            }
        }
        return false;
    }

    /**
     * Проверка вверх от диагоналей (включая диагональ).
     */
    public static boolean checkWinDUpper(char symb) {
        // счётчик направления главной диагонали
        int countToWinD1 = 0;
        // счётчик направления побочной диагонали
        int countToWinD2 = 0;
        // максимальные зарегистрированные длины
        int countToWinD1Max = 0;
        int countToWinD2Max = 0;

        // цикл вниз от диагоналей (включая диагональ)
        for (int i = 0; i < SIZE; i++) {
            // учёт длины диагональных линий (они могут быть короче количества символов до победы)
            if (SIZE - i >= DOTS_TO_WIN) {
                for (int j = 0; j < SIZE - i; j++) {
                    if (map[j + i][j] == symb) {
                        countToWinD1++;
                    } else {
                        if (countToWinD1 > countToWinD1Max) {
                            countToWinD1Max = countToWinD1;
                        }
                        countToWinD1 = 0;
                    }
                    if (map[j + i][SIZE - 1 - j] == symb) {
                        countToWinD2++;
                    } else {
                        if (countToWinD2 > countToWinD2Max) {
                            countToWinD2Max = countToWinD2;
                        }
                        countToWinD2 = 0;
                    }
                }
                // проверка в случае, если последовательность заканчивается вместе с диагональю
                if (countToWinD1 > countToWinD1Max) {
                    countToWinD1Max = countToWinD1;
                }
                if (countToWinD2 > countToWinD2Max) {
                    countToWinD2Max = countToWinD2;
                }
                if (countToWinD1Max >= DOTS_TO_WIN || countToWinD2Max >= DOTS_TO_WIN) {
                    return true;
                } else {
                    countToWinD1 = 0;
                    countToWinD2 = 0;
                    countToWinD1Max = 0;
                    countToWinD2Max = 0;
                }
            }
        }
        return false;
    }

    /**
     * Проверка вниз от диагоналей (включая диагональ).
     */
    public static boolean checkWinDLower(char symb) {
        // счётчик направления главной диагонали
        int countToWinD1 = 0;
        // счётчик направления побочной диагонали
        int countToWinD2 = 0;
        // максимальные зарегистрированные длины
        int countToWinD1Max = 0;
        int countToWinD2Max = 0;

        // цикл вверх от диагоналей
        for (int i = 1; i < SIZE; i++) {
            if (SIZE - i >= DOTS_TO_WIN) {
                for (int j = i; j < SIZE; j++) {
                    if (map[j - i][j] == symb) {
                        countToWinD1++;
                    } else {
                        if (countToWinD1 > countToWinD1Max) {
                            countToWinD1Max = countToWinD1;
                        }
                        countToWinD1 = 0;
                    }
                    if (map[j - i][SIZE - 1 - j] == symb) {
                        countToWinD2++;
                    } else {
                        if (countToWinD2 > countToWinD2Max) {
                            countToWinD2Max = countToWinD2;
                        }
                        countToWinD2 = 0;
                    }
                }
                // проверка в случае, если последовательность заканчивается вместе с диагональю
                if (countToWinD1 > countToWinD1Max) {
                    countToWinD1Max = countToWinD1;
                }
                if (countToWinD2 > countToWinD2Max) {
                    countToWinD2Max = countToWinD2;
                }
                if (countToWinD1Max >= DOTS_TO_WIN || countToWinD2Max >= DOTS_TO_WIN) {
                    return true;
                } else {
                    countToWinD1 = 0;
                    countToWinD2 = 0;
                    countToWinD1Max = 0;
                    countToWinD2Max = 0;
                }
            }
        }
        return false;
    }

    /**
     * Метод проверки прохода по диагонали.
     */
    public static void paintMap() {
        for (int i = 0; i < SIZE; i++) {
            if (SIZE - i >= DOTS_TO_WIN) {
                for (int j = 0; j < SIZE - i; j++) {
                    map[j + i][j] = DOT_X;
                }
            }
        }
        for (int i = 1; i < SIZE; i++) {
            if (SIZE - i >= DOTS_TO_WIN) {
                for (int j = i; j < SIZE; j++) {
                    map[j - i][j] = DOT_X;
                }
            }
        }

        for (int i = 0; i < SIZE; i++) {
            for (int j = 0; j < SIZE - i; j++) {
                map[j + i][SIZE - 1 - j] = DOT_X;
            }
        }
        for (int i = 1; i < SIZE; i++) {
            for (int j = i; j < SIZE; j++) {
                map[j - i][SIZE - 1 - j] = DOT_X;
            }
        }
    }

    /**
     * Изначальный метод проверки условия для победы.
     */
    public static boolean checkWinOld(char symb) {
        if (map[0][0] == symb && map[0][1] == symb && map[0][2] == symb) {
            return true;
        }
        if (map[1][0] == symb && map[1][1] == symb && map[1][2] == symb) {
            return true;
        }
        if (map[2][0] == symb && map[2][1] == symb && map[2][2] == symb) {
            return true;
        }
        if (map[0][0] == symb && map[1][0] == symb && map[2][0] == symb) {
            return true;
        }
        if (map[0][1] == symb && map[1][1] == symb && map[2][1] == symb) {
            return true;
        }
        if (map[0][2] == symb && map[1][2] == symb && map[2][2] == symb) {
            return true;
        }
        if (map[0][0] == symb && map[1][1] == symb && map[2][2] == symb) {
            return true;
        }
        return map[2][0] == symb && map[1][1] == symb && map[0][2] == symb;
    }
}
