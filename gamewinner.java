import java.util.Arrays;
import java.util.Collections;

public class gamewinner {

  public static void main(String[] args) {
    Integer[] array = { 1, 5, 233, 7 };
    System.out.println(winner(0, 0, array, 1));
    // System.out.println(findIndex(array, 4));
  }

  public static boolean winner(
    int player1,
    int player2,
    Integer[] arr,
    int turn
  ) {
    // System.out.println(Arrays.asList(arr));
    if (arr.length == 0) { //base condition
      if (player1 > player2 || player1 == player2) {
        return true;
      }
      return false;
    } else {
      if (turn % 2 != 0) {
        //i.e it is playerone's turn even
        int maxValue = Math.max(arr[0], arr[arr.length - 1]);
        int index = 0;
        if (maxValue == arr[0]) {
          index = 0;
        }
        if (maxValue == arr[arr.length - 1]) {
          index = arr.length - 1;
        }
        // System.out.println(index);
        return winner(
          player1 + maxValue,
          player2,
          index == arr.length - 1
            ? Arrays.copyOfRange(arr, 0, arr.length - 1)
            : Arrays.copyOfRange(arr, 1, arr.length), //suru ko lai linch last ko lai linna
          turn + 1
        );
      } else {
        int maxValue = Math.max(arr[0], arr[arr.length - 1]);
        int index = 0;
        if (maxValue == arr[0]) {
          index = 0;
        }
        if (maxValue == arr[arr.length - 1]) {
          index = arr.length - 1;
        }

        return winner(
          player1,
          player2 + maxValue,
          index == arr.length - 1
            ? Arrays.copyOfRange(arr, 0, arr.length - 1)
            : Arrays.copyOfRange(arr, 1, arr.length),
          turn + 1
        );
      }
    }
  }
}
