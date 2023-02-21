class A {

  public void display() {
    System.out.println("Hello");
  }
}

class B extends A {

  public static void main(String[] args) {
    B bobj = new B();
    bobj.display();
  }
}
