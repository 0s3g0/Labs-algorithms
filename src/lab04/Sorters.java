package lab04;

public class Sorters {

    public static SortMetrics insertionSort(int[] arr){
        SortMetrics metric = new SortMetrics();
        long startTime = System.nanoTime();

        for (int i = 1; i < arr.length; i++){
            int a = arr[i];
            int j = i - 1;

            for (; j >= 0; j--) {
                metric.iterations++;
                metric.comparisons++;
                if  (arr[j] > a){
                    arr[j+1] = arr[j];

                    metric.swaps++;
                }
                else {
                    break;
                }
            }
            if (j + 1 != i) metric.swaps++;
            arr[j + 1] = a;
        }

        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }

    public static SortMetrics selectionSort(int[] arr){
        SortMetrics metric = new SortMetrics();
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++){
            int minID = i;

            for (int j = i + 1; j < arr.length; j++){
                metric.iterations++;
                metric.comparisons++;
                if (arr[j] < arr[minID]){
                    minID = j;
                }
            }
            if  (minID != i){
                metric.swaps++;
                int temp = arr[i];
                arr[i] = arr[minID];
                arr[minID] = temp;
            }
        }

        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }

    public static SortMetrics bubbleSort(int[] arr){
        SortMetrics metric = new SortMetrics();
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++){
            boolean swaped = false;
            for (int j = 0; j < arr.length - 1 - i; j++){
                metric.iterations++;
                metric.comparisons++;
                if (arr[j] > arr[j+1]){
                    metric.swaps++;
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    swaped = true;
                }
            }
            if (!swaped){
                break;
            }
        }

        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }


    public static SortMetrics quickSort(int[] arr){
        SortMetrics metric = new SortMetrics();
        long startTime = System.nanoTime();

        if (arr != null && arr.length > 1){
            quickSortRecursive(arr, 0, arr.length - 1, metric);
        }


        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }


    private static void quickSortRecursive(int[] arr, int low, int high, SortMetrics metric){
        int pivot = arr[(low + high) / 2];
        int i = low, j = high;

        while (i <= j) {
            metric.iterations++;

            while (arr[i] < pivot) {
                i++;
                metric.comparisons++;
            }
            metric.comparisons++;// для последней неудавшейся проверки arr[i] < pivot

            while (arr[j] > pivot){
                j--;
                metric.comparisons++;
            }
            metric.comparisons++;// для последней неудавшейся проверки arr[j] > pivot

            if (i <= j) {
                if (i < j){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                    metric.swaps++;
                }
                i++;
                j--;
            }
        }
        if (low < j) quickSortRecursive(arr, low, j, metric);
        if (i < high) quickSortRecursive(arr, low, j, metric);
    }


    public static void insertionSortStudentsDesc(int[][] students) {
        for (int i = 1; i < students.length; i++) {
            int[] key = students[i];
            int keySum = getSum(key);
            int j = i - 1;

            while (j >= 0 && getSum(students[j]) < keySum) {
                students[j + 1] = students[j];
                j--;
            }
            students[j + 1] = key;
        }
    }

    public static int getSum(int[] grades) {
        int sum = 0;
        for (int s : grades) sum += s;
        return sum;
    }
}
