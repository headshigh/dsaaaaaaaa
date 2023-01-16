package Sorting;

public class evendigits {

  public static void main(String[] args) {
    int[] nums = { 11, 12, 1, 3, 55 };
    System.out.println(find(nums));
  }

  static int find(int[] arr) {
    int count = 0;
    for (int num : arr) {
      if (even(num)) {
        count++;
      }
    }
    return count;
  }

  static boolean even(int num) {
    int numberofdigits = digits(num);
    return numberofdigits % 2 == 0;
  }

  static int digits(int number) {
    int count = 0;
    if (number < 0) {
      number = number * -1;
    }
    if (number == 0) {
      return 1;
    }
    while (number > 0) {
      count++;
      number = number / 10;
    }
    return count;
  }
}
