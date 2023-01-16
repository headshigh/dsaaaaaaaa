public class printtriangle {

  public static void main(String[] args) {
    print(3, 0);
  }

  public static void print(int row, int column) {
    if (row == 0) {
      return;
    }
    if (row > column) {
      print(row, column + 1);
      System.out.print("*");
      //  print(row, column + 1); //this line would be active and above will be disabled to print inverted triangle because the execution of line below that function only takes place once the functionn has been resolved.
    } else {
      print(row - 1, 0);
      System.out.println();
      // print(row - 1, 0); // //this line would be active and above will be disabled to print inverted triangle
    }
  }
}
