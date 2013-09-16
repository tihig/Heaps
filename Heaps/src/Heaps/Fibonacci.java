package Heaps;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;

public class Fibonacci {

   private Node n;
   private int min;
   private int d;
   private Node[] root;
   private int r;
   private HeapControl hc;

   public Fibonacci(Node n) {
      this.n = n;
      this.min = n.getKey();
      this.d = 0;
      this.hc = new HeapControl();
      hc.setNode(n);
      this.root = hc.getRoot();
      this.r = hc.getR();

   }

   public Node getN() {
      return n;
   }

   public int getMin() {
      return min;
   }

   public void decrease_key(Node x, int newk) {
      if (newk < x.getKey()) {
         x.setKey(newk);
         Node parent = x.getP();
         if (parent != null && parent.getKey() > x.getKey()) {
            cut(x, parent);
            cascading_cut(parent);

         }
         if (x.getKey() < this.min) {
            cut(x, parent);
            this.min = x.getKey();
            n = x;
         }
      }
   }

   public void delete_min() {
   }

   public void insert(Node k) {
      if (min > k.getKey()) {
         k.setChild(n);
         n.setP(k);
         n = k;
      } else {
         n.setLeft(k);
         k.setRight(n);
      }

   }

// same as union!
   public void merge() {
   }

   public void consolidate() {
      Node A[] = new Node[256];
      Node x = n;
      while (x != null) {
//         Node x = root[i];
         int d = x.getDegree();
         Node y = x;
         while (A[d] != null) {
            if (y != x && y.getDegree() == x.getDegree()) {
               if (x.getKey() > y.getKey()) {
                  Node yLeft = y.getLeft();
                  Node yRight = y.getRight();
                  y.setLeft(x.getLeft());
                  y.setRight(x.getRight());
                  x.setLeft(yLeft);
                  x.setRight(yRight);

//                  int s = y.getPlace();
//                  y.setPlace(x.getPlace());
//                  x.setPlace(s);
               }
               link(y, x);
               A[d] = null;
               d = d + 1;
            }
            y = y.getLeft();
         }
         A[d] = x;
         x = x.getLeft();

      }
      min = 0;
   }

   public void cut(Node x, Node parent) {
      parent.getChild()[x.getPlace()] = null;
      x.setP(null);
      x.setMark(false);
      if (parent.getLeft() != null) {
         parent.getLeft().setRight(x);
         x.setLeft(parent.getLeft());
         parent.setLeft(x);
         x.setRight(parent);
         parent.getChild()[x.getPlace()] = null;
      }
      parent.setLeft(x);
      x.setRight(parent);
   }

   public void cascading_cut(Node x) {
      Node z = x.getP();
      if (z != null) {
         if (!x.isMark()) {
            x.setMark(true);
         } else {
            cut(x, z);
            cascading_cut(z);
         }
      }
   }

   public int extract_min() {
//      Node z = n;
//      if (z.getChild() != null) {
//      }
      return 0;
   }

   public void link(Node y, Node x) {
      Node yLeft = y.getLeft();
      Node yRight = y.getRight();

      y.setLeft(null);
      y.setRight(null);

      if (yRight != null) {
         yLeft.setRight(yRight);
      }
      
      if (yLeft != null) {
         yRight.setLeft(yLeft);
      }

      x.setChild(y);
      y.setP(x);

      x.setDegree(x.getDegree() + 1);
      y.setMark(false);

   }
}
