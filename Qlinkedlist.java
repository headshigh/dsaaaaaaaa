class linkedlist {

  int data;
  linkedlist next;

  public linkedlist(int x) {
    data = x;
    next = null;
  }
}

public class Qlinkedlist {

  linkedlist front;
  linkedlist rear;

  public Qlinkedlist() {
    front = rear = null;
  }

  public void enq(int x) {
    linkedlist temp = new linkedlist(x);
    if (front == null) {
      front = rear = temp;
      return;
    } else {
      rear.next = temp;
      rear = temp;
    }
  }

  public void deque() {
    if (front == null) {
      System.out.println("Q is empty");
      return;
    }
    linkedlist temp = front; //retriving value from first position;
    front = front.next;
    if (this.front == null) this.rear = null;
  }
}

class tst {

  public static void main(String[] args) {
    Qlinkedlist a = new Qlinkedlist();
    a.enq(5);
    a.enq(4);
    a.enq(4);
    a.enq(5);
    a.deque();
    System.out.println(a.front.data);
    System.out.println(a.rear.data);
  }
}
