public class TreasureIsland {

    // ‘@’ – златно съкровище
// ‘   ‘ – проходима зона
// ‘~’ – вода
// ‘*’ – подвижен пясък
// ‘v’ – пропаст
// ‘/’ – планина
// ‘#’ – гъста гора
// ‘!’ – човекоядци
    private static final char[] symbols = new char[]{' ', '@', '~',
            '*', 'v', '/', '#', '!'};

    private static int position = 0;

    private static final char[][] island = {
            {' ', ' ', ' ', '-', ' ', ' ', ' '},
            {'-', '-', ' ', '-', ' ', '-', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '-', '-', '-', '-', '-', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'M'},
    };

    public static void printIsland() {
        System.out.println();

        for (int row = 0; row < island.length; row++) {
            for (int column = 0; column < island[row].length; column++) {
                System.out.print(island[row][column]);
            }
            System.out.println();
        }
        System.out.println();
    }

    public boolean solve(int row, int column) {
        boolean done = false;

        if (valid(row, column)) {
            island[row][column] = 3;  // cell has been tried
            if (row == island.length - 1 && column == island[0].length - 1)
                done = true;  // maze is solved
            else {
                done = solve(row + 1, column);  // down
                if (!done)
                    done = solve(row, column + 1);  // right
                if (!done)
                    done = solve(row - 1, column);  // up
                if (!done)
                    done = solve(row, column - 1);  // left
            }
            if (done)  // part of the final path
                island[row][column] = 7;
        }

        return done;
    }

    private boolean valid (int row, int column){

            boolean result = false;

            // check if cell is in the bounds of the matrix
            if (row >= 0 && row < island.length &&
                    column >= 0 && column < island[0].length)

                //  check if cell is not blocked and not previously tried
                if (island[row][column] == 1)
                    result = true;

                return result;
    }

}