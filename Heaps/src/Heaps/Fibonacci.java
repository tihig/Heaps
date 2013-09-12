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
            this.min = x.getKey();
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

   public void merge() {
   }

   public void consolidate() {
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
      }
      parent.setLeft(x);
      x.setRight(parent);
   }

   public void cascading_cut(Node x) {
   }
}
