public class SelectionSort {

  // common helper methods - start
  public static boolean less (Comparable x, Comparable y) {
    return x.compareTo(y) < 0;
  }

  public static void exchange (Comparable[] a, int i, int j) {
    Comparable temp = a[i];
    a[i] = a[j];
    a[j] = temp;
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

  // Sort specific methods.
  public static void sort(Comparable[] a) {
    int N = a.length;
    int exch = 0;
    for (int i=0; i<N; i++) {
      int min = i;
      for (int j = i+1; j<N; j++ ) if (less(a[j], a[min])) min = j;
      exchange(a, i, min);
      exch ++;
      // ??? if (i != min) {exchange(a, i, min); exch ++}
    }

    System.out.println( exch + " Exchanged made");
  }


  // test client

  public static void main (String[] args) {
    String[] a = StdIn.readStrings();
    sort(a);
    System.out.println("Is Sorted? " + isSorted(a));
    // assert isSorted(a);
    show(a);
  }

  // NOTE : Comparable type works without custom compareTo method for primitive types
  // and a few non-primitive types such as String, file and URL . Other objets might need custome compareTo



}
