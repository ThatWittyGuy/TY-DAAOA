import java.util.Scanner;

public class NQueen {
    public static boolean isSafe(int[][] board, int row, int col, int N) {
        for (int i = 0; i < col; i++)
            if (board[row][i] == 1)
                return false;

        for (int i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        for (int i = row, j = col; i < N && j >= 0; i++, j--)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    public static boolean solveNQueen(int[][] board, int col, int N) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isSafe(board, i, col, N)) {
                board[i][col] = 1;
                if (solveNQueen(board, col + 1, N))
                    return true;
                board[i][col] = 0; // backtracking if not satisfied
            }
        }
        return false;
    }

    public static void printBoard(int[][] board, int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the board (N):");
        int N = sc.nextInt();

        int[][] board = new int[N][N];

        if (solveNQueen(board, 0, N)) {
            System.out.println("Solution exists:");
            printBoard(board, N);
        } else {
            System.out.println("Solution does not exist");
        }
        sc.close();
    }
}
