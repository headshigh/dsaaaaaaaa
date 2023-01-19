class sorting {

  void insertionsortfunc(int arr[]) {
    int N = arr.length;
    int temp;
    for (int i = 0; i < N - 1; i++) {
      for (int j = i + 1; j > 0; j--) {
        if (arr[j] < arr[j - 1]) {
          temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
        } else {
          break;
        }
      }
    }
  }

  void bubblesort(int arr[]) {
    //compares two adjacent values of the array and swaps if prior one is larges than later,doing this, in the first pass the largest element goes to the last and with every pass the next largest element will sit at it's position.
    //things are  sorted from the last
    int temp;
    boolean swapped = false;
    for (int i = 0; i < arr.length - 1; i++) {
      for (int j = 1; j < arr.length; j++) {
        if (arr[j] < arr[j - 1]) {
          //swap the values
          temp = arr[j];
          arr[j] = arr[j - 1];
          arr[j - 1] = temp;
          swapped = true;
        }
      }
      if (!swapped) { //if we didnow swap any values for any value of i it means that the array is sorted
        break;
      }
    }
  }

  public void display(int arr[]) {
    for (int i = 0; i < arr.length; i++) {
      System.out.println(arr[i]);
    }
  }
}

class tssst {

  public static void main(String[] args) {
    int arr[] = { 1, 4, 5, 2, 4, 1, 5, 4 };
    sorting a = new sorting();
    // a.insertionsortfunc(arr);
    a.bubblesort(arr);
    a.display(arr);
  }
}
/*for(int i=o;i<N-2;i++){
   for(int j=i+1;j>0;j--){
     if(arr[j]<arr[i]){
      temp=arr[i];
      arr[i]=arr[j];
      arr[j]=temp;
   }
   break;
   } 
   
}
 */
