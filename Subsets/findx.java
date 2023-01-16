package Subsets;

public class findx {

  public static void main(String[] args) {
    System.out.println(findsubstring("", " ", 0));
    String up = " ";
    System.out.println(up.charAt(0));
  }

  public static int findsubstring(String p, String up, int count) {
    if (up.isEmpty()) {
      // System.out.println(p);
      return count;
    }
    if (up == " ") {
      return 1;
    }
    if (!p.isEmpty() && hasAnyChar(p, up.charAt(0))) {
      int newcount = p.length();
      if (newcount > count) {
        count = newcount;
      }
      p = "";
    }
    return findsubstring(p + up.charAt(0), up.substring(1), count);
  }

  public static boolean hasAnyChar(String tocompare, char a) {
    for (int i = 0; i < tocompare.length(); i++) {
      if (tocompare.charAt(i) == a) {
        return true;
      }
    }
    return false;
  }
  //subsequence nikalee yar
  // public static void main(String[] args) {
  //   System.out.println(find("", "adfaaaajkk"));
  // }

  // public static int find(String p, String up) {
  //   if (hasEverychar(p, up) || up.length() == 0) {
  //     System.out.println(p); //p has every character that up has
  //     return p.length();
  //   } else {
  //     if (p.indexOf((up.charAt(0))) == -1) {
  //       p = p + up.charAt(0);
  //     }
  //     return find(p, up.substring(1));
  //   }
  // }

  // public static boolean hasEverychar(String tocompare, String target) {
  //   for (int i = 0; i < target.length(); i++) {
  //     if (tocompare.indexOf(target.charAt(i)) == -1) {
  //       return false;
  //     }
  //   }
  //   return true;
  // }
}
