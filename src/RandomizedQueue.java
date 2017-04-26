import edu.princeton.cs.algs4.*;
import java.util.Iterator;

public class RandomizedQueue<Item> implements Iterable<Item> {
   private int size;
   private int num;
   private Item[] item;
   public RandomizedQueue() {
     size = 1;
     num = 0;
     item = (Item[]) new Object[size];     
   }     
               
   public boolean isEmpty() {
     return num == 0;
   }
   
   public int size() {
     return num;
   }
   
   private void resizing(int new_size) {
     Item[] new_item = (Item[]) new Object[new_size];
     for (int i = 0; i < num; i++) {
       new_item[i] = item[i];
     } 
     size = new_size;
     item = new_item;
   }
   
   public void enqueue(Item additem) {
     if (additem == null) {
     throw new java.lang.NullPointerException("please add a no-null item");
     }
     if (size == num) {
       resizing(size * 2);
     } 
     item[num] = additem;
     num++;
   }
   
   public Item dequeue() {
     if (isEmpty()) {
       throw new java.util.NoSuchElementException("queue is empty");
     }
     if (num == size / 4) {
       resizing(size / 2);
     }
      StdRandom.shuffle(item, 0, num);
      Item temp =  item[num - 1];
      item[num -1] = null;
      num--;
      return temp;
   }
     
   public Item sample() {
     if (isEmpty()) {
       throw new java.util.NoSuchElementException("queue is empty");
     } 
     return item[StdRandom.uniform(0, num)];
    }
    
   public Iterator<Item> iterator() {
     return new ArrayIterator();
   }
   
   private class ArrayIterator implements Iterator<Item> {
     private int current = 0;
     private Item[] iter_item;
     public ArrayIterator() {
       iter_item = (Item[]) new Object[item.length];
       for(int i = 0; i < item.length; i++) {
         iter_item[i] = item[i];
       }
       if(num != 0 ) {     
         StdRandom.shuffle(iter_item, 0, num);
       }
     }
     public void remove() {
       throw new java.lang.UnsupportedOperationException("remove");
     }
     public boolean hasNext() {
       return current != num;
     }
     public Item next() {
       if (current >= num) {
         throw new java.util.NoSuchElementException("no next");
       }
       return iter_item[current++];
     }
   }
   
  /* private class ArrayIterator implements Iterator<Item> {
     private int current = 0;
     public ArrayIterator() {
       if (num != 0) {     
         StdRandom.shuffle(item, 0, num);
       }
     }
     public void remove() {
       throw new java.lang.UnsupportedOperationException("remove");
     }
     public boolean hasNext() {
       return current != num;
     }
     public Item next() {
       if (current >= num) {
         throw new java.util.NoSuchElementException("no next");
       }
       return item[current++];
     }
   }*/
  
   public static void main(String[] args) {
       RandomizedQueue<String> deque = new RandomizedQueue<String>();
      deque.dequeue();
      // deque.enqueue("aa");
      // deque.enqueue("bb");
       // deque.enqueue("cc");
      // deque.enqueue("dd");
      /* Iterator<String> iter = deque.iterator();
       StdOut.println(iter.next());
       deque.dequeue();
       StdOut.println(iter.next());*/
       // StdOut.println(deque.dequeue());
      //StdOut.println(deque.dequeue());
      // StdOut.println(deque.dequeue());
       // StdOut.println(deque.dequeue());
       // deque.dequeue();
       StdOut.print("size:"+deque.size());
   }
}