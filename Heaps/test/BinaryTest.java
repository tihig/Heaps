

import Heaps.Binary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTest {

   private int[] heap = {1,2,3};
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
      this.bin = new Binary(heap);
      int[] h = {2,1,3};
      this.hf = new Binary(h);
   }

   @After
   public void tearDown() {
   }

   @Test
   public void getMinTest() {
      assertEquals(bin.getMin(), 1);
   }
   
   @Test
   public void HeapifyTest(){
     hf.heapify(0);
     boolean t= true;
     int[] th = hf.getHeap();
      for (int i : heap) {
         if(heap[i] != th[i]){
            t = false;
            break;
         }
      }
      assertTrue(t);
   }
}