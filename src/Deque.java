import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {
   private Node first;
   private Node end;
   private int num;
   
   private class Node {
     private Item item;
     private Node next;
     private Node prev;
   }
   
   public Deque() {
     first = end = null;
     num = 0;
   }
   
   public boolean isEmpty() {
     return num == 0;
   }
   
   public int size() {
     return num;
   }
   
   public void addFirst(Item item) {
    if (item == null) {
       throw new java.lang.NullPointerException("must add a no-null");
     }    
     Node oldfirst = first;
     first = new Node();
     first.item = item;
     first.prev = null;
     if (isEmpty()) {
       end = first;
       first.next = null;
     } else {
       first.next = oldfirst;
       oldfirst.prev = first;
     }
     num++;
   }
   
   public void addLast(Item item) {
     if (item == null) {
       throw new java.lang.NullPointerException("must add a no-null");
     } 
     Node oldend = end;
     end = new Node();
     end.item = item;
     end.next = null;
     if (isEmpty()) {
       first = end;
       end.prev = null;
     } else {
       oldend.next = end;
       end.prev = oldend;
     }
     num++;
     }
   
   public Item removeFirst() {
     if (num == 0) {
       throw new java.util.NoSuchElementException("remove from an empty deque");
     }
     Item itemtemp = first.item;
     num--;
     if (isEmpty()) {
       end = first = null;
     } else {
       first = first.next;
       first.prev = null;
     }
     return itemtemp;
   }
   
   public Item removeLast() {
    if (num == 0) {
       throw new java.util.NoSuchElementException("remove from an empty deque");
     }
     Item itemtemp = end.item;
     num--;
     if (isEmpty()) {
       first = end = null;
     } else {
       end = end.prev;
       end.next = null;
     }
     return itemtemp;
   }
   
   public Iterator<Item> iterator() {
     return new ListIterator();
   }
   
   private class ListIterator implements Iterator<Item> {
     private Node current = first;
     public boolean hasNext() {
       return current != null;
     }
     public Item next() {
       if (!hasNext()) {
         throw new java.util.NoSuchElementException("it's the end of deque");
       }
       Item temp = current.item;
       current = current.next;
       return temp;  
     }
     public void remove() {
       throw new java.lang.UnsupportedOperationException("no remove() implementation");
     }
   }
   
   public static void main(String[] args) {
     Deque<String> deque = new Deque<String>();
     deque.addFirst("aa");
     deque.addFirst("bb");
     deque.addFirst("cc");
     deque.addLast("dd");
     Iterator<String> iter1 = deque.iterator();
     while (iter1.hasNext()) {
      StdOut.println(iter1.next());
      }
     StdOut.print("size:"+deque.size());
   }
}