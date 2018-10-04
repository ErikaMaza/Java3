package task;

/*
 *
 * Написать метод, которому в качестве аргумента передается не пустой одномерный целочисленный массив.
 * Метод должен вернуть новый массив, который получен путем вытаскивания из исходного массива элементов, идущих после последней четверки.
 * Входной массив должен содержать хотя бы одну четверку, иначе в методе необходимо выбросить RuntimeException.
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 * Вх: [ 1 2 4 4 2 3 4 1 7 ] -> вых: [ 1 7 ].
 */

import java.util.Arrays;

public class Task1 {

        public static int[] AfterLast4(int[] arr) throws RuntimeException {
            int n = 0;
            String str = Arrays.toString(arr);
            if (str.indexOf(String.valueOf(4)) != -1) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == 4) n = i;
                }
                int[] arr1 = new int[arr.length - n - 1];
                System.arraycopy(arr, n + 1, arr1, 0, arr1.length);
                return arr1;
            } else {
                throw new RuntimeException("4 не найдена");
            }
        }

    public static boolean Only1And4(int[] arr) {
        String str = Arrays.toString(arr);
        if (str.indexOf(String.valueOf(4)) != -1 && str.indexOf(String.valueOf(1)) != -1) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != 4 || arr[i] != 1) return false;
            }
        }
        return false;
    }
}

