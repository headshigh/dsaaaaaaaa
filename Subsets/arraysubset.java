package Subsets;

import java.util.ArrayList;

public class arraysubset {

  public static void main(String[] args) {
    // subset("", "abcd");
    ArrayList<String> a = subsetRet("", "ad");
    System.out.println(a);
  }

  public static void subset(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
      return;
    }
    char a = up.charAt(0);
    subset(p + a, up.substring(1));
    subset(p, up.substring(1));
  }

  public static ArrayList<String> subsetRet(String p, String up) {
    ArrayList<String> list = new ArrayList<>();
    if (up.isEmpty()) {
      list.add(p);
      return list;
    } else {
      char a = up.charAt(0);
      ArrayList<String> left = subsetRet(p + a, up.substring(1));
      ArrayList<String> right = subsetRet(p, up.substring(1));
      left.addAll(right);
      return left;
    }
  }
}
