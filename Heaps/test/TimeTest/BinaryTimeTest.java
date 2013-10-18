package TimeTest;


import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import Heaps.Binary;

public class BinaryTimeTest {

   private int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
   private Binary bin;
   private Binary b;

   public BinaryTimeTest() {
   }

   @BeforeClass
   public static void setUpClass() {
      System.out.println("");
      System.out.println("///Binary times: ");
      System.out.println("");
   }

   @Before
   public void setUp() {
      this.bin = new Binary(heap, 2);
      int[] minHeap = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
      this.b = new Binary(minHeap, 10);
   }

   @After
   public void tearDown() {
   }

   @Test
   public void get_minTime() {
      long first = System.currentTimeMillis();
      for (int i = 0; i < 100000; i++) {
         bin.getMin();
      }
      long second = System.currentTimeMillis();
      long sum = second - first;
      System.out.println("Get min, time: " + sum);
      assertTrue(sum < 20);
   }

   @Test
   public void del_minTime() {
      int[] del = new int[100000];
      for (int i = 0; i < del.length; i++) {
         del[i] = i;

      }
      b.setHeap(del);
      b.setHeap_size(del.length - 1);
      long first = System.currentTimeMillis();
      for (int i = 0; i < del.length; i++) {
         b.del_min();
      }
      long second = System.currentTimeMillis();
      long sum = second - first;
      System.out.println("Delete min, time: " + sum);
      assertTrue(sum < 20);
   }
    @Test
    public void insertTime() {
        long first = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            bin.insert(i + 4);

        }
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Insert, time: " + sum);
        assertTrue(sum < 20);
    }
      @Test
    public void dec_keyTime() {
        int[] dec = new int[100000];
        for (int i = 0; i < dec.length; i++) {
            dec[i] = i;    
        }
        b.setHeap(dec);
        b.setHeap_size(dec.length-1);
        long first = System.currentTimeMillis();
        for (int i = dec.length-1; i >= 0 ; i--) {
            b.dec_key(i, i-20); 
        }
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Decrease key, time: " + sum);
        assertTrue(sum < 20);
    }
       @Test
    public void mergeTime() {
        int[] mergeHeap = new int[100000];
        for (int i = 0; i < mergeHeap.length; i++) {
                mergeHeap[i] = i + 3;  
        }
        Binary m = new Binary(mergeHeap, 99999);
        long first = System.currentTimeMillis();
        b.merge(m);
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Merge, time: " + sum);
        assertTrue(sum < 6500);
    }
}