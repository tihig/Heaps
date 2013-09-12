
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
      h = hc.buildHeap(2);
   }
   @Before
   public void setUp() {
   }

   @Test
   public void buildHeapTest1() {
      assertEquals(h.getKey(), 2);
   }

   @Test
   public void getRoot() {
      Node x = h;
      for (int i = 0; i < 4; i++) {
         x.setLeft(new Node(null, 0, i + 3));
         x = x.getLeft();
      }
      hc.setNode(h);
      Node[] root = hc.getRoot();
      assertEquals(5,hc.getR());
   }
   
//   @Test
//   public void buildHeapTest3() {
//      assertEquals(h.getRight(), 3);
//   }
}