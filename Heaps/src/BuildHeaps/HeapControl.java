package BuildHeaps;

public class HeapControl {

   private Node f;
   private int r;

   public HeapControl() {
//      Node f = new Node(null, null, 0);
   }

   public Node buildHeap(int[] numbers, int j,Node x) {
//      if(numbers[j] == Integer.MAX_VALUE){
//         return f;
//      }
//     Node h = new Node(null, null, numbers[j]);
//      if (f.getKey() == 0) {
//         f = h;
//         buildHeap(numbers, j++, f);
//      }
//      if(x.getLeft() == null){
//         x.setLeft(h);
//         buildHeap(numbers,j++, x);
//      }
//      if(x.getRight() == null){
//         x.setRight(h);
//         buildHeap(numbers,j++,h);
//      }
      return new Node(null,0, 0);
   }

   public void setNode(Node f) {
      this.f = f;
   }
   

   public void printTree() {
   }
   public Node[] getRoot(){
      Node[] root = new Node[50];
      
      Node x = f;
      int i = 0;
      while(x.getLeft() != null){
         if(x.getLeft() == null){
            break;
         }
         root[i] = x;
         x = x.getLeft();
         i++;
      }
      r = i-1;
      return root;
   }
   public int getR(){
      return r;
   }
}
