// import java.util.Arrays;

public class Nqueens {

  public static void main(String[] args) {
    boolean board[][] = {
      { false, false, false, false },
      { false, false, false, false },
      { false, false, false, false },
      { false, false, false, false },
    };
    // boolean board2[][] = {
    //   { true, true, true, true },
    //   { true, true, true, true },
    //   { true, true, true, true },
    //   { true, true, true, true },
    // };
    // int x = (solution(board, 0));
    // System.out.println(x);
    knights(board, 0, 0, 4);
  }

  public static int solution(boolean[][] board, int row) {
    if (row == board.length) {
      display(board);
      System.out.println();
      return 1;
    }

    int count = 0;
    for (int i = 0; i < board.length; i++) {
      if (isSafe(board, row, i)) {
        board[row][i] = true;
        count += solution(board, row + 1);
        board[row][i] = false;
      }
    }
    return count;
  }

  private static void display(boolean[][] board) {
    for (boolean[] row : board) {
      for (boolean element : row) {
        if (element) {
          System.out.print("Q ");
        } else {
          System.out.print("X ");
        }
      }
      System.out.println();
    }
  }

  private static void display2(boolean[][] board) {
    for (boolean[] row : board) {
      for (boolean element : row) {
        if (element) {
          System.out.print("K ");
        } else {
          System.out.print("X ");
        }
      }
      System.out.println();
    }
  }

  public static boolean isSafe(boolean[][] board, int row, int column) {
    for (int i = 0; i < row; i++) {
      if (board[i][column]) {
        return false;
      }
    }
    int maxLeft = Math.min(row, column);
    int maxRight = Math.min(row, board.length - column - 1);
    //for diagonal left
    for (int i = 1; i <= maxLeft; i++) {
      if (board[row - i][column - i]) {
        return false;
      }
    }
    for (int i = 1; i <= maxRight; i++) {
      if (board[row - i][column + i]) {
        return false;
      }
    }
    return true;
  }

  //N knights
  public static void knights(
    boolean[][] board,
    int row,
    int column,
    int knights
  ) {
    if (knights == 0) {
      display2(board);
      System.out.println();
      return;
    }
    if (row == board.length - 1 && column == board.length) {
      return;
    }
    if (column == board.length) {
      knights(board, row + 1, 0, knights);
      return;
    }
    if (isSafeknights(board, row, column)) {
      board[row][column] = true;
      knights(board, row, column + 1, knights - 1);
      board[row][column] = false;
    }
    knights(board, row, column + 1, knights);
  }

  public static boolean isSafeknights(boolean[][] board, int row, int column) {
    if (isValid(board, row - 2, column - 1)) {
      if (board[row - 2][column - 1]) {
        return false;
      }
    }

    if (isValid(board, row - 1, column - 2)) {
      if (board[row - 1][column - 2]) {
        return false;
      }
    }

    if (isValid(board, row - 2, column + 1)) {
      if (board[row - 2][column + 1]) {
        return false;
      }
    }

    if (isValid(board, row - 1, column + 2)) {
      if (board[row - 1][column + 2]) {
        return false;
      }
    }

    return true;
  }

  static boolean isValid(boolean[][] board, int row, int col) {
    if (row >= 0 && row < board.length && col >= 0 && col < board.length) {
      return true;
    }
    return false;
  }
}
