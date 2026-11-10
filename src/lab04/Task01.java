package lab04;

public class Task01 {

    public static void main(String[] args) {
        IO.println("Введите размер массива:");
        int n = Integer.parseInt(IO.readln());

        Printer.testAllSorters("Случайный", ArrayGenerator.generateRandom(n));
        Printer.testAllSorters("Отсортированный", ArrayGenerator.generateSorted(n));
        Printer.testAllSorters("Обратный порядок", ArrayGenerator.generateReversed(n));
        Printer.testAllSorters("Частично отсортирован (25%)", ArrayGenerator.generatePartiallySorted(n, 0.25));
        Printer.testAllSorters("Частично отсортирован (50%)", ArrayGenerator.generatePartiallySorted(n, 0.50));
        Printer.testAllSorters("Частично отсортирован (75%)", ArrayGenerator.generatePartiallySorted(n, 0.75));
    }
}
