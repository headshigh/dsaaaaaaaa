package binarytree;

//using array
public class treeimplementation {

  public static void main(String[] args) {
    Array_imp a = new Array_imp();
    a.Root("A");
    a.set_left("B", 0);
    a.set_right("C", 0);
    a.set_left("D", 1);
    a.print_tree();
  }
}

class Array_imp {

  static int root = 0;
  static String[] str = new String[10];

  public void Root(String key) {
    str[0] = key;
  }

  public void set_left(String key, int root) {
    int t = (2 * root) + 1;
    if (str[root] == null) {
      System.out.println("can't set child coz parent not found");
      return;
    }
    str[t] = key;
  }

  public void set_right(String key, int root) {
    int t = (2 * root) + 2;
    if (str[root] == null) {
      System.out.println("can't set child coz parent not found");
      return;
    }
    str[t] = key;
  }

  public void print_tree() {
    for (int i = 0; i < str.length; i++) {
      if (str[i] != null) {
        System.out.println(str[i]);
      } else {
        System.out.println("-");
      }
    }
  }
}
