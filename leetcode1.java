public class leetcode1 {

  public static void main(String[] args) {
    int arr1[] = { 1, 2, 3 };
    int arr2[] = { 3, 4 };
    int[] res = merge(arr1, 3, arr2, 3);
    for (int i = 0; i < res.length; i++) {
      System.out.println(res[i]);
    }
  }

  public static int[] merge(int[] nums1, int m, int[] nums2, int n) {
    int[] arr = new int[nums1.length + nums2.length];
    int i = 0;
    int j = 0;
    int k = 0;

    while (i < nums1.length && j < nums2.length) {
      if (nums1[i] < nums2[j]) {
        arr[k] = nums1[i];
        i++;
      } else {
        arr[k] = nums2[j];
        j++;
      }
      k++;
    }
    while (i < nums1.length) {
      arr[k] = arr[i];
      i++;
      k++;
    }
    while (j < nums2.length) {
      arr[k] = arr[j];
      j++;
      k++;
    }
    return arr;
  }
}
