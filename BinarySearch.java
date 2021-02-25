import java.util.Arrays;

public class BinarySearch{

  public static int rank (int key, int[] a) {
    int lo = 0;
    int hi = a.length -1;

    while (lo <= hi) {
      int mid = lo + (hi-lo)/2;
      if (key < a[mid]) hi = mid - 1;
      else if (key > a[mid]) lo = mid + 1;
      else return mid;
    }
    return -1;
  }


  public static void main (String[] args) {
    int key = Integer.parseInt(args[0]);
    int[] whitelist = StdIn.readInts();

    int position = rank(key, whitelist);

    if (position == -1) System.out.println(key + " Does not exist in list");
    else System.out.println(key + " exist in list at position " + position);
  }

}
