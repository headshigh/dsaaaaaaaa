class binarySearch {

  public int[] a;

  public int binarySearch1(int[] a, int key) {
    int lo = 0, hi = a.length - 1;
    while (lo <= hi) {
      int mid = lo + (hi - lo) / 2;
      if (key < a[mid]) {
        hi = mid - 1;
      }
      if (key > a[mid]) {
        lo = mid + 1;
      } else {
        return mid;
      }
    }
    return -1;
  }
}

class testtttt {

  // int a[]=new int [20];

  public static void main(String[] args) {
    int arr[] = { 12, 13, 14, 15, 14, 44, 55, 66, 77, 88, 99, 00, 22 };
    binarySearch a = new binarySearch();
    System.out.println(a.binarySearch1(arr, 14));
  }
}
