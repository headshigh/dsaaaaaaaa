public class selectionsort {

  public static void main(String[] args) {
    int[] arr = { 1, 4, 5, 3, 2, 1 };
    sort(arr);
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }

  //minimum value lai array ko first ma rakhne ani next time tyo first part lai exclude garera array ko aru elements ma loop garne ani min find garne ani teslai tyo naya array ko first index ma rakhne

  public static void sort(int[] arr) {
    for (int i = 0; i < arr.length - 1; i++) {
      int minimum = arr[i];
      for (int j = i + 1; j < arr.length; j++) {
        if (arr[j] < minimum) {
          int temp = arr[j];
          arr[j] = arr[i];
          arr[i] = temp;
        }
      }
    }
  }
}
