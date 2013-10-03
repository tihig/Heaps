
import Heaps.Binary;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTest {

   private int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
   private Binary bin;
   private Binary hf;

   public BinaryTest() {
   }

   @Before
   public void setUp() {
      this.bin = new Binary(heap, 2);
      int[] h = {2, 1, 3};
      this.hf = new Binary(h, 2);
   }

   @Test
   public void getMinTest() {
      assertEquals(1, bin.getMin());
   }

   @Test
   public void HeapifyTest() {
      hf.heapify(0);
      assertEquals(1, hf.getMin());
   }

   @Test
   public void del_min_Test() {
      bin.del_min();
      assertEquals(2, bin.getMin());
   }

   @Test
   public void decrease_key_Test() {
      Binary dec = new Binary(new int[]{1, 3, 4, 5}, 4);
      dec.decrease_key(3, 2);
      assertEquals(2,dec.getKey(1));
   }

   @Test
   public void capasityTest() {
      Binary full = new Binary(new int[]{1, 2}, 1);

      int[] new_full = full.checkCapasity(full.getHeap(),full.getHeap_size());
      assertEquals(3,new_full.length);

   }
   @Test
   public void insertTest(){
      bin.insert(4);
      assertEquals(4,bin.getHeap()[3]);
   }
   @Test
   public void mergeTest(){
      Binary m = new Binary(new int[]{2,4,5,7,Integer.MAX_VALUE},3);
      bin.merge(m);
      assertEquals(5,bin.getHeap_size());
   }
}