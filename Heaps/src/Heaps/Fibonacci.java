package Heaps;

import BuildHeaps.Node;

public class Fibonacci {

   private Node n;
   private Node[] rank;

   public Fibonacci(Node n) {
      this.n = n;
      this.rank = null;
   }

   public Node getN() {
      return n;
   }

   public void setN(Node n) {
      this.n = n;
   }

   public int getMin() {
      if (n == null) {
         return 0;
      }
      return n.getKey();
   }

   public void decrease_key(Node x, int newk) {
      if (x == null) {
         return;
      }
      if (newk < x.getKey()) {
         x.setKey(newk);
         Node parent = x.getP();
         if (parent != null && parent.getKey() > x.getKey()) {
            cut(x, parent);
            cascading_cut(parent);

         }
         if (x.getKey() < getMin()) {
            Node left = null;
            Node right = null;
            if (x.getLeft() != null) {
               left = x.getLeft();
            }
            if (x.getRight() != null) {
               right = x.getRight();
            }


            if (left != null) {
               left.setRight(right);
            }
            if (right != null) {
               right.setLeft(left);
            }
            if (n != null) {
               n.setRight(x);
               x.setLeft(n);
               x.setRight(null);
               n = n.getRight();
            }
         }

      }
   }

   public void delete(Node x) {
      if (x == null) {
         return;
      }

      decrease_key(x, Integer.MIN_VALUE);
      extract_min();
      if (n != null && n.getChild() != null) {
         n.moveChild();
      }

   }

   public void insert(Node k) {
      if (k == null) {
         return;
      }
      if (getMin() > k.getKey()) {
         k.setRight(null);
         k.setLeft(n);
         n.setRight(k);
         n = k;
      } else {
         if (n.getLeft() != null) {
            n.getLeft().setRight(k);
            k.setLeft(n.getLeft());
         }
         n.setLeft(k);
         k.setRight(n);
      }
      if (rank == null || rank[k.getDegree()] == null) {
         consolidate();
      } else {
         rank[k.getDegree()] = k;
      }
   }

   public void consolidate() {
      Node x = n;
      Node f = x;

      if (n == null) {
         return;
      }
      if (n.getLeft() == null) {
         return;
      }
      this.rank = new Node[50];
      int min_index = x.getDegree();
      int min_val = x.getKey();
      while (x != null) {
         if (x.getKey() <= min_val) {
            min_index = x.getDegree();
            min_val = x.getKey();
         }
         if (rank[x.getDegree()] == null) {
            rank[x.getDegree()] = x;
            x = x.getLeft();
         } else {
            int xdegree = x.getDegree();
            Node y = rank[xdegree];
            rank[xdegree] = null;
            if (x.getKey() != y.getKey()) {
               if (x.getKey() < y.getKey()) {
                  link(y, x);
               } else {
                  link(x, y);
                  x = y;
               }
            }
         }
      }
      n = rank[min_index];
   }

   public void cut(Node x, Node parent) {
      if (x == null || parent == null) {
         return;
      }
      int place = x.getPlace();
      parent.getChild()[place] = null;
      parent.setC(parent.getC() - 1);
      x.setP(null);
      x.setMark(false);
      if (parent.getLeft() != null) {
         if (parent.getLeft() != x) {
            parent.getLeft().setRight(x);
            x.setLeft(parent.getLeft());
         }
         parent.setLeft(x);
         x.setRight(parent);
         if (parent.getChild() != null) {
            parent.getChild()[place] = null;
         }
      }
      parent.setLeft(x);
      x.setRight(parent);

   }

   public void cascading_cut(Node x) {
      if (x == null) {
         return;
      }
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

   public Node extract_min() {
      if (n != null) {
         Node z = n;
         if (z.getChild() != null) {
            Node[] childs = z.getChild();
            for (int i = 0; i <= z.getC(); i++) {
               Node child = childs[i];
               if (child != null) {
                  child.setRight(z);
                  if (z.getLeft() != null) {
                     z.getLeft().setRight(child);
                  }
                  child.setLeft(z.getLeft());
                  if (z.getLeft() != null) {
                     z.setLeft(child);
                  }
                  child.setP(null);

               }
            }
         }

         if (z.getLeft() == null && z.getRight() == null) {
            this.n = null;
         } else {
            n = z.getLeft();
            if (n != null) {
               n.setRight(null);
            }
            consolidate();
         }

      }
      return n;
   }

   public void link(Node y, Node x) {
      if (y == null) {
         return;
      }
      Node yLeft = y.getLeft();
      Node yRight = y.getRight();

      y.setLeft(null);
      y.setRight(null);

      if (yLeft != null) {
         yLeft.setRight(yRight);
      }

      if (yRight != null) {
         yRight.setLeft(yLeft);
      }

      x.setChild(y);
      y.setP(x);

      x.setDegree(x.getDegree() + 1);
      y.setMark(false);

   }
}
