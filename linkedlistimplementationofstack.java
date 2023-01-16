import static java.lang.System.exit;

class stackusinglinkedlist {

  private class Node {

    int data;
    Node link;
  }

  //global top reference
  Node top;

  stackusinglinkedlist() {
    this.top = null;
  }

  public void push(int x) {
    Node temp = new Node();
    // if(temp==null){
    //     System.out.println("heap oveflow");
    // }
    temp.data = x;
    temp.link = top;
    top = temp;
  }

  public void pop() {
    if (top == null) {
      System.out.println("stack underflow");
    }
    top = top.link;
  }

  public void display() {
    if (top == null) {
      System.out.println("empty");
      exit(1);
    }
    Node temp2 = top;
    while (temp2 != null) {
      System.out.println(temp2.data);
      if (temp2.link != null) {
        System.out.println("-->");
      }

      temp2 = temp2.link;
    }
  }
}

class gfg {

  public static void main(String[] args) {
    stackusinglinkedlist s = new stackusinglinkedlist();
    s.push(1);
    s.push(1);
    s.push(1);
    s.push(1);
    s.pop();
    s.display();
  }
}
