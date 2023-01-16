package binarysearch;

public class infinitearray {

  //we cannot use array.length functionn we have to search for the target in chunks and if the number lies in that range we have to perform binary search operation;
  public static void main(String[] args) {
    int arr[] = {
      1,
      2,
      3,
      4,
      5,
      6,
      7,
      8,
      10,
      11,
      12,
      22,
      33,
      44,
      55,
      66,
      77,
      78,
    };
    System.out.println(search(arr, 7));
  }

  public static int search(int[] arr, int target) {
    int start = 0;
    int end = 1;
    while (target > arr[end]) {
      int temp = end + 1; //new start;
      end = end + (end - start + 1) * 2; //prevend+sizeof prev range*2
      start = temp;
    }
    return binarysearch(arr, start, end, target);
  }

  public static int binarysearch(int[] arr, int start, int end, int target) {
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
