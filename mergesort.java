import java.util.Arrays;

class Mergesort {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 4, 5, 2, 3 };

    arr = mergesort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  static int[] mergesort(int[] arr) {
    if (arr.length == 1) {
      return arr;
    }
    int mid = arr.length / 2;
    int[] left = mergesort(Arrays.copyOfRange(arr, 0, mid));
    int[] right = mergesort(Arrays.copyOfRange(arr, mid, arr.length));
    return merge(left, right);
  }

  public static int[] merge(int[] first, int[] second) {
    int[] mix = new int[first.length + second.length];
    int i = 0;
    int j = 0;
    int k = 0;
    while (i < first.length && j < second.length) {
      if (first[i] < second[j]) {
        mix[k] = first[i];
        i++;
      } else {
        mix[k] = second[j];
        j++;
      }
      k++;
    }
    //if any of the array gets empty we just put the remaining elements in the mix from non empty array
    while (i < first.length) {
      mix[k] = first[i];
      i++;
      k++;
    }
    while (j < second.length) {
      mix[k] = second[j];
      j++;
      k++;
    }
    return mix;
  }
}
