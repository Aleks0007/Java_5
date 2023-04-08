class QueensProblem {
    private static final int BOARD_SIZE = 8;

    public static void main(String[] args) {
        int[][] board = new int[BOARD_SIZE][BOARD_SIZE];
        solveQueensProblem(board, 0);
        printBoard(board);
    }

    private static boolean solveQueensProblem(int[][] board, int colIndex) {
        if (colIndex == BOARD_SIZE) {
            return true; // all queens are placed
        }

        for (int rowIndex = 0; rowIndex < BOARD_SIZE; rowIndex++) {
            if (isPlaceValid(board, rowIndex, colIndex)) {
                board[rowIndex][colIndex] = 1;
                if (solveQueensProblem(board, colIndex + 1)) {
                    return true;
                }
                board[rowIndex][colIndex] = 0; // backtrack
            }
        }

        return false; // no valid position found
    }

    private static boolean isPlaceValid(int[][] board, int rowIndex, int colIndex) {
        for (int i = 0; i < colIndex; i++) {
            if (board[rowIndex][i] == 1) {
                return false; // there is a queen in the same row
            }
        }

        for (int i = rowIndex, j = colIndex; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false; // there is a queen in the same diagonal
            }
        }

        for (int i = rowIndex, j = colIndex; i < BOARD_SIZE && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false; // there is a queen in the same diagonal
            }
        }

        return true;
    }

    private static void printBoard(int[][] board) {
        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                System.out.print(board[i][j] == 1 ? "x " : "0 ");
            }
            System.out.println();
        }
    }
}