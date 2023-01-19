import javax.swing.text.StyledEditorKit.BoldAction;

public class palindrome {

  public static void main(String[] args) {
    boolean x = checkPalindrome("1000030001");
    System.out.println(x);
  }

  public static boolean checkPalindrome(String s) {
    boolean x = true;
    s = s.toLowerCase();
    if (s == null || s.length() == 0) {
      return true;
    }
    for (int i = 0; i < (s.length()) / 2; i++) {
      if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
        System.out.println(s.charAt(i));
        System.out.println(s.charAt(s.length() - 1 - i));
        x = false;
        break;
      }
    }
    return x;
  }
}
