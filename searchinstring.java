public class searchinstring {

  public static void main(String[] args) {
    System.out.println(search("hess", 'c'));
  }

  static boolean search(String str, char target) {
    if (str.length() == 0) {
      return false;
    }
    for (int i = 0; i < str.length(); i++) {
      if (str.charAt(i) == target) {
        return true;
      }
    }
    return false;
  }
}
