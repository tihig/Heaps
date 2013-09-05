
package BuildHeaps;

public class Node {
   Node left;
   Node right;
   Node[] p;
   Node[] child;
   int k;
   
   public Node(Node left, Node right, int k){
      this.left = left;
      this.right = right;
      this.child = null;
      this.p = null;
      this.k = k;
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

   public Node[] getP() {
      return p;
   }

   public Node[] getChild() {
      return child;
   }

   public void setLeft(Node left) {
      this.left = left;
   }

   public void setRight(Node right) {
      this.right = right;
   }

   public void setP(Node[] p) {
      this.p = p;
   }

   public void setChild(Node[] child) {
      this.child = child;
   }
 
}
