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

    public int getHeap_size() {
        return heap_size;
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
      checkCapasity(heap,heap_size);
      heap[0] = Integer.MAX_VALUE;
      heapify(0);
      heap_size -= 1;
   }
   public void insert(int k) {
      this.heap = checkCapasity(this.heap,this.heap_size);
      heap_size += 1;

      int i = heap_size;
      while (i > 0 && heap[parent(i)] > k) {
         heap[i] = heap[parent(i)];
         i = parent(i);
      }
      heap[i] = k;
   }

   public void merge(Binary other) {
      int[] newHeap = initializeHeap(new int[this.heap.length]);
      int[] otherHeap =  other.checkCapasity(other.getHeap(),other.heap_size);
     
      int i = 0;
      int j = 0;
      int k = 0;
      while(heap[k] != Integer.MAX_VALUE || otherHeap[j] != Integer.MAX_VALUE){
         newHeap = checkCapasity(newHeap,i);
         if(heap[k] == otherHeap[j]){
            newHeap[i] = heap[k];
            k++;
            j++;
         }
         else if( otherHeap[j] < heap[k]){
             newHeap[i] = otherHeap[j] ;
             j++;
         } 
         else{
            newHeap[i] = heap[k];
            k++; 
         }
         i++;
      }
      
      this.heap = newHeap;
      this.heap_size = i-1;   
      heapify(0);
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
      // r > heap_size eli ei ole olemassa
      else if(r > heap_size && r < heap.length){
         min = l;
         heap[0] = heap[min];
         heap[min] = Integer.MAX_VALUE;
      }

   }

   public int[] checkCapasity(int[] h, int h_size) {
      if (h_size < heap.length - 1) {
         return h;
      }
      int new_size = h.length + (h.length / 2);
      int[] new_heap = initializeHeap(new int[new_size]);
      System.arraycopy(h, 0, new_heap, 0, h.length);
      return new_heap;
   }
   
   public int[] initializeHeap(int[] h){
       for (int i = 0; i < h.length; i++) {
           h[i] = Integer.MAX_VALUE;
       }
       return h;
   }

   public int parent(int i) {
      return i / 2;
   }

   public int left(int i) {
       if(i == 0){
           return 1;
       }
      return 2 * i +1;
   }

   public int right(int i) {
       if(i == 0){
           return 2;
       }
      return 2 * i +2;
   }
}
