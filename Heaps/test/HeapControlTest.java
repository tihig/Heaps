
import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapControlTest {

   private int[] numbers;
   private HeapControl hc;
   private Node h;

   public HeapControlTest() {
      numbers = new int[]{1, 3, 4, 5, 7, 8};
      hc = new HeapControl();
      h = hc.buildHeap(new int[]{1, 2, 3},0,null);
   }

   @BeforeClass
   public static void setUpClass() {
   }

   @AfterClass
   public static void tearDownClass() {
   }

   @Before
   public void setUp() {
   }

   @After
   public void tearDown() {
   }

   @Test
   public void buildHeapTest1() {
      assertEquals(h.getKey(), 1);
   }

   @Test
   public void buildHeapTest2() {
      assertEquals(h.getLeft(), 2);
   }
   
   @Test
   public void buildHeapTest3() {
      assertEquals(h.getRight(), 3);
   }
}