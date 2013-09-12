package BuildHeaps;

public class HeapControl {

   private Node f;

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

   public void printTree() {
   }
}
