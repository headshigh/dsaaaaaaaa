class twosum {

  public static void main(String[] args) {
    int[] array = { 1, 3, 4, 2, 5 };
    boolean y = checktwosum(array, 20);
    System.out.println(y);
  }

  public static boolean checktwosum(int[] arr, int sum) {
    boolean sumexists = false;
    for (int i = 0; i < arr.length - 2; i++) {
      for (int j = 1; j < arr.length - 1; j++) {
        if (arr[i] + arr[j] == sum) {
          sumexists = true;
        }
      }
    }
    return sumexists;
  }
}
// class twosum{
//     public static boolean checktwosum(int[] arr, sum){
//     }
// }
