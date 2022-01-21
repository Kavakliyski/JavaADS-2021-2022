package NQueen;

import java.util.*;
public class Queens2 {

    private static final int MAX_N = 100;
    private static int n;
    private static int[][] board = new int[MAX_N][MAX_N];
    private static int count = 1;

    static List<List<Integer>> result = new ArrayList<List<Integer>>();


    public void solveBoard(char[][] board, int row, int rowmask, int ldmask, int rdmask) {

        n = board.length;

        int all_rows_filled = (1 << n) - 1;

        if (rowmask == all_rows_filled) {
            List<Integer> v = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (board[i][j] == 'Q') {
                        v.add(j + 1);
                    }
                }
            }
            result.add(v);
            return;
        }

        int safe = all_rows_filled & (~(rowmask | ldmask | rdmask));
        while (safe > 0) {

            int p = safe & (-safe);
            int col = (int) (Math.log(p) / Math.log(2));
            board[row][col] = 'Q';


            solveBoard(board, row + 1, rowmask | p, (ldmask | p) << 1, (rdmask | p) >> 1);

            safe = safe & (safe - 1);

            board[row][col] = ' ';
        }
    }

    public void printBoard(char[][] board){
        for (int i = 0; i < board.length; i++) {
            System.out.print("|");
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "|");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4;

        char board[][] = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = ' ';
            }
        }

        int rowmask = 0, ldmask = 0, rdmask = 0, row = 0;

        Queens2 sol = new Queens2();

        result.clear();
        sol.solveBoard(board, row, rowmask, ldmask, rdmask);
        System.out.println(result);
    }
}
