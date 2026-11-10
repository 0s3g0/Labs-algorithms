package lab05;

public class Searchers {

    //Классический линейный поиск
    public static SearchMetrics linearSearch(int[] arr, int target) {
        SearchMetrics metric = new SearchMetrics();
        long startTime = System.nanoTime();

        for (int i = 0; i < arr.length; i++) {
            metric.comparisons++;
            metric.comparisons++;
            if (arr[i] == target) {
                metric.foundIndex = i;
                break;
            }
        }
        if (metric.foundIndex == -1) {
            metric.comparisons++;
        }

        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }

    // 2. Линейный поиск с барьером
    public static SearchMetrics barrierSearch(int[] arr, int target) {
        SearchMetrics metric = new SearchMetrics();
        long startTime = System.nanoTime();

        int lastIdx = arr.length - 1;
        int savedLast = arr[lastIdx];

        metric.comparisons++;
        if (savedLast == target) {
            metric.foundIndex = lastIdx;
            metric.workTime = System.nanoTime() - startTime;
            return metric;
        }

        // Барьер
        arr[lastIdx] = target;

        int i = 0;
        while (arr[i] != target) {
            metric.comparisons++;
            i++;
        }
        metric.comparisons++;

        arr[lastIdx] = savedLast;

        if (i < lastIdx) {
            metric.foundIndex = i;
        } else {
            metric.foundIndex = -1;
        }

        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }

    // 3. Двоичный поиск
    public static SearchMetrics binarySearch(int[] arr, int target) {
        SearchMetrics metric = new SearchMetrics();
        long startTime = System.nanoTime();

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            metric.comparisons++;
            if (arr[mid] == target) {
                metric.foundIndex = mid;
                break;
            }

            metric.comparisons++;
            if (arr[mid] < target) {
                low = mid + 1; // ищем в правой половине
            } else {
                high = mid - 1; // ищем в левой половине
            }
        }

        metric.workTime = System.nanoTime() - startTime;
        return metric;
    }
}