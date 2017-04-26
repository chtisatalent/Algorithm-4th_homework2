import edu.princeton.cs.algs4.*;

public class Permutation {
   public static void main(String[] args) {
      int num = Integer.parseInt(args[0]);
      RandomizedQueue<String> a = new RandomizedQueue<String>();
      while(!StdIn.isEmpty()){
        a.enqueue(StdIn.readString());
      }
      for (int i = 0; i < num ; i++) {
        StdOut.println(a.dequeue());
      }
      
   }
  
}
