package binarysearch;

public class binarysearch {

  public static void main(String[] args) {
    int[] arr = { 1, 24, 4, 6, 5, 4, 5, 6, 11, 33, 44, 22 };
    System.out.println(search(arr, 44));
  }

  static int search(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (target < arr[mid]) {
        end = mid - 1;
      } else if (target > arr[mid]) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}
