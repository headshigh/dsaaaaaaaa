package subsetseqstring;

import java.util.ArrayList;

public class permutation {

  public static void main(String[] args) {
    // findPermutation("", "bcd");
    System.out.println(findPermutationretList("", "bcd"));
    // String a = "hello";
    // System.out.println(swap(a, 0, 4));
  }

  public static ArrayList<String> findPermutationretList(String p, String up) {
    if (up.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      list.add(p);
      return list;
    } else {
      char first = 'a';
      ArrayList<String> output = new ArrayList<>();
      for (int i = 0; i < up.length(); i++) {
        if (up.length() == 1) {
          first = up.charAt(0);
        } else {
          //   char toswap = up.charAt(i);
          //   first = up.charAt(0);
          //swap with the first index; such that first simultaneously holds value for each element in up
          up = swap(up, 0, i);
          first = up.charAt(0);
          //   char temp = up.charAt(0);
          //   first = toswap;
          //   toswap = temp;
        }

        ArrayList<String> result = findPermutationretList(
          p + first,
          up.substring(1)
        );
        output.addAll(result);
      }
      return output;
    }
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
          //   char toswap = up.charAt(i);
          //   first = up.charAt(0);
          //swap with the first index; such that first simultaneously holds value for each element in up
          up = swap(up, 0, i);
          first = up.charAt(0);
          //   char temp = up.charAt(0);
          //   first = toswap;
          //   toswap = temp;
        }
        findPermutation(p + first, up.substring(1));
      }
    }
  }

  public static String swap(String a, int i, int j) {
    char temp;
    char[] charArray = a.toCharArray();
    temp = charArray[i];
    charArray[i] = charArray[j];
    charArray[j] = temp;
    return String.valueOf(charArray);
  }
}
