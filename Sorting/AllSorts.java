import java.time.Instant;
import  java.time.Duration;

public class AllSorts {

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

  public static Comparable[] resetArray (Comparable[] a) {
    Comparable[] b = new String[a.length];
    for (int i=0; i<a.length; i++) b[i] = a[i];
    return b;
  }

  public static void selectionSort(Comparable[] a) {
    int N = a.length;
    int exch = 0;

    Instant start = Instant.now();

    for (int i=0; i<N; i++) {
      int min = i;
      for (int j = i+1; j<N; j++ ) if (less(a[j], a[min])) min = j;
      exchange(a, i, min);
      exch ++;
      // ??? if (i != min) {exchange(a, i, min); exch ++}
    }
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Selection Sort: "+ exch + " Exchanges made in " + timeElapsed + "ms");
  }

  public static void insertionSort(Comparable[] a) {
    int N = a.length;
    int exch = 0;

    Instant start = Instant.now();

    for (int i = 1; i < N; i++) {
      for (int j = i; j > 0 && less(a[j], a[j-1]); j--)
        exchange(a, j, j-1);
        exch++;
    }

    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Insertion Sort: " +  exch + " Exchanges made in " + timeElapsed + "ms");
  }

  public static void shellSort (Comparable[] a) {
    int N = a.length;
    int exch = 0;
    int h = 1;
    while (h < N/3) h = h*3 + 1;

    Instant start = Instant.now();
    // CODE HERE

    // outer loop for all h values till 1
    while (h >= 1) {
      // h-sort outer loop
      for (int i = h; i < N; i++) {
        // checking and exhanging within given h inner loop
        for (int j = i; j >= h && less(a[j], a[j-h]); j -= h)
          {exchange(a, j, j-h); exch++;}
        // end inner loop for given h
      }
      // end outer h loop
      h = h / 3;
    }
    // end loop for all h values
    Instant finish = Instant.now();
    long timeElapsed = Duration.between(start, finish).toMillis();
    System.out.println("Shell Sort: " + exch + " Exchanges made in " + timeElapsed + "ms");
  }

  // test client

  public static void main (String[] args) {
    String[] a = StdIn.readAllStrings();
    Comparable[] b;
    //Selection Sort
    b = resetArray(a);
    selectionSort(b);
    // System.out.println(a.length);
    System.out.println("Is Selection Sorted? " + isSorted(b));
    // assert isSorted(a);
    // show(b);

    //Insetion Sort
    b = resetArray(a);
    insertionSort(b);
    System.out.println("Is Insertion Sorted? " + isSorted(b));
    // assert isSorted(a);
    // show(b);

    //Shell Sort
    b = resetArray(a);
    shellSort(b);
    System.out.println("Is Shell Sorted? " + isSorted(b));
    // assert isSorted(a);
    // show(b);

    //Merge Sort - Need the MergeSort file in same directory
    b = resetArray(a);
    Instant startmerge = Instant.now();
    MergeSort.sort(b);
    Instant finishmerge = Instant.now();
    long timeElapsedmerge = Duration.between(startmerge, finishmerge).toMillis();
    System.out.println("Merge Sort: Sort made in " + timeElapsedmerge + "ms");
    System.out.println("Is Merge Sorted? " + isSorted(b));
    // assert isSorted(a);
    // show(b);

  }

  // NOTE : Comparable type works without custom compareTo method for primitive types
  // and a few non-primitive types such as String, file and URL . Other objets might need custome compareTo

}
