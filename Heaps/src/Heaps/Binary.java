package Heaps;

public class Binary {

   private int[] heap;

   public Binary(int[] heap) {
      this.heap = heap;
   }

   public int[] getHeap() {
      return heap;
   }

   public int getMin() {
      return heap[0];
   }

   public void insert() {
   }

   public void del_min() {
   }

   public void heapify(int i) {
      int l = 2 * 1;
      int r =  2* i +1;
      int min = 0;
      if( r <= heap.length+1){
         if(heap[l] < heap[r]){
            min = l;
         }
         else{
            min = r;
         }
      }
      if(heap[i] > heap[min]){
         int s = heap[i];
         heap[i] = heap[min];
         heap[min] = s;
         heapify(min);
      }
      else if(r == heap.length+1 && heap[i] > heap[l]){
         int s = heap[i];
         heap[i] = heap[l];
         heap[l] = s;
      }
      
   }
}
