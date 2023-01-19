import java.util.ArrayList;

public class dicerollsum {

  public static void main(String[] args) {
    // ArrayList<Integer> demo = new ArrayList<>();
    System.out.println(findreturn("", 4, 6, 2));
    // ArrayList<String> a = new ArrayList<>();
    // a = findreturn("", 4);
    // System.out.println(a.size());
  }

  //printing list of outcomes
  public static void find(String p, int up) {
    if (up == 0) {
      System.out.println(p);
    } else {
      for (int i = 1; i <= up; i++) {
        // p.add(i);
        find(p + i, up - i);
      }
    }
  }

  //returning list of possible outcomes
  public static ArrayList<String> findreturn2(String p, int up) {
    if (up == 0) {
      //   System.out.println(p);
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    } else {
      ArrayList<String> outer = new ArrayList<>();
      for (int i = 1; i <= up; i++) {
        outer.addAll(findreturn2(p + i, up - i));
      }
      return outer;
    }
  }

  //return count of possible outcomes
  public static int findreturn(String p, int up, int face, int n) {
    if (up == 0) {
      //   System.out.println(p);
      ArrayList<String> list = new ArrayList<>();
      list.add(p);

      return list.size();
    } else {
      int x = 0;

      for (int i = 1; i <= up && i <= face; i++) {
        x += findreturn(p + i, up - i, face, n - i);
      }
      return x;
    }
  }
}
