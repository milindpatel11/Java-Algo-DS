import java.util.Iterator;

//
public class Queue <Item> implements Iterable <Item> {

  private Node first;
  private Node last;
  private int N;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty() {return first == null;}

  public int size () { return N; }

  public void enqueue (Item item) {
    Node oldLast = last;
    last = new Node();
    last.item = item;
    last.next = null;
    if (isEmpty()) first = last; // checking for empty situation
    else oldLast.next = last;
    N++;
  }

  public Item dequeue () {
    Item item = first.item;
    first = first.next;
    N--;
    if (isEmpty()) last = null; // checking for empty situation
    return item;
  }

  // Iterator relted code
  public Iterator<Item> iterator ()
  { return new FIFOIterator();}

  //
  private class FIFOIterator implements Iterator<Item>
  {
    private Node current = first;

    public boolean hasNext() { return current != null;}

    public void remove () { }

    public Item next() {
      Item item = current.item;
      current = current.next;
      return item;
    }

  }

  // Iterator relted code - END


  //  --------------------- Test Client --------------------------

  public static void main (String[] args) {

    Queue<String> q = new Queue<String>();

    while (!StdIn.isEmpty())
     {
       String item = StdIn.readString();
       if (!item.equals("-")) q.enqueue(item);
       else if (!q.isEmpty()) System.out.print( q.dequeue() + " ");
     }


    System.out.println( "(" + q.size() + " left on the Queue)");


    // using iterator - 1 : did not work when missing <Item> in "implements Iterable<Item> { " in fitsl line
    for ( String str : q) {
      System.out.print( str + " ");
    }
    System.out.println();
    System.out.println( "(" + q.size() + " left on the Queue)");

    // Using iterator - 2 : code found from online for java's stack implementation?
    Iterator val = q.iterator();
    while (val.hasNext()) System.out.print(val.next() + " ");

    System.out.println( "(foreach construct  and" + q.size() + " left on the Queue)");

    // Using iterator - 2  -- need to use another variable and iterator if want to iterate again
    Iterator valAgain = q.iterator();
    while (valAgain.hasNext()) System.out.print(valAgain.next() + " ");

    System.out.println( "(while construct  and " + q.size() + " left on the Queue)");


    // *** DOES NOT WORK -- Using iteration????
    // for (Node x = first ; x != null; x = x.next) {
    //   System.out.println(x.item + " ");
    // }

  }

}
