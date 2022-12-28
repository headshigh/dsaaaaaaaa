package isArraySortedw;

import java.util.ArrayList;

public class isaelementinarray {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 4, 3, 5 };
    System.out.println(find(arr, 5, 0));
    System.out.println(findAllIndex(arr, 5, 0));
    System.out.println(findAllIndex(arr, 5, 0));
  }

  public static boolean find(int[] arr, int target, int index) {
    if (index == arr.length) {
      return false;
    } else {
      return arr[index] == target || find(arr, target, index + 1);
    }
  }

  public static int findIndex(int[] arr, int target, int index) {
    if (index == arr.length) {
      return -1;
    }
    if (arr[index] == target) {
      return index;
    } else {
      return findIndex(arr, target, index + 1);
    }
  }

  static ArrayList<Integer> list = new ArrayList<>();

  public static void findAllIndex(int[] arr, int target, int index) {
    if (index == arr.length) {
      return;
    }
    if (arr[index] == target) {
      list.add(index);
    } else {
      findIndex(arr, target, index + 1);
    }
  }

  public static ArrayList<Integer> findAllIndex1(
    int[] arr,
    int target,
    int index,
    ArrayList<Integer> listx
  ) {
    if (index == arr.length) {
      return listx;
    }
    if (arr[index] == target) {
      listx.add(index);
    } else {
      return findAllIndex1(arr, target, index + 1, listx);
    }
  }
}
