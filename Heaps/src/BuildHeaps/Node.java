package BuildHeaps;

public class Node {

   Node left;
   Node right;
   Node p;
   Node[] child = new Node[256];
   int c;
   int degree;
   int k;
   boolean mark;
   int place;

   public Node(Node p, int degree, int k) {
      this.left = null;
      this.right = null;
      this.p = p;
      this.c = 0;
      this.k = k;
      this.degree = degree;
      this.mark = false;
      this.place = 0;
   }

   public int getKey() {
      return k;
   }

   public Node getLeft() {
      return left;
   }

   public Node getRight() {
      return right;
   }

   public Node getP() {
      return p;
   }

   public Node[] getChild() {
      return child;
   }

   public boolean isMark() {
      return mark;
   }

   public int getDegree() {
      return degree;
   }

   public int getPlace() {
      return place;
   }

   public void setPlace(int place) {
      this.place = place;
   }

   public void setMark(boolean mark) {
      this.mark = mark;
   }

   public void setKey(int k) {
      this.k = k;
   }

   public void setDegree(int degree) {
      this.degree = degree;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public void setP(Node p) {
      this.p = p;
   }

   public void setChild(Node child) {
      this.child[c] = child;
      this.place = c;
      c++;
   }
}
