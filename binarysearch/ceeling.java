package binarysearch;

public class ceeling {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 3, 4, 5, 7, 9 };
    System.out.println(findceeling(arr, 6));
    System.out.println(findfloor(arr, 6));
  }

  static int findceeling(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] > target) {
        end = mid - 1;
      } else if (arr[mid] < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return start;
  }

  static int findfloor(int[] arr, int target) {
    int start = 0;
    int end = arr.length - 1;
    while (start <= end) {
      int mid = start + (end - start) / 2;
      if (arr[mid] > target) {
        end = mid - 1;
      } else if (arr[mid] < target) {
        start = mid + 1;
      } else {
        return mid;
      }
    }
    return end;
  }
}
