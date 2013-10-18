package BuildHeaps;

import Heaps.Binary;
import Heaps.Fibonacci;

public class HeapControl {

   private Fibonacci fh;
   private Binary bh;

   public HeapControl() {
      this.fh = null;
      this.bh = null;
   }

   public Node buildHeap(int k) {
      Node n = new Node( k);
      return n;
   }

   public Fibonacci getFh() {
      return fh;
   }

   public Binary getBh() {
      return bh;
   }

   public void setFh(Fibonacci fh) {
      this.fh = fh;
   }

   public void setBh(Binary bh) {
      this.bh = bh;
   }

   public void printBh() {
      if (bh == null) {
         return;
      }
      bh.moreLength();
      int[] heap = bh.getHeap();
      int h = 0;
      int x = heap[0];


      int i = 1;
      int j = 0;
      while (x != Integer.MAX_VALUE) {
         i--;
         if (bh.left(h) < heap.length && heap[bh.left(h)] != Integer.MAX_VALUE) {
            System.out.print("_");
            j++;
         } else {
            System.out.print(" ");
         }
         System.out.print(x);
         if (bh.right(h) < heap.length && heap[bh.right(h)] != Integer.MAX_VALUE) {
            System.out.print("_ ");
            j++;
         } else {
            System.out.print(" ");
         }

         if (i == 0) {
            System.out.println("");
            i = j;
            j = 0;
         }
         h++;
         if (h >= heap.length) {
            break;
         }
         x = heap[h];
      }
   }

//   //print fh should be 3 staged: trees -> levels -> nodes

   public void trees() {
      Node x = fh.getN();
      while (x != null) {
         levels(x);
         x = x.getLeft();
         System.out.println("");
         System.out.println("---");
      }
   }

   public void levels(Node h) {
      Node x = h;

      Node[] childs = x.getChild_List();
      nodes(childs, x);
   }

   public void nodes(Node[] nodes, Node p) {
      if (nodes == null) {
         System.out.print(p.getKey());
      } else {
         System.out.print(p.getKey() + ": [");
         for (int i = 0; i <= p.getChild_length(); i++) {
            if (nodes[i].getChild_List() != null) {
               nodes(nodes[i].getChild_List(), nodes[i]);
            } else {
               System.out.print(nodes[i].getKey());
            }
            if (nodes[i + 1] != null) {
               System.out.print(", ");
            }

         }
         System.out.print("] ");
      }
   }
}
