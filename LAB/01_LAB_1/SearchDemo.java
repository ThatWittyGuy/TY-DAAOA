import java.util.Scanner;

public class SearchDemo {

    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target)
                return i;
        }
        return -1;
    }

    public static int binarySearch(int[] arr, int target) {
        int low = 0, high = arr.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == target)
                return mid;
            else if (arr[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++)
            arr[i] = sc.nextInt();

        int target = sc.nextInt();

        int linearResult = linearSearch(arr, target);
        System.out.println("Linear Search:");
        if (linearResult == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + linearResult);

        // For binary search, array must be sorted
        // Sort the array before binary search
        java.util.Arrays.sort(arr);

        int binaryResult = binarySearch(arr, target);
        System.out.println("Binary Search:");
        if (binaryResult == -1)
            System.out.println("Element not found");
        else
            System.out.println("Element found at index " + binaryResult);

        sc.close();
    }
}
