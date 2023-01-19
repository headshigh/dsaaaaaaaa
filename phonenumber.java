import java.util.ArrayList;

public class phonenumber {

  public static void main(String[] args) {
    // numpad("", "12");
    System.out.println(numpadretReturn("", "12"));
  }

  public static void numpad(String p, String up) {
    if (up.isEmpty()) {
      System.out.println(p);
    } else {
      int digit = up.charAt(0) - '0'; //converts '2'->2
      for (int i = (digit - 1) * 3; i < digit * 3; i++) {
        char addtoP = (char) ('a' + i);
        numpad(p + addtoP, up.substring(1));
      }
    }
  }

  public static ArrayList<String> numpadretReturn(String p, String up) {
    if (up.isEmpty()) {
      ArrayList<String> list = new ArrayList<>();
      //   System.out.println(p);
      list.add(p);
      return list;
    } else {
      ArrayList<String> output = new ArrayList<>();
      int digit = up.charAt(0) - '0'; //converts '2'->2
      for (int i = (digit - 1) * 3; i < digit * 3; i++) {
        char addtoP = (char) ('a' + i);
        ArrayList<String> res = new ArrayList<>();
        res = (numpadretReturn(p + addtoP, up.substring(1)));
        output.addAll(res);
      }
      return output;
    }
  }
}
