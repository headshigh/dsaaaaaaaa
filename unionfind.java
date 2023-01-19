public class unionfind {

  public int[] id;

  public unionfind(int N) {
    id = new int[N];
    for (int i = 0; i < N; i++) {
      id[i] = i;
    }
  }

  private int root(int i) {
    while (i != id[i]) {
      i = id[i];
    }
    return i;
  }

  public boolean connected(int p, int q) {
    return root(p) == root(q);
  }

  public void union(int p, int q) {
    int i = root(p);
    int j = root(q);
    id[i] = root(q); //first no ko root ko id ma second number ko root halne i.e first ko root lai second number ko root banaunne
  }
}

class testttt {

  public static void main(String[] args) {
    unionfind a = new unionfind(6);
    System.out.println(a.connected(1, 2));
    a.union(1, 2);
    System.out.println(a.connected(1, 2));
    System.out.println(a.id);
  }
}
