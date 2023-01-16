package Subsets;

import java.util.ArrayList;
import java.util.List;

public class iterativeForSubsequence {

  public static void main(String[] args) {
    int[] arr = { 1, 2, 2 };
    // System.out.println(subset(arr));
    System.out.println(subsetcopy(arr));
  }

  public static List<List<Integer>> subset(int[] arr) {
    List<List<Integer>> outer = new ArrayList<>();
    outer.add(new ArrayList<>());
    for (int num : arr) {
      int n = outer.size();
      for (int i = 0; i < n; i++) {
        List<Integer> internal = new ArrayList<>(outer.get(i));
        internal.add(num);
        outer.add(internal);
        // System.out.println(internal);
      }
    }
    return outer;
  }

  public static List<List<Integer>> subsetcopy(int[] arr) {
    List<List<Integer>> outer = new ArrayList<>();
    outer.add(new ArrayList<>());
    int start = 0;
    int end = 0;
    for (int i = 0; i < arr.length; i++) {
      //if current elemetn a nd previous element is same s=e+1;
      start = 0;
      if (i > 0 && arr[i] == arr[i - 1]) {
        start = end + 1;
      }
      end = outer.size() - 1;
      int n = outer.size();
      for (int j = start; j < n; j++) {
        List<Integer> internal = new ArrayList<>(outer.get(j));
        internal.add(i);
        outer.add(internal);
        // System.out.println(internal);
      }
    }
    return outer;
  }
}
