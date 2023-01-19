package Linkedlist;

public class Main {

  public static void main(String[] args) {
    linkedlist list = new linkedlist();
    // list.insertLast(7);
    // list.insertFirst(5);
    list.insertLast(5);
    list.insertLast(5);
    list.insertLast(5);
    list.insertLast(4);
    list.insertLast(4);
    // list.insertLast(5);
    // list.insert(6, 1);
    // list.deleteLast();
    // list.insertRec(4, 2);
    // list.insertRec(4, 1);
    list.remDuplicate();
    list.display();
  }
}
