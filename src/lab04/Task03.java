package lab04;

import java.util.Arrays;
import java.util.Random;

public class Task03 {

    public static void main(String[] args) {
        int n = 8; // Количество студентов
        int[][] students = new int[n][5]; // 5 - предметов
        Random rnd = new Random();

        // Заполняем случайными баллами (например, от 40 до 100)
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 5; j++) {
                students[i][j] = rnd.nextInt(0, 100);
            }
        }

        System.out.println("Исходный список студентов");
        printStudents(students);

        Sorters.insertionSortStudentsDesc(students);

        System.out.println("\nПосле сортировки (по убыванию суммы)");
        printStudents(students);
    }

    private static void printStudents(int[][] students) {
        for (int i = 0; i < students.length; i++) {
            System.out.printf("Студент #%d: Экзамены %s | Сумма: %d\n",
                    (i + 1), Arrays.toString(students[i]), Sorters.getSum(students[i]));
        }
    }
}
//Студенты сдали пять экзаменов.
// Нужно отсортировать список студентов по убыванию общего балла
// по результатам сданных экзаменов (сортировка с помощью прямого включения).
