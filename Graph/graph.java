package Graph;

import java.util.ArrayList;

public class graph {

  public static void main(String[] args) {
    int n = 3;
    int m = 3;
    ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
    for (int i = 0; i <= n; i++) {
      list.add(new ArrayList<Integer>());
    }
    //2---3
    list.get(2).add(3);
    list.get(3).add(2);
  }
}
