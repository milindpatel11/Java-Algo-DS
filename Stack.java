import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

  private Node first;
  private int N;

  private class Node {
    Item item;
    Node next;
  }

  public boolean isEmpty () { return first == null; }
  public int size () { return N; }

  public void push (Item item) {
    Node oldFirst = first;
    first = new Node();
    first.item = item;
    first.next = oldFirst;
    N++;
  }

  public Item pop () {
    Item item = first.item;
    first = first.next;
    N--;
    return item;
  }

  // Iterator related code
  public Iterator<Item> iterator ()
  { return new LIFOIterator();}

  //
  private class LIFOIterator implements Iterator<Item>
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

    Stack<String> s = new Stack<String>();

    while (!StdIn.isEmpty())
     {
       String item = StdIn.readString();
       if (!item.equals("-")) s.push(item);
       else if (!s.isEmpty()) System.out.print( s.pop() + " ");
     }


    System.out.println( "(" + s.size() + " left on the Stack)");

    // using iterator - 1 : did not work when missing <Item> in "implements Iterable<Item> { " in fitsl line
    for ( String str : s) {
      System.out.print( str + " ");
    }
    System.out.println( "(foreach construct  and " + s.size() + " left on the Stack)");

    // Using iterator - 2 : code found from online for java's stack implementation?
    Iterator val = s.iterator();
    while (val.hasNext()) System.out.print(val.next() + " ");
    System.out.println( "(while construct  and " + s.size() + " left on the Stack)");

    // *** DOES NOT WORK -- iterating ??
    // for (Node x = first ; x != null; x = x.next) {
    //   System.out.println(x.item + " ");
    // }

  }

}
