package BuildHeaps;

import Heaps.Binary;
import Heaps.Fibonacci;

public class HeapControl {

   private Node f;
   private Fibonacci fh;
   private Binary bh;

   public HeapControl() {
      this.fh = null;
      this.bh = null;
//      Node f = new Node(null, null, 0);
   }

   public Node buildHeap(int k) {
      return new Node(null, 0, k);
   }

   public Fibonacci getFh() {
      return fh;
   }

   public Binary getBh() {
      return bh;
   }

   public void setFh(Fibonacci fh) {
      this.fh = fh;
   }

   public void setBh(Binary bh) {
      this.bh = bh;
   }
   public void printBh(){
      
   }
   public void printFh(){
      
   }
   public void depthfirstPrint(Node x){
      
   }

}
