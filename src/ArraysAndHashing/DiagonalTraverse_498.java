package ArraysAndHashing;

import java.util.ArrayList;
import java.util.List;

class DiagonalTraverse_498{
    public int[] findDiagonalOrder(int[][] mat) {
        // Handle empty matrix edge case
        if (mat == null || mat.length == 0 || mat[0].length == 0) {
            return new int[0];
        }

        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[m * n];

        int row = 0, col = 0;
        boolean up = true; // Flag to track direction: true = up-right, false = down-left

        for (int i = 0; i < m * n; i++) {
            result[i] = mat[row][col];

            if (up) {
                // Moving Up-Right
                if (col == n - 1) {
                    // Hit the right boundary: move down to next row, change direction
                    row++;
                    up = false;
                } else if (row == 0) {
                    // Hit the top boundary: move right to next column, change direction
                    col++;
                    up = false;
                } else {
                    // Normal step up-right
                    row--;
                    col++;
                }
            } else {
                // Moving Down-Left
                if (row == m - 1) {
                    // Hit the bottom boundary: move right to next column, change direction
                    col++;
                    up = true;
                } else if (col == 0) {
                    // Hit the left boundary: move down to next row, change direction
                    row++;
                    up = true;
                } else {
                    // Normal step down-left
                    row++;
                    col--;
                }
            }
        }
        return result;
    }
}
