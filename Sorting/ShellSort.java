public class ShellSort {

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
  public static void sort (Comparable[] a) {
    int N = a.length;
    int exch = 0;
    int h = 1;
    while (h < N/3) h = h*3 + 1;
    System.out.println( h + " Initial h");
    // outer loop for all h values till 1
    while (h >= 1) {
      System.out.println( "while loop as h is greater than 0");
      // h-sort outer loop
      for (int i = h; i < N; i++) {
        // checking and exhanging within given h inner loop
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
          {exchange(a, j, j-h); exch++;}
        // end inner loop for given h
      }
      // end outer h loop
      h = h / 3;
      System.out.println( h + " changed h");
    }
    // end loop for all h values
    System.out.println( exch + " Exchanges made");
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
