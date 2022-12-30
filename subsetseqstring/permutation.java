package subsetseqstring;

public class permutation {

  public static void main(String[] args) {
    findPermutation("", "ab");
    String a = "hello";
    System.out.println(swap(a, 0, 4));
  }

  public static void findPermutation(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
    } else {
      char first = 'a';
      for (int i = 0; i < up.length(); i++) {
        if (up.length() == 1) {
          first = up.charAt(0);
        } else {
          char toswap = up.charAt(i);
          first = up.charAt(0);
          //swap with the first index; such that first simultaneously holds value for each element in up
          char temp = up.charAt(0);
          first = toswap;
          toswap = temp;
          swap(up, 0, i);
        }

        findPermutation(p + first, up.substring(1));
      }
    }
  }

  static char[] swap(String str, int i, int j) {
    char ch[] = str.toCharArray();
    char temp = ch[i];
    ch[i] = ch[j];
    ch[j] = temp;
    return ch;
  }
}
