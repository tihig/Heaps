package Heaps;

public class Binary {

   private int[] heap;
   private int heap_size;

   public Binary(int[] heap, int heap_size) {
      this.heap = heap;
      this.heap_size = heap_size;
   }

   public int[] getHeap() {
      return heap;
   }

   public int getMin() {
      return heap[0];
   }

   public int getKey(int i) {
      return heap[i];
   }

   public void decrease_key(int i, int newk) {
      if(i < 0){
         return;
      }
      if (newk < heap[i]) {
         heap[i] = newk;
         while (i > 1 && heap[parent(i)] > newk) {
            int j = parent(i);
            heap[i] = heap[j];
            heap[j] = newk;
            i = j;
         }
      }
   }

   public void del_min() {
      if(heap == null){
         return;
      }
      heap[0] = heap[heap_size];
      heapify(0);
      heap_size -= 1;
   }

   public void insert(int k) {
      checkCapasity();
      heap_size += 1;
      int i = heap_size;
      while (i > 1 && heap[parent(i)] > k) {
         heap[i] = heap[parent(i)];
         i = parent(i);
      }
      heap[i] = k;

   }

   public void merge(Binary other) {
      int[] newHeap = new int[50];
      int[] otherHeap = other.getHeap();
      
      other.checkCapasity();
     
      int i = 0;
      while(heap[i] != Integer.MAX_VALUE || otherHeap[i] != Integer.MAX_VALUE){
         int add = 0;
         if(heap[i] == Integer.MAX_VALUE){
            
         }
      }
              
   }

   public void heapify(int i) {
      if(i < 0){
         return;
      }
      int l = left(i);
      int r = right(i);
      int min = 0;
      if (r <= heap_size) {
         if (heap[l] < heap[r]) {
            min = l;
         } else {
            min = r;
         }
         if (heap[i] > heap[min]) {
            int s = heap[i];
            heap[i] = heap[min];
            heap[min] = s;
            heapify(min);
         }
      } else if (r == heap_size && heap[i] > heap[l]) {
         int s = heap[i];
         heap[i] = heap[l];
         heap[l] = s;
      }

   }

   public boolean checkCapasity() {
      if (heap_size < heap.length - 1) {
         return true;
      }
      int new_size = heap.length + (heap.length / 2);
      int[] new_heap = new int[new_size];
      System.arraycopy(heap, 0, new_heap, 0, heap.length);
      heap = new_heap;
      return heap.length == new_size;
   }

   public int parent(int i) {
      return i / 2;
   }

   public int left(int i) {
       if(i == 0){
           return 1;
       }
       if(i == 1){
           return 3;
       }
      return 2 * i;
   }

   public int right(int i) {
       if(i == 0){
           return 2;
       }
      return 2 * i + 1;
   }
}
