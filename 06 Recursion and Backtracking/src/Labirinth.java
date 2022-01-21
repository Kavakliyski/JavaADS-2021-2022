public class Labirinth {

    private static final char[] [] labirinth = {
            {' ', ' ', ' ', '-', ' ', ' ', ' '},
            {'-', '-', ' ', '-', ' ', '-', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', ' '},
            {' ', '-', '-', '-', '-', '-', ' '},
            {' ', ' ', ' ', ' ', ' ', ' ', 'M'},
    };

    private static final char[] path = new char[labirinth[0].length * labirinth.length];

    private static int position = 0;


    private static void findPath(int row, int col, char direction){
        if ((col < 0) || (row < 0) || (col >= labirinth[0].length) || (row >= labirinth.length)) {
            return;
        }

        path[position] = direction;
        position++;

        if (labirinth[row][col] == 'M'){
            printPath(path, 1, (position-1));
        }
        if (labirinth[row][col] == ' '){
            labirinth[row][col] = 's';

            findPath(row, col - 1, 'L');
            findPath(row - 1, col, 'U');
            findPath(row, col + 1, 'R');
            findPath(row + 1, col, 'D');

            labirinth[row][col] = ' ';
        }

        position--;
    }

    private static void printPath(char[] path, int startPos, int endPos) {
        System.out.println("Found path to the exit: ");
        for (int pos = startPos; pos <= endPos; pos++) {
            System.out.println(path[pos]);
        }
        System.out.println();
    }

    public static void main(String[] args) {
//        System.out.println("Zdr");
        findPath(0,0, 'S');
    }
}
