import java.util.ArrayList;
import java.util.Arrays;

public class counting_path_maze {

  public static void main(String[] args) {
    // System.out.println(maze(3, 3)); //not diagonally
    boolean board[][] = {
      { true, true, true },
      { true, true, true },
      { true, true, true },
    };
    int route[][] = new int[board.length][board[0].length];

    pathRestrictionAlldirectionpathprint("", board, 0, 0, route, 1);
    // System.out.println(mazeretdiagonally("", 3, 3)); //diaagonallyreturn list
  }

  public static int maze(int row, int column) {
    if (row == 1 || column == 1) {
      return 1;
    } else {
      return maze(row - 1, column) + maze(row, column - 1);
    }
  }

  public static ArrayList<String> mazeret(String p, int row, int column) {
    if (row == 1 && column == 1) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    ArrayList<String> outer = new ArrayList<>();
    if (row > 1) {
      outer.addAll(mazeret(p + 'D', row - 1, column));
    }
    if (column > 1) {
      outer.addAll(mazeret(p + 'R', row, column - 1));
    }
    return outer;
  }

  public static ArrayList<String> mazeretdiagonally(
    String p,
    int row,
    int column
  ) {
    if (row == 1 && column == 1) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    }
    ArrayList<String> outer = new ArrayList<>();
    if (row > 1 && column > 1) {
      //diagonally pani jana diyo vane row ra column duitai ghatcha
      outer.addAll(mazeretdiagonally(p + 'd', row - 1, column - 1));
    }
    if (row > 1) {
      outer.addAll(mazeretdiagonally(p + 'D', row - 1, column));
    }
    if (column > 1) {
      outer.addAll(mazeretdiagonally(p + 'R', row, column - 1));
    }
    return outer;
  }

  //we are increasing the value of row or column with recursion here but can do like previous times
  static void pathRestriction(String p, boolean[][] maze, int row, int column) {
    if (row == maze.length - 1 && column == maze[0].length - 1) {
      System.out.println(p);
    }
    if (!maze[row][column]) {
      return;
    }
    if (row < maze.length - 1) {
      pathRestriction(p + "D", maze, row + 1, column);
    }
    if (column < maze[0].length - 1) {
      pathRestriction(p + "R", maze, row, column + 1);
    }
  }

  static void pathRestrictionAlldirection(
    String p,
    boolean[][] maze,
    int row,
    int column
  ) {
    if (row == maze.length - 1 && column == maze[0].length - 1) {
      System.out.println(p);
    }
    if (!maze[row][column]) {
      return;
    }
    maze[row][column] = false;
    //set the cell false to indicate it has been visited for that recursion call
    if (row < maze.length - 1) {
      pathRestrictionAlldirection(p + "D", maze, row + 1, column);
    }
    if (column < maze[0].length - 1) {
      pathRestrictionAlldirection(p + "R", maze, row, column + 1);
    }
    if (row > 0) {
      pathRestrictionAlldirection(p + "U", maze, row - 1, column);
    }
    //0 1 2
    //1 * *
    //2 * *
    if (column > 0) {
      pathRestrictionAlldirection(p + "U", maze, row, column - 1);
    }
    //this is the line where the function gets removed so also restore all the changes
    maze[row][column] = true;
  }

  //we get into endless loop with moving in all direction we could keep moving up and down up and down within same cells that couuld lead to stack overflow. thus to prevent this we mark F to the cell once it is visited so we cannot go to the same cell again for the same recursion call but we need to restore the initial condition
  //when we come are coming back of recursion calls and value has been returned we store the initial values of the cell we mark f while going ahead and T when going back.

  static void pathRestrictionAlldirectionpathprint(
    String p,
    boolean[][] maze,
    int row,
    int column,
    int[][] path,
    int step
  ) {
    if (row == maze.length - 1 && column == maze[0].length - 1) {
      System.out.println(p);
      path[row][column] = step;
      for (int[] arr : path) {
        System.out.println(Arrays.toString(arr));
        System.out.println();
      }
      maze[row][column] = false;
      return;
    }
    if (!maze[row][column]) {
      return;
    }
    maze[row][column] = false;
    path[row][column] = step;
    //set the cell false to indicate it has been visited for that recursion call

    if (row < maze.length - 1) {
      pathRestrictionAlldirectionpathprint(
        p + "D",
        maze,
        row + 1,
        column,
        path,
        step + 1
      );
    }
    if (column < maze[0].length - 1) {
      pathRestrictionAlldirectionpathprint(
        p + "R",
        maze,
        row,
        column + 1,
        path,
        step + 1
      );
    }
    if (row > 0) {
      pathRestrictionAlldirectionpathprint(
        p + "U",
        maze,
        row - 1,
        column,
        path,
        step + 1
      );
    }
    //0 1 2
    //1 * *
    //2 * *
    if (column > 0) {
      pathRestrictionAlldirectionpathprint(
        p + "L",
        maze,
        row,
        column - 1,
        path,
        step + 1
      );
    }
    //this is the line where the function gets removed so also restore all the changes

    maze[row][column] = true;
    path[row][column] = 0;
  }

  static void pathAlldirectionsCopy(
    String p,
    int row,
    int column,
    boolean[][] maze,
    int[][] path,
    int count
  ) {
    // count = 0;
    if (row == maze.length - 1 && column == maze[0].length - 1) {
      System.out.println(p);
      path[row][column] = count;
      for (int[] arr : path) {
        System.out.println(Arrays.toString(arr));
      }
      maze[row][column] = false;
      return;
    }
    maze[row][column] = false;
    if (!maze[row][column]) {
      return;
    }
    if (column > maze[0].length - 1) {
      pathAlldirectionsCopy(p + "R", row, column + 1, maze, path, count + 1);
    }
    if (row > maze.length - 1) {
      pathAlldirectionsCopy(p + "D", row + 1, column, maze, path, count + 1);
    }
    if (row > 1) {
      pathAlldirectionsCopy(p + "U", row - 1, column, maze, path, count + 1);
    }
    if (column > 1) {
      pathAlldirectionsCopy(p + "L", row, column - 1, maze, path, count + 1);
    }

    maze[row][column] = true;
    path[row][column] = 0;
  }
}
