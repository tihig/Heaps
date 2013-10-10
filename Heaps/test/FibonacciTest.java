
import BuildHeaps.Node;
import Heaps.Fibonacci;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {

   private Node n1;
   private Fibonacci f1;

   public FibonacciTest() {

   }

   @Before
   public void setUp() {
      this.n1 = new Node(null, 1, 2);
      n1.setChild(new Node(n1, 1, 4));
      n1.setChild(new Node(n1, 1, 5));
      this.f1 = new Fibonacci(n1);
   }

   @Test
   public void insertTest() {
      Node x = new Node(null, 0, 3);
      f1.insert(x);
      assertEquals(x.getKey(), n1.getLeft().getKey());
   }
   @Test
   public void insertTest2() {
      Node x = new Node(null, 0, 3);
      f1.insert(x);
      assertEquals(x.getKey(), n1.getLeft().getKey());
   }

   @Test
   public void decrease_keyTest() {
      Node x = n1.getChild()[1];
      f1.decrease_key(x, 3);
      Node h = f1.getN();

      assertEquals(3, h.getChild()[1].getKey());
   }

   @Test
   public void decrease_keyTest2() {
      Node x = n1.getChild()[1];
      f1.decrease_key(x, 1);
      Node h = f1.getN();

      assertEquals(1, h.getKey());
   }
    @Test
   public void decrease_keyTest3() {
      Node x = n1.getChild()[1];
      f1.insert(new Node(null,0,8));
      f1.decrease_key(x, 1);
      Node h = f1.getN().getLeft();

      assertEquals(8, h.getLeft().getKey());
   }
   @Test
   public void deleteTest(){
       Node del = n1.getChild()[0];
       f1.delete(del);
       
       int key = f1.getN().getChild()[0].getKey();
       assertEquals(5,key);
   }
      @Test
   public void deleteTest2(){
       Node del = n1.getChild()[0];
       f1.insert(new Node(null,0,8));
       f1.delete(del);
       
       int key = f1.getN().getLeft().getKey();
       assertEquals(8,key);
   }

   @Test
   public void cutTest() {
      Node parent = n1;
      Node x = n1.getChild()[0];

      f1.cut(x, parent);
      assertEquals(null, x.getP());
   }

   @Test
   public void cascading_cutTest() {
   }

   @Test
   public void consolidateTest() {
      Node nc = new Node(null, 0, 1);

      Node x = nc;
      for (int i = 0; i < 4; i++) {
         x.setLeft(new Node(null, 0, 1 + 2));
         x = x.getLeft();
      }
      Fibonacci fc = new Fibonacci(nc);
      fc.consolidate();

      nc = fc.getN();
      assertEquals(null, nc.getLeft());
   }
//   @Test
//   public void consolidateTest2() {
//      Node nc = new Node(null, 0, 1);
//
//      Node x = nc;
//      for (int i = 0; i < 4; i++) {
//         x.setLeft(new Node(null, 0, 1 + 2));
//         x = x.getLeft();
//      }
//      Fibonacci fc = new Fibonacci(nc);
//      fc.consolidate();
//
//      nc = fc.getN();
//      assertEquals(null, nc.getLeft());
//   }

   @Test
   public void linkTest() {
      Node link = new Node(null, 0, 1);
      Node link2 = new Node(null, 0, 3);

      Fibonacci linkNode = new Fibonacci(link);
      linkNode.link(link2, link);

      assertEquals(null, linkNode.getN().getLeft());
   }
   @Test
   public void moveChildTest(){
       f1.getN().getChild()[0] = null;
       f1.getN().moveChild();
       
       int key = f1.getN().getChild()[0].getKey();
       assertEquals(5,key);
       
   }
}