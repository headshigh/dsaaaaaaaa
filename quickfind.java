class QuickFindUF {

  // 0 1 2 3 4 5 6 is the p and q
  // [1,2,3,3,5,6] pids and qids
  private int[] id;

  public QuickFindUF(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  public boolean connected(int p, int q) { //check wether p and q are in the same component
    return id[p] == id[q];
  }

  public void union(int p, int q) { //change all entries with id[p] to id[q]
    int pid = id[p];
    int qid = id[q];
    for (int i = 0; i < id.length; i++) {
      if (id[i] == pid) {
        id[i] = qid;
      }
    }
  }
}

class test1 {

  public static void main(String[] args) {
    QuickFindUF a = new QuickFindUF(9);
    a.union(4, 5);

    System.out.println(a.connected(3, 4));
    System.out.println(a.connected(4, 5));
  }
}
