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
      Node n = new Node(null, 0, k);
      n.setLeft(new Node(null, 0, Integer.MAX_VALUE));
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
      bh.checkCapasity(bh.getHeap(), bh.getHeap_size());
      int[] heap = bh.getHeap();
      int h = 0;
      int x = heap[0];


      int i = 1;
      int j = 0;
      while (x != Integer.MAX_VALUE) {
         i--;
         if (bh.left(h) < bh.getHeap_size() && heap[bh.left(h)] != Integer.MAX_VALUE) {
            System.out.print("_");
            j++;
         } else {
            System.out.print(" ");
         }
         System.out.print(x);
         if (bh.right(h) < bh.getHeap_size() && heap[bh.right(h)] != Integer.MAX_VALUE) {
            System.out.print("_");
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

   public void printFh() {
      Node x = fh.getN();
      while (x != null) {
         dfs(x);
         System.out.println("");
         x = x.getRight();
      }

   }

   public void dfs(Node x) {
      //stays in loop sometimes -.-
      if (x == null) {
         return;
      }
      if (x.getChild() == null) {
         System.out.println(x.getKey());
         return;
      }
      Node[] childs = x.getChild();
      int length = childsLength(childs);

      System.out.print(" " + x.getKey());

      if (length == -1) {
         System.out.print(", ");
      } else if (length > -1) {
         System.out.print(": ");

         for (int i = 0; i < length; i++) {
            Node node = childs[i];
            if (node == null) {
               break;
            }
            dfs(node);
         }

      }
   }

   public int childsLength(Node[] list) {
      int i = 0;
      if (list[0] == null) {
         return -1;
      }
      while (list[i] != null) {
         if (i == list.length) {
            return list.length - 1;
         }
         i++;
      }
      return i;
   }
   //print fh should be 3 staged: trees -> levels -> nodes

   public void trees() {
      Node x = fh.getN();
      while (x != null) {
         levels(x);
         x = x.getLeft();
         System.out.println("---");
      }
   }

   public void levels(Node h) {
      Node x = h;
      nodes(null,x);
      while(x != null){
         Node[] childs = x.getChild();
         if(childs != null){
            nodes(childs,x);
         }
         for (int i = 0; i < x.getC(); i++) {
            Node y = childs[i];
            Node[] yChilds = y.getChild();
            if(yChilds != null){
               nodes(yChilds,y);
            }
            
         }
         x = x.getLeft();
         System.out.println("");
      }
   }

   public void nodes(Node[] nodes, Node p) {
      if (nodes == null) {
         System.out.println(p.getKey());
      } else {
         for (int i = 0; i < p.getC(); i++) {
            System.out.print(nodes[i].getKey() + " ,");
         }
      }
   }
}
