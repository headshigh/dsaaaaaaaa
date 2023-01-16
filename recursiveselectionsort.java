public class recursiveselectionsort {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 4, 1 };
    sort(arr, arr.length, 0, 0);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void sort(int[] arr, int r, int c, int max) { //max as index
    if (r == 0) {
      return;
    }
    if (r > c) {
      if (arr[c] > arr[max]) {
        sort(arr, r, c + 1, c);
      } else {
        sort(arr, r, c + 1, max);
      }
    } else {
      int temp = arr[max];
      arr[max] = arr[r - 1];
      arr[r - 1] = temp;
      sort(arr, r - 1, 0, 0);
    }
  }
}
