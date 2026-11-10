package lab04;

public class Printer {

    public static void testAllSorters(String testName, int[] original) {
        System.out.println("Состояние: " + testName);
        System.out.printf("%-15s | %-12s | %-12s | %-12s | %-15s\n",
                "Алгоритм", "Итерации", "Сравнения", "Перестановки", "Время");

        SortMetrics m1 = Sorters.insertionSort(original.clone());
        printMetrics("Включениями", m1);

        SortMetrics m2 = Sorters.selectionSort(original.clone());
        printMetrics("Выбором", m2);

        SortMetrics m3 = Sorters.bubbleSort(original.clone());
        printMetrics("Пузырьком", m3);

        SortMetrics m4 = Sorters.quickSort(original.clone());
        printMetrics("Хоара (Quick)", m4);

        System.out.println("\n");
    }

    private static void printMetrics(String name, SortMetrics m) {
        System.out.printf("%-15s | %-12d | %-12d | %-12d | %-15d\n",
                name, m.iterations, m.comparisons, m.swaps, m.workTime);
    }


}
