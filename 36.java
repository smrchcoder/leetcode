class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int r = 0; r < 9; r++) {
            if (!isValidRow(board, r)) {
                return false;
            }
        }
        for (int c = 0; c < 9; c++) {
            if (!isValidColumn(board, c)) {
                return false;
            }
        }
        for (int r = 0; r < 9; r += 3) {
            for (int c = 0; c < 9; c += 3) {
                if (!isValidSquare(board, r, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isValidRow(char[][] board, int r) {
        Map<Character, Integer> row = new HashMap<>();
        for (int c = 0; c < 9; c++) {
            if (board[r][c] == '.') {
                continue;
            }
            if (row.containsKey(board[r][c])) {
                return false;
            }
            row.put(board[r][c], 1);
        }
        return true;
    }

    public boolean isValidColumn(char[][] board, int c) {
        Map<Character, Integer> column = new HashMap<>();
        for (int r = 0; r < 9; r++) {
            if (board[r][c] == '.') {
                continue;
            }
            if (column.containsKey(board[r][c])) {
                return false;
            }
            column.put(board[r][c], 1);
        }
        return true;
    }

    public boolean isValidSquare(char[][] board, int r, int c) {
        Map<Character, Integer> matrix = new HashMap<>();
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] == '.') {
                    continue;
                }
                if (matrix.containsKey(board[i][j])) {
                    return false;
                }
                matrix.put(board[i][j], 1);
            }
        }
        return true;
    }
}

// class Solution {
// public boolean isValidSudoku(char[][] board) {
// Set<String> seen = new HashSet<>();
// for (int r = 0; r < 9; r++) {
// for (int c = 0; c < 9; c++) {
// char num = board[r][c];
// if (num == '.')
// continue;

// // Create unique strings for row, column, and box
// String rowKey = num + " in row " + r;
// String colKey = num + " in col " + c;
// String boxKey = num + " in box " + (r / 3) + "-" + (c / 3);

// // Check if any of these keys already exist in the set
// if (!seen.add(rowKey) || !seen.add(colKey) || !seen.add(boxKey)) {
// return false;
// }
// }
// }
// return true;
// }

// }
