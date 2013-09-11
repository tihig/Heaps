
package BuildHeaps;

public class Node {
   Node left;
   Node right;
   Node p;
   Node[] child;
   int degree;
   int k;
   
   public Node(Node leftChild, Node rightChild, Node p,int degree, int k){
      this.left = null;
      this.right = null;
      this.child = new Node[]{leftChild,rightChild};
      this.p = null;
      this.k = k;
      this.degree = 0;
   }
   public int getKey(){
      return k;
   }
   public Node getLeft(){
      return left;
   }
   public Node getRight(){
      return right;
   }

   public Node getP() {
      return p;
   }

   public Node[] getChild() {
      return child;
   }

   public int getDegree() {
      return degree;
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
//      this.child = child;
   }
 
}
