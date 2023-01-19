public class fibonacci {

  public static void main(String[] args) {
    int x = fibo(4);
    System.out.println(fibo(6));
  }

  public static int fibo(int n) {
    if (n == 0) {
      return 0;
    }
    if (n == 1) {
      return 1;
    }
    return fibo(n - 1) + fibo(n - 2);
  }
}
