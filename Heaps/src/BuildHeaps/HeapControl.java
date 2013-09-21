package BuildHeaps;

import Heaps.Binary;
import Heaps.Fibonacci;

public class HeapControl {

   private Node f;
   private Fibonacci fh;
   private Binary bh;

   public HeapControl() {
      this.fh = null;
      this.bh = null;
//      Node f = new Node(null, null, 0);
   }

   public Node buildHeap(int k) {
      return new Node(null, 0, k);
   }

   public void setFh(Fibonacci fh) {
      this.fh = fh;
   }

   public void setBh(Binary bh) {
      this.bh = bh;
   }

//   public long[] insertTimeComparison() {
//      long[] values = new long[2];
//      Node insert = new Node(null, 0, 1);
//      long time = System.currentTimeMillis();
//      for (int i = 0; i < 10; i++) {
//         bh.insert(i);
//      }
//      long time2 = System.currentTimeMillis();
//      values[0] = time2 - time;
//
//
//      time = System.currentTimeMillis();
//      for (int i = 0; i < 10; i++) {
//         insert.setKey(i);
//         fh.insert(insert);
//      }
//      time2 = System.currentTimeMillis();
//      values[1] = time2 - time;
//
//      return values;
//   }

}
