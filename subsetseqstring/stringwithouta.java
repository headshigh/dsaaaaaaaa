package subsetseqstring;

public class stringwithouta {

  public static void main(String[] args) {
    withouta("", "afafdedv");
  }

  public static void withouta(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
      return;
    } else {
      char first = up.charAt(0);
      if (first == 'a') {
        withouta(p, up.substring(1));
      } else {
        withouta(p + first, up.substring(1));
      }
    }
  }
}
