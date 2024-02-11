
import java.util.Arrays;
import java.util.Random;

public class App {
    public static void swap(int[] arr, int i, int j) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void bubbleSort(int[] arr, int n) {
        if (arr == null || arr.length <= 1 || n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        bubbleSort(arr, n - 1);
    }
    public static int[] createRandomArray(int n){
        int[] arr = new int[n];
        Random random = new Random();
        for(int i = 0; i < n; i++){
            arr[i] = random.nextInt(100);
        }
        return arr;
    }

    public static void mergesort(int[] arr, int left, int right){
        
        if (right - left > 1){
            int mid = (left + right) / 2;
            mergesort(arr, left, mid);
            mergesort(arr, mid, right);
            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right){
        int[] leftArr = Arrays.copyOfRange(arr, left, mid);
        int[] rightArr = Arrays.copyOfRange(arr, mid, right);
        int i = 0, j = 0;
        for (int k = left; k < right; k++){
            if (i == leftArr.length){
                arr[k] = rightArr[j++];
            } else if (j == rightArr.length){
                arr[k] = leftArr[i++];
            } else if (leftArr[i] <= rightArr[j]){
                arr[k] = leftArr[i++];
            } else {
                arr[k] = rightArr[j++];
            }
        }
    }

    public static void mergesort(int[] arr){
        mergesort(arr, 0, arr.length);
    }

    public static boolean isSorted(int[] arr){
        for (int i = 0; i < arr.length - 1; i++){
            if (arr[i] > arr[i + 1]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws Exception {
        int n = 10000;
        int[] arr = createRandomArray(n);
        int[] arr2 = createRandomArray(n);
        System.out.println("Pre Merge Sort:");
        System.out.println("is array sorted: " + isSorted(arr));
        long start = System.currentTimeMillis();
        mergesort(arr);
        long end = System.currentTimeMillis();
        System.out.println("Merge Sort: Time taken " + (end - start) + "ms");
        System.out.println("Post Merge Sort:");
        System.out.println("is array sorted: " + isSorted(arr));
        System.out.println();
        System.out.println("Pre Bubble Sort:");
        System.out.println("is array sorted: " + isSorted(arr2));
        long start2 = System.currentTimeMillis();
        bubbleSort(arr2, arr2.length-1);
        long end2 = System.currentTimeMillis();
        System.out.println("Post Bubble Sort:");
        System.out.println("Bubble Sort: Time taken " + (end2 - start2) + "ms");
        System.out.println("is array sorted: " + isSorted(arr2));

        }

    }

