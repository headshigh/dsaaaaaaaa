package Sorting;

import java.util.Arrays;

public class searchin2darr {

  public static void main(String[] args) {
    int[][] arr = { { 2, 3, 4 }, { 1, 3, 2 }, { 2, 1, 3 } };

    System.out.println(Arrays.toString(find(arr, 8)));
  }

  public static int[] find(int[][] arr, int target) {
    for (int row = 0; row < arr.length; row++) {
      for (int col = 0; col < arr[row].length; col++) {
        if (arr[row][col] == target) {
          return new int[] { row, col };
        }
      }
    }
    return new int[] { -1, -1 };
  }

  public static int max(int[][] arr) {
    int max = Integer.MIN_VALUE;
    for (int[] ints : arr) {
      for (int element : ints) {
        if (element > max) {
          max = element;
        }
      }
    }
    return max;
  }
}
