public class Top {

    private static final int MAX_N = 100;
    private static int n;
    private static final int[][] board = new int[MAX_N][MAX_N];
    private static int count = 1;


    public static void main(String[] args) {
        n = 4;
        generate(0);
    }


    public static void printBoard() {
        System.out.println("\n Решение номер: " + count);
        count++;
        for (int i = 0;  i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1){
                    System.out.print(" * ");
                } else {
                    System.out.print(" 0 ");
                }
            }
            System.out.println();
        }
    }

    public static void generate(int i){
        if (i > n){
            return;
        }
        if (i == n){
            printBoard();
            return;
        }
        for (int j = 0; j < n; j++){
            if (isFree(0,0)){
                board[i][j] = 1;
                generate(i + 1);
                board[i][j] = 0;
            }
        }
    }

    public static boolean isFree(int i, int j){
        for (int k = 1; k < n; k++) {
            if (board[i][k] == 1 || board[k][j] == 1) {
                return false;
            }
        }
        return true;
    }
}