package Heaps;

import BuildHeaps.Node;

public class Fibonacci implements ListOperator {

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

   public void insert(Node x) {
      if (x == null) {
         return;
      }
      if (n == null) {
         n = x;
         return;
      }
      if (x.getKey() < n.getKey()) {
         x.setLeft(n);
         n.setRight(x);
         n = n.getRight();
         return;
      }
      if (n.getLeft() == null) {
         n.setLeft(x);
         x.setRight(n);
         return;
      }
      Node left = n.getLeft();
      x.setLeft(left);
      left.setRight(x);
      x.setRight(n);
      n.setLeft(x);
   }

   public void dec_key(Node x, int newk) {
      if (x == null || n == null) {
         return;
      }
      x.setKey(newk);
      if (x.getParent() == null) {
         if (newk < n.getKey()) {
            n = switch_place(x, n);
         }
      } else {
         if (x.getParent().getKey() > newk) {
            Node p = x.getParent();
            p.getChild_List()[x.getPlace()] = null;
            cut(x);
            p.setMark(true);
            while (p.isMark() && p.getParent() != null) {
               cut(p);
               p = p.getParent();
            }
         }
      }
   }

   public void del_min() {
      if(n == null){
         return;
      }
      if (n.getChild_list() != null) {
         Node[] childs = n.getChild_List();
         //inserting all the child-nodes to the header-list
         for (int i = 0; i <= n.getChild_length(); i++) {
            // just incase there are some "fake" Nodes
            childs[i].setLeft(null);
            childs[i].setRight(null);
            childs[i].setParent(null);
            insert(childs[i]);
         }
      }
      if (n.getLeft() != null) {
         n = n.getLeft();
         n.setRight(null);
         consolidate();
      } else {
         n = null;
      }
   }

   public void consolidate() {
      this.rank = new Node[50];

      Node x = n;
      int min = Integer.MAX_VALUE;
      int min_index = -1;
      int max_degree = -1;
      while (x != null) {
         if (x.getDegree() >= rank.length) {
            moreLength();
         }
         if (rank[x.getDegree()] == null) {
            if (x.getKey() <= min) {
               min = x.getKey();
               min_index = x.getDegree();
            }
            rank[x.getDegree()] = x;
            if (max_degree < x.getDegree()) {
               max_degree = x.getDegree();
            }
            x = x.getLeft();
         } else {
            Node y = rank[x.getDegree()];
            rank[x.getDegree()] = null;
            if (x.getKey() < y.getKey()) {
               x = link(x, y);
            } else {
               x = link(y, x);
            }
         }
      }
      Node head = rank[min_index];
      if (head != null) {
         head.setLeft(null);
         head.setRight(null);
         Node z = head;
         //constructing the new list
         for (int i = 0; i < max_degree + 1; i++) {
            Node node = rank[i];
            if (node != null) {
               node.setLeft(null);
               node.setRight(null);
               if (node.getKey() != head.getKey()) {
                  z.setLeft(node);
                  node.setRight(z);
                  z = z.getLeft();
               }
            }
         }
      }
      n = head;
   }

   public Node link(Node x, Node y) {
      if (y == null) {
         return x;
      }
      if (x == null) {
         return y;
      }
      Node y_left = y.getLeft();
      Node y_right = y.getRight();

      if (y.getLeft() != null) {
         if (y_right == null) {
            y_left.setRight(null);
         } else if (y_right.getKey() == x.getKey()) {
            y_left.setLeft(x);
            x.setRight(y_left);
         } else {
            y_left.setRight(y_right);
            y_right.setLeft(y_left);
         }
      } else {
         if (y_right != null) {
            y_right.setLeft(null);
         }
      }
      x.setChild(y);
      x.setDegree(x.getDegree() + 1);
      y.setParent(x);
      return x;
   }

   public Node switch_place(Node x, Node y) {
      if (x == null) {
         return y;
      }
      if (y.getKey() < x.getKey()) {
         return y;
      }
      //if x is the left of n
      if (x.getRight() != null) {
         if (x.getRight().getKey() == y.getKey()) {
            if (x.getLeft() != null) {
               Node x_left = x.getLeft();
               y.setLeft(x_left);
               x_left.setRight(y);
            } else {
               y.setLeft(null);
            }
         }
      }// if x is somewhere else
      else {
         if (x.getLeft() != null) {
            Node x_left = x.getLeft();
            if (x.getRight() != null) {
               Node x_right = x.getRight();
               x_left.setRight(x_right);
               x_right.setLeft(x_left);
            }
         } else {
            if (x.getRight() != null) {
               x.getRight().setLeft(null);
            }
         }

      }
      y.setRight(x);
      x.setLeft(y);
      x.setRight(null);
      return x;
   }

   public void cut(Node x) {
      x.setParent(null);
      x.setLeft(null);
      x.setRight(null);
      x.setMark(false);
      x.setPlace(-1);
      insert(x);
   }

   public void moreLength() {
      int new_size = rank.length + (rank.length / 2);
      Node[] new_rank = new Node[new_size];
      System.arraycopy(rank, 0, new_rank, 0, rank.length);
      rank = new_rank;
   }
}
