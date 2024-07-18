package org.example.level2.less2;

public class HomeWorkApp2 {

    public static void main(String[] args) {
        String[] array1 = {"1", "2", "3", "4"};
        String[] array2 = {"1", "2", "3", "4"};
        String[] array3 = {"1", "2", "3", "4"};
        String[] array4 = {"1", "2", "3", "4"};
        String[][] array4in4 = {array1, array2, array3, array4};
        try {
            System.out.println(sumMatrix(array4in4));
        } catch (MyArraySizeException e) {
            System.out.println("Массив должен соответствовать размеру 4*4");
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int sumMatrix(String[][] array) throws MyArraySizeException, MyArrayDataException {
        if (array.length != 4 || array[0].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Ошибка в месте " + i + ":" + j);
                }
            }
        }
        return sum;
    }
}
