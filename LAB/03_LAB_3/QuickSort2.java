import java.util.Scanner;
import java.util.Stack;

public class QuickSort2 {

    public static void quickSort(int[] arr, int low, int high) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{low, high});

        while (!stack.isEmpty()) {
            int[] range = stack.pop();
            low = range[0];
            high = range[1];

            if (low < high) {
                int pi = partition(arr, low, high);

                // Push the right side (pi + 1 to high) to the stack
                stack.push(new int[]{pi + 1, high});

                // Push the left side (low to pi - 1) to the stack
                stack.push(new int[]{low, pi - 1});
            }
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the number of elements: ");
        int n = scanner.nextInt();
        
        int[] arr = new int[n];
        
        System.out.println("Enter the elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        
        System.out.println("Original Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        quickSort(arr, 0, n - 1);
        
        System.out.println("Sorted Array:");
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        scanner.close();
    }
}
