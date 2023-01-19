public class bubbleusingrecur {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 4, 1 };
    sort(arr, 0, 0);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  public static void sort(int[] arr, int row, int col) {
    int temp;
    // for (int i = 0; i < arr.length; i++) {
    //   System.out.println(arr[i]);
    // }

    if (row >= arr.length - 1) {
      return;
    }
    if (col > arr.length - 2) {
      sort(arr, row + 1, 0);
    } else {
      if (arr[col] > arr[col + 1]) {
        temp = arr[col];
        arr[col] = arr[col + 1];
        arr[col + 1] = temp;
      }
      sort(arr, row, col + 1);
    }
  }
}
