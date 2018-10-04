package task;

/*
 *
 * Написать метод, который проверяет состав массива из чисел 1 и 4.
 * Если в нем нет хоть одной четверки или единицы, то метод вернет false;
 * Написать набор тестов для этого метода (по 3-4 варианта входных данных).
 *
 */

public class Task2 {
        public static boolean Only1And4(int[] arr) {
            boolean i1 = false, i4 = false;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 1) i1 = true;
                else if (arr[i] == 4) i4 = true;
                else return false;
            }
            return i1 && i4;
        }
    }

