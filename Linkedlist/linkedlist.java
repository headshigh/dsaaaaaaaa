package Linkedlist;

public class linkedlist {

  private Node head = null;
  private Node tail = null;
  private int size;

  public linkedlist() {
    this.size = 0;
  }

  public void insertLast(int val) {
    Node node = new Node(val);
    if (head == null && tail == null) {
      head = tail = node;
      head.next = null;
    } else {
      tail.next = node;
      tail = node;
    }
    size++;
  }

  public void insertFirst(int val) {
    Node node = new Node(val);
    if (head == null && tail == null) {
      head = node;
      tail = node;
      node.next = null;
      size++;
    } else {
      node.next = head;
      head = node;
      size++;
    }
  }

  //insert at a given index
  public void insert(int val, int index) {
    if (index == 0) {
      insertFirst(val);
      return;
    }
    if (index == size) {
      insertLast(val);
      return;
    }
    Node node = new Node(val);
    Node temp = head;
    for (int i = 1; i < index; i++) {
      temp = temp.next;
    }
    Node x = temp.next;
    temp.next = node;
    node.next = x;
    size++;
  }

  public int deletefirst() {
    if (head == null && tail == null) {
      System.out.println("stack underflow");
      return -1;
    }
    int temp = head.value;
    head = head.next;
    size--;
    return temp;
  }

  public Node get(int index) {
    Node temp = head;
    for (int i = 1; i < index; i++) {
      temp = temp.next;
    }
    return temp;
  }

  //insert using recursion
  public void insertRec(int value, int index) {
    head = insertRec(value, index, head);
  }

  private Node insertRec(int val, int index, Node node) {
    if (index == 0) { //base case,index ko value suru dekhi ghatdai gayera hamilai chiye jati vako cha
      //hamilai tyo index ko node ko agadi naya node thapnu parne huncha jun node le tyehi node lai point gareko huncha
      //create a new node parameter node has the value for current node
      Node temp = new Node(val);
      temp.next = node;
      size++;
      return temp;
    }
    node.next = insertRec(val, index - 1, node.next);
    return node;
  }

  public int deleteLast() {
    if (size <= 1) {
      return deletefirst();
    }
    Node secondlast = get(size - 2); //index starts from zero
    Node last = secondlast.next;
    int temp = last.value;
    secondlast.next = null;
    return temp;
  }

  public void display() {
    Node temp = head;
    while (temp != null) {
      System.out.print(temp.value + "->");
      temp = temp.next;
    }
    System.out.println("end");
  }

  //same cha vane pointer lai agadi na badaune
  public void remDuplicate() {
    Node pointer = head;

    while (pointer.next != null) {
      Node temp = pointer.next;
      if (temp.value == pointer.value) {
        pointer.next = temp.next;
      } else {
        pointer = pointer.next;
      }
    }
    // while (pointer != null) {
    //   Node temp = pointer.next;
    //   if (pointer.value == temp.value) {
    //     if (temp.next == null) {
    //       pointer.next=temp.next;
    //     } else {
    //       pointer.next = temp.next;
    //       pointer = pointer.next;
    //     }
    //   }
    //  }
  }

  private class Node {

    private int value;
    private Node next;

    public Node(int value) {
      this.value = value;
    }
  }
}
