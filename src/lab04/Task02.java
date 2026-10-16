package lab04;

public class Task02 {

    public static void main(String[] args) {
        int[] sizes = {20, 500, 1000, 3000, 5000, 10000};

        for (int size : sizes) {
            int[] randomArray = ArrayGenerator.generateRandom(size);
            Printer.testAllSorters("Случайный массив N = " + size, randomArray);
        }
    }
}
