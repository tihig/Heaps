package Heaps;

import BuildHeaps.Node;

public class Fibonacci {

   private Node n;
   private int min;
   private int d;

   public Fibonacci(Node n) {
      this.n = n;
      this.min = n.getKey();
      this.d = 0;
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
   public void delete(Node x){
      decrease_key(x,Integer.MIN_VALUE);
      extract_min();
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

   public void consolidate() {
      Node A[] = new Node[256];
      Node x = n;
      while (x != null) {
         int degree = x.getDegree();
         while (A[degree] != null) {
            Node y = A[degree];
            if (x.getKey() > y.getKey()) {
               Node yLeft = y.getLeft();
               Node yRight = y.getRight();
               y.setLeft(x.getLeft());
               y.setRight(x.getRight());
               x.setLeft(yLeft);
               x.setRight(yRight);
            }
            link(y, x);
            A[degree] = null;
            degree = degree + 1;

         }
         A[degree] = x;
         x = x.getLeft();
      }
      min = 0;
   }

   public void cut(Node x, Node parent) {
      int place = x.getPlace();
      parent.getChild()[place] = null;
      x.setP(null);
      x.setMark(false);
      if (parent.getLeft() != null) {
         parent.getLeft().setRight(x);
         x.setLeft(parent.getLeft());
         parent.setLeft(x);
         x.setRight(parent);
         parent.getChild()[place] = null;
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
// same as Delete_min();
   public int extract_min() {
//      Node z = n;
//      if (z.getChild() != null) {
//      }
      return 0;
   }

   public void link(Node y, Node x) {
      if (y == null) {
         return;
      }
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
