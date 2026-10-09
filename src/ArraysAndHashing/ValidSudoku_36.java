package ArraysAndHashing;

class ValidSudoku_36{
    public boolean isValidSudoku(char[][] board) {
        // Track seen numbers (1-9) for 9 rows, 9 columns, and 9 boxes
        // Using index 0 to 9 (size 10) to map digits 1-9 directly to their value index
        boolean[][] rows = new boolean[9][10];
        boolean[][] cols = new boolean[9][10];
        boolean[][] boxes = new boolean[9][10];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char current = board[i][j];

                // Skip empty cells
                if (current == '.') {
                    continue;
                }

                // Convert char digit to integer
                int val = current - '0';

                // Calculate the unique index (0-8) for the 3x3 sub-box
                int boxIdx = (i / 3) * 3 + (j / 3);

                // Check if the number already exists in the row, column, or box
                if (rows[i][val] || cols[j][val] || boxes[boxIdx][val]) {
                    return false;
                }

                // Mark the number as seen
                rows[i][val] = true;
                cols[j][val] = true;
                boxes[boxIdx][val] = true;
            }
        }

        return true;
    }
}