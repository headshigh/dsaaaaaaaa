public class binarysearchrecursion {

  public static void main(String[] args) {
    int[] arr = { 1, 1, 2, 3, 5 };
    System.out.println(search(arr, 3, 0, arr.length - 1));
  }

  public static int search(int[] arr, int target, int s, int e) {
    int mid = s + (e - s) / 2;
    if (s > e) {
      return -2;
    } else {
      if (target == arr[mid]) {
        return mid;
      }
      if (target < arr[mid]) {
        return search(arr, target, s, mid - 1);
      } else {
        return search(arr, target, mid + 1, e);
      }
    }
  }
}
