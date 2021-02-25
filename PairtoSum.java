import java.util.Arrays;

public class PairtoSum {

  // findpairs method.. This method ignores some duplicates..
  // Can we make better method that take all pairs??
  public  static void findPairs (int [] a, int sum) {
     int lo = 0;
     int  hi = a.length - 1;
     int pairs = 0;

     while (lo < hi) {
       if (a[lo] + a[hi] == sum) {
         System.out.println( "Pair for sum " + sum + " is " + a[lo] + " " + a[hi]);
         pairs ++;
       }

       if (a[lo] + a[hi] > sum) hi -- ;
       else lo ++; // lo++ if sum equals or less than equal (this is the reason why ignores some duplicates)

     }
     System.out.println( pairs + " pairs found" );
  }


  public static void show (int[] a) {
    for (int i = 0; i < a.length; i++ ) {
      System.out.print(a[i] + " ");
      System.out.println();
    }
  }



  public static void main (String [] args) {
    int sum = Integer.parseInt(args[0]);

    // ****  Making random array but does not count repeated pairs
    // int size = Integer.parseInt(args[1]);    // Making random array but does not count repeated pairs
    // int [] array = new int [size];

    // for (int i = 0; i < size; i++ ) {
    //   int r = (int) ( Math.random() * size );
    //   array[i] = r ;
    // }
    // *****

    // ** Using test array
    int [] array = { 2, 4, 1, 6, -3, 0, 7}; // Test array

    Arrays.sort(array);
    show(array);
    findPairs(array, sum);


  }
}
