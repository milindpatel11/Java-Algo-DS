public class WeightedQuickUnionUF {

  private int[] ids;
  private int[] sizes;
  private int count;

  public WeightedQuickUnionUF (int N) {
    count = N;
    ids = new int[N];
    sizes = new int[N];
    for (int i=0; i<N; i++) ids[i]=i;
    for (int i=0; i<N; i++) sizes[i]=1;
  }

  public int count () { return count; }

  public boolean connected (int x, int y) {
    return find(x) == find(y);
  }

  public int find (int x) {
    while (x != ids[x]) x = ids[x];
    return x;
  }

  public void union (int x, int y) {
    int i = find(x);
    int j = find(y);
    if (i == j )return;

    //if i and j not same
    if (sizes[i] > sizes[j]) { ids[i] = j ; sizes[j] += sizes[i] ;}
    else {ids[j] = i; sizes[i] += sizes[j];}
    count--;
  }

  // test client

  public static void main (String args[]) {
    int N = StdIn.readInt();

    WeightedQuickUnionUF wquf = new WeightedQuickUnionUF(N);

    while (!StdIn.isEmpty()) {
      int x = StdIn.readInt();
      int y = StdIn.readInt();
      if (wquf.connected(x,y)) {System.out.println(x + " " + y + " already connected") ; continue;}
      wquf.union(x, y);
      System.out.println(x + " " + y + " just connected");
    }

    System.out.println( wquf.count + " conneted components");

  }


}
