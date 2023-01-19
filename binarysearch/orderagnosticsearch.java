package binarysearch;

public class orderagnosticsearch {

  public static void main(String[] args) {
    int[] arr = { 22, 11, 5, 4, 3, 1 };
    System.out.println(find(arr, 5));
  }

  static int find(int arr[], int target) {
    int start = 0;
    int end = arr.length - 1;
    boolean isAsc = arr[start] < arr[end];
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] == target) {
        return mid;
      }
      if (isAsc) {
        if (arr[mid] > target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      } else {
        if (arr[mid] < target) {
          end = mid - 1;
        } else {
          start = mid + 1;
        }
      }
    }
    return -1;
  }
}
