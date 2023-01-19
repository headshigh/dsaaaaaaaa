package isArraySortedw;

import java.util.Arrays;

public class recursion {

  public static void main(String[] args) {
    int[] arr = { 1, 1, 3, 3, 5, 6 };
    boolean y = checksorted(arr, 0);
    System.out.println(y);
  }

  public static boolean checksorted(int[] arr, int i) {
    if (i == arr.length - 1) {
      return true;
    } else {
      return (
        arr[i] < arr[i + 1] &&
        checksorted(Arrays.copyOfRange(arr, i, arr.length - 1), i + 1)
      );
    }
  }
}
