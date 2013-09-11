
import Heaps.Binary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTest {
// TiRan testeistä aikatesteille mallia (joku stopwatch etc...)

   private int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
   private Binary bin;
   private Binary hf;

   public BinaryTest() {
   }

   @BeforeClass
   public static void setUpClass() {
   }

   @AfterClass
   public static void tearDownClass() {
   }

   @Before
   public void setUp() {
      this.bin = new Binary(heap, 2);
      int[] h = {2, 1, 3};
      this.hf = new Binary(h, 2);
   }

   @After
   public void tearDown() {
   }

   @Test
   public void getMinTest() {
      assertEquals(bin.getMin(), 1);
   }

   @Test
   public void HeapifyTest() {
      hf.heapify(0);
      assertEquals(hf.getMin(), 1);
   }

   @Test
   public void del_min_Test() {
      bin.del_min();
      assertEquals(bin.getMin(), 2);
   }

   @Test
   public void decrease_key_Test() {
      Binary dec = new Binary(new int[]{1, 3, 4, 5}, 4);
      dec.decrease_key(3, 2);
      assertEquals(dec.getKey(1), 2);
   }

   @Test
   public void capasityTest() {
      Binary full = new Binary(new int[]{1, 2}, 1);

      full.checkCapasity();
      int[] new_full = full.getHeap();
      assertEquals(new_full.length, 3);

   }
   @Test
   public void insertTest(){
      bin.insert(4);
      assertEquals(4,bin.getHeap()[3]);
   }

  
}