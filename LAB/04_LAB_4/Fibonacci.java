import java.util.Scanner;

public class Fibonacci {
    public static int[] fibonacci(int n) {
        int[] dp = new int[n];
        if (n > 0) dp[0] = 0;
        if (n > 1) dp[1] = 1;
        for (int i = 2; i < n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the number of Fibonacci terms: ");
        int n = scanner.nextInt();
        int[] result = fibonacci(n);
        System.out.println("Fibonacci sequence:");
        for (int num : result) {
            System.out.println(num);
        }
        scanner.close();
    }
}

/*
Time Complexity:
- O(n), because the loop runs once from 2 to n, performing constant-time addition each iteration.

Space Complexity:
- O(n), due to the array storing all Fibonacci numbers up to n for reuse.
*/
