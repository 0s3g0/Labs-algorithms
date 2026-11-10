package lab05;

import java.util.Locale;
import java.util.Random;

public class Main {
    private static final int[] SIZES = {20, 500, 1000, 3000, 5000, 10000};
    private static final int TRIALS = 100;
    private static final Random rnd = new Random();

    public static void main(String[] args) {
        Task01();
        Task02();
    }

    private static void Task01() {
        IO.println("1. Исследование линейного поиска\n");
        System.out.printf("%-8s | %-12s %-12s | %-12s %-12s | %-15s | %-15s\n",
                "Размер", "Лин.Сравн", "Лин.Время", "Бар.Сравн", "Бар.Время", "Лучший(Лин/Бар)", "Худший(Лин/Бар)");

        for (int size : SIZES) {
            int[] arr = lab04.ArrayGenerator.generateRandom(size);

            long sumLinComp = 0, sumLinTime = 0;
            long sumBarComp = 0, sumBarTime = 0;

            for (int t = 0; t < TRIALS; t++) {
                int target = (t % 2 == 0) ? arr[rnd.nextInt(size)] : rnd.nextInt(size * 3);

                SearchMetrics mLin = Searchers.linearSearch(arr, target);
                SearchMetrics mBar = Searchers.barrierSearch(arr, target);

                sumLinComp += mLin.comparisons;
                sumLinTime += mLin.workTime;
                sumBarComp += mBar.comparisons;
                sumBarTime += mBar.workTime;
            }

            double avgLinComp = (double) sumLinComp / TRIALS;
            double avgLinTime = (double) sumLinTime / TRIALS;
            double avgBarComp = (double) sumBarComp / TRIALS;
            double avgBarTime = (double) sumBarTime / TRIALS;

            int bestTarget = arr[0];
            long bestLinTime = Searchers.linearSearch(arr, bestTarget).workTime;
            long bestBarTime = Searchers.barrierSearch(arr, bestTarget).workTime;

            int worstTarget = -999;
            long worstLinTime = Searchers.linearSearch(arr, worstTarget).workTime;
            long worstBarTime = Searchers.barrierSearch(arr, worstTarget).workTime;

            System.out.printf(Locale.US, "%-8d | %-12.1f %-12.1f | %-12.1f %-12.1f | %-7d/%-7d | %-7d/%-7d\n",
                    size, avgLinComp, avgLinTime, avgBarComp, avgBarTime,
                    bestLinTime, bestBarTime, worstLinTime, worstBarTime);

        }
    }

    private static void Task02() {
        IO.println("\n\n2. Сравнение линейного и двоичного поиска\n");
        IO.println("Лучший случай: Искомый элемент присутствует в массиве");
        System.out.printf("%-10s | %-15s %-15s | %-15s %-15s\n",
                "Размер", "Лин.Сравн", "Лин.Время(нс)", "Бин.Сравн", "Бин.Время(нс)");

        for (int size : SIZES) {
            int[] arr = lab04.ArrayGenerator.generateRandom(size);
            lab04.Sorters.quickSort(arr);

            long sumLinComp = 0, sumLinTime = 0;
            long sumBinComp = 0, sumBinTime = 0;

            for (int t = 0; t < TRIALS; t++) {
                int target = arr[rnd.nextInt(size)];

                SearchMetrics mLin = Searchers.linearSearch(arr, target);
                SearchMetrics mBin = Searchers.binarySearch(arr, target);

                sumLinComp += mLin.comparisons;
                sumLinTime += mLin.workTime;
                sumBinComp += mBin.comparisons;
                sumBinTime += mBin.workTime;
            }

            System.out.printf(Locale.US, "%-10d | %-15.1f %-15.1f | %-15.1f %-15.1f\n",
                    size,
                    (double) sumLinComp / TRIALS, (double) sumLinTime / TRIALS,
                    (double) sumBinComp / TRIALS, (double) sumBinTime / TRIALS);
        }

        IO.println("\nХудший случай: Искомый элемент отсутствует в массиве\n");
        System.out.printf("%-10s | %-15s %-15s | %-15s %-15s\n",
                "Размер", "Лин.Сравн", "Лин.Время(нс)", "Бин.Сравн", "Бин.Время(нс)");

        for (int size : SIZES) {
            int[] arr = lab04.ArrayGenerator.generateRandom(size);
            lab04.Sorters.quickSort(arr);

            long sumLinComp = 0, sumLinTime = 0;
            long sumBinComp = 0, sumBinTime = 0;

            for (int t = 0; t < TRIALS; t++) {
                // Гарантированно отсутствующее отрицательное число (т.к. в массиве числа >= 0)
                int target = -(t + 1);

                SearchMetrics mLin = Searchers.linearSearch(arr, target);
                SearchMetrics mBin = Searchers.binarySearch(arr, target);

                sumLinComp += mLin.comparisons;
                sumLinTime += mLin.workTime;
                sumBinComp += mBin.comparisons;
                sumBinTime += mBin.workTime;
            }

            System.out.printf(Locale.US, "%-10d | %-15.1f %-15.1f | %-15.1f %-15.1f\n",
                    size,
                    (double) sumLinComp / TRIALS, (double) sumLinTime / TRIALS,
                    (double) sumBinComp / TRIALS, (double) sumBinTime / TRIALS);
        }
    }
}
