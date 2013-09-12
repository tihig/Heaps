package BuildHeaps;

public class HeapControl {

   private Node f;
   private int r;

   public HeapControl() {
//      Node f = new Node(null, null, 0);
   }

   public Node buildHeap(int k) {
      return new Node(null, 0, k);
   }

   public void setNode(Node f) {
      this.f = f;
   }

//   public void printTree() {
//   }
   public Node[] getRoot() {
      Node[] root = new Node[50];

      Node x = f;
      int i = 0;
      while (x != null) {
         root[i] = x;
         x.setPlace(i);
         x = x.getLeft();
         i++;
      }
      r = i;
      return root;
   }

   public int getR() {
      return r;
   }
}
