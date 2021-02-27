public class MergeSort {

  private static Comparable[] aux;

  // ** common helper methods - start
  public static boolean less (Comparable x, Comparable y) {
    return x.compareTo(y) < 0;
  }

  public static void show (Comparable [] a) {
    int N = a.length;
    for (int i = 0; i < N; i++ ) System.out.print( a[i] + " ");
    System.out.println();
  }

  public static boolean isSorted (Comparable [] a) {
    int N = a.length;
    for (int i=1; i<N; i++) {
      if (less(a[i], a[i-1])) return false;
    }
    return true;
  }
  // common helper methods - end

  // ** Reseting / copying from unsorted array before applying different sorting method
  public static Comparable[] resetArray (Comparable[] a) {
    Comparable[] b = new String[a.length];
    for (int i=0; i<a.length; i++) b[i] = a[i];
    return b;
  }

  // ** merge method --

  public static void merge (Comparable[] a, int lo, int mid, int hi) {
    int i =lo;
    int j = mid+1;

    for (int k = lo; k <= hi; k++) aux[k] = a[k];

    for (int k = lo; k <= hi; k++) {
      if (i > mid) a[k] = aux[j++];
      else if (j > hi) a[k] = aux[i++];
      else if (less(aux[j], aux[i])) a[k] = aux[j++];
      else a[k] = aux[i++];
    }

  }

  // ** Sort specific methods.

  public static void sort (Comparable []a ) {
    aux = new Comparable[a.length];
    // int exch = 0;
    sort(a, 0, a.length-1) ;
  }

  public static void sort(Comparable[] a, int lo, int hi) {
    if (hi <= lo) return; // included hi ???
    int mid = lo + (hi - lo) / 2;
    sort(a, lo, mid);
    sort(a, mid+1, hi);
    merge(a, lo, mid, hi); // merge initializes   mid+1
  }

  // ** Non-recursive  Bottomup Merge
  public static void sortBU (Comparable[]a) {
    int N = a.length;
    aux = new Comparable [N];

    // outer  loop for sz 1, 2, 4
    for (int sz = 1; sz < N; sz = sz+sz) {
      // inner loop for particular sz value to traverse the array
      for (int lo = 0; lo < N - sz; lo += sz + sz)
          merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1) );
    }
  }


  // ****** test client ********

  public static void main (String[] args) {
    Comparable[] a = StdIn.readAllStrings();

    Comparable[] b;
    //** Recursive Merge Sort
    b = resetArray(a);
    sort(b);
    System.out.println("Is Sorted? " + isSorted(b));
    // assert isSorted(a);
    // show(b);

    //** Bottom up Merge Sort
    b = resetArray(a);
    sortBU(b);
    System.out.println("Is Bottom up Sorted? " + isSorted(b));
    // assert isSorted(a);
    // show(b);
  }

  // NOTE : Comparable type works without custom compareTo method for primitive types
  // and a few non-primitive types such as String, file and URL . Other objets might need custome compareTo



}
