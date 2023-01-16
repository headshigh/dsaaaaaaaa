package isArraySortedw;

import java.util.ArrayList;

public class isaelementinarray {

  public static void main(String[] args) {
    int[] arr = { 1, 3, 2, 4, 3, 5 };
    System.out.println(find(arr, 5, 0));
    ArrayList<Integer> ans = findAllIndex1(arr, 3, 0, new ArrayList<>());
    System.out.println(ans);
    System.out.println(list);
    // findAllIndex(arr, 3, 0);
    // System.out.println(list); //somehow not working
    ArrayList<Integer> answithoutpassargument = findAllIndex2(arr, 3, 0);
    System.out.println(answithoutpassargument);
  }

  public static boolean find(int[] arr, int target, int index) {
    if (index == arr.length) {
      return false;
    } else {
      return arr[index] == target || find(arr, target, index + 1);
    }
  }

  public static int findIndex(int[] arr, int target, int index) {
    if (index == arr.length) {
      return -1;
    }
    if (arr[index] == target) {
      return index;
    } else {
      return findIndex(arr, target, index + 1);
    }
  }

  static ArrayList<Integer> list = new ArrayList<>();

  public static void findAllIndex(int[] arr, int target, int index) {
    if (index == arr.length) {
      return;
    }
    if (arr[index] == target) {
      list.add(index);
    }
    findIndex(arr, target, index + 1);
  }

  public static ArrayList<Integer> findAllIndex1(
    int[] arr,
    int target,
    int index,
    ArrayList<Integer> listx
  ) {
    if (index == arr.length) {
      return listx;
    }
    if (arr[index] == target) {
      listx.add(index);
    }

    return findAllIndex1(arr, target, index + 1, listx);
  }

  //,while passing a list as argument in every function call new reference variables listx were created that were pointing to the same object listx so once the value of listx was updated i.e list.add() in any children functions all the functions will have the updated values
  // but when we donot pass a list as a argument and initialize it inside function body program \ will  have to create new objects of list for every function call whose value will be limited to that function only
  public static ArrayList<Integer> findAllIndex2(
    int[] arr,
    int target,
    int index
  ) {
    ArrayList<Integer> List = new ArrayList<>();
    if (index == arr.length) {
      return List;
    }
    if (arr[index] == target) {
      List.add(index);
    }

    ArrayList<Integer> answerfrombelow =
      (findAllIndex2(arr, target, index + 1));
    List.addAll(answerfrombelow);
    return List;
  }
}
