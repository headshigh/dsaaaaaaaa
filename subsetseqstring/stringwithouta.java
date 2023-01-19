package subsetseqstring;

public class stringwithouta {

  public static void main(String[] args) {
    // withouta("", "afafdedv");
    skipstring("", "askfapple");
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

  public static void skipstring(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
      return;
    } else {
      if (up.startsWith("apple")) {
        skipstring(p, up.substring(5));
      } else {
        skipstring(p + up.charAt(0), up.substring(1));
      }
    }
  }
}
