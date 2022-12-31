import java.util.ArrayList;

public class dicerollsum {

  public static void main(String[] args) {
    ArrayList<Integer> demo = new ArrayList<>();
    find(demo, 4, 4);
  }

  public static void find(ArrayList<Integer> p, int up, int end) {
    if (up == 0) {
      System.out.println(p);
    } else {
      for (int i = 0; i < up; i++) {
        p.add(i);
        find(p, end - i, end);
      }
    }
  }
}
