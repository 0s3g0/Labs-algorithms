package lab04;

public class Task01 {

    public static void main(String[] args) {
        int n = Integer.parseInt(IO.readln());

        Printer.testAllSorters("Случайный (Random)", ArrayGenerator.generateRandom(n));
        Printer.testAllSorters("Отсортированный (Sorted)", ArrayGenerator.generateSorted(n));
        Printer.testAllSorters("Обратный порядок (Reversed)", ArrayGenerator.generateReversed(n));
        Printer.testAllSorters("Частично отсортирован (25%)", ArrayGenerator.generatePartiallySorted(n, 0.25));
        Printer.testAllSorters("Частично отсортирован (50%)", ArrayGenerator.generatePartiallySorted(n, 0.50));
        Printer.testAllSorters("Частично отсортирован (75%)", ArrayGenerator.generatePartiallySorted(n, 0.75));
    }
}
