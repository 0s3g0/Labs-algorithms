package lab04;

public class Printer {

    public static void testAllSorters(String testName, int[] original) {
        System.out.println("\n=== Состояние: " + testName + " (размер: " + original.length + ") ===");
        System.out.printf("%-15s | %-12s | %-12s | %-12s | %-15s\n",
                "Алгоритм", "Итерации", "Сравнения", "Перестановки", "Время (нс)");
        System.out.println("-----------------------------------------------------------------------------");

        // 1. Прямое включение (вставки)
        SortMetrics m1 = Sorters.insertionSort(original.clone());
        printMetrics("Включениями", m1);

        // 2. Прямой выбор
        SortMetrics m2 = Sorters.selectionSort(original.clone());
        printMetrics("Выбором", m2);

        // 3. Прямой обмен (пузырек)
        SortMetrics m3 = Sorters.bubbleSort(original.clone());
        printMetrics("Пузырьком", m3);

        // 4. Быстрая (Хоара)
        SortMetrics m4 = Sorters.quickSort(original.clone());
        printMetrics("Хоара (Quick)", m4);
    }

    // Простой вспомогательный вывод одной строки метрик
    private static void printMetrics(String name, SortMetrics m) {
        System.out.printf("%-15s | %-12d | %-12d | %-12d | %-15d\n",
                name, m.iterations, m.comparisons, m.swaps, m.workTime);
    }


}
