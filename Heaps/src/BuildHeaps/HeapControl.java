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
//
//   public void printFh() {
//      Node x = fh.getN();
//      while (x != null) {
//         dfs(x);
//         System.out.println("");
//         x = x.getRight();
//      }
//
//   }
//
//   public void dfs(Node x) {
//      //stays in loop sometimes -.-
//      if (x == null) {
//         return;
//      }
//      if (x.getChild() == null) {
//         System.out.println(x.getKey());
//         return;
//      }
//      Node[] childs = x.getChild();
//      int length = childsLength(childs);
//
//      System.out.print(" " + x.getKey());
//
//      if (length == -1) {
//         System.out.print(", ");
//      } else if (length > -1) {
//         System.out.print(": ");
//
//         for (int i = 0; i < length; i++) {
//            Node node = childs[i];
//            if (node == null) {
//               break;
//            }
//            dfs(node);
//         }
//
//      }
//   }
//
//   public int childsLength(Node[] list) {
//      int i = 0;
//      if (list[0] == null) {
//         return -1;
//      }
//      while (list[i] != null) {
//         if (i == list.length) {
//            return list.length - 1;
//         }
//         i++;
//      }
//      return i;
//   }
//   //print fh should be 3 staged: trees -> levels -> nodes
//
//   public void trees() {
//      Node x = fh.getN();
//      while (x != null) {
//         levels(x);
//         x = x.getLeft();
//         System.out.println("");
//         System.out.println("---");
//      }
//   }
//
//   public void levels(Node h) {
//      Node x = h;
//
//      Node[] childs = x.getChild();
//      nodes(childs, x);
//   }
//
//   public void nodes(Node[] nodes, Node p) {
//      if (nodes == null) {
//         System.out.print(p.getKey());
//      } else {
//         System.out.print(p.getKey() + ": [");
//         for (int i = 0; i < p.getC(); i++) {
//            if (nodes[i].getChild() != null) {
//               nodes(nodes[i].getChild(), nodes[i]);
//            } else {
//               System.out.print(nodes[i].getKey());
//            }
//            if (nodes[i + 1] != null) {
//               System.out.print(", ");
//            }
//
//         }
//         System.out.print("] ");
//      }
//   }
}
