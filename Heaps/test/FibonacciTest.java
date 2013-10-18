
import BuildHeaps.Node;
import Heaps.Fibonacci;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTest {

   private Node n;
   private Fibonacci f;

   public FibonacciTest() {

   }

   @Before
   public void setUp() {
     this.n = new Node(1);
      n.setChild_List(new Node[]{new Node(4),new Node(5)});
      n.setChild_length(1);
      n.setDegree(1);
      n.setLeft(new Node(2));
      this.f = new Fibonacci(n);
   }

   @Test
   public void insertTest() {
      Node x = new Node(3);
      f.insert(x);
      assertEquals(1, n.getKey());
   }
   @Test
   public void insertTest2() {
      Node x = new Node(3);
      f.insert(x);
      assertEquals(x.getKey(), n.getLeft().getKey());
   }

   @Test
   public void decrease_keyTest() {
      Node x = n.getChild(1);
      f.dec_key(x, 3);
      Node h = f.getN();

      assertEquals(3, h.getChild(1).getKey());
   }

   @Test
   public void decrease_keyTest2() {
      Node x = n.getChild(1);
      f.dec_key(x, -1);
      Node h = f.getN();

      assertEquals(-1, h.getKey());
   }
    @Test
   public void decrease_keyTest3() {
      Node x = n.getChild(1);
      f.insert(new Node(8));
      f.dec_key(x, -1);
      Node h = f.getN().getLeft();

      assertEquals(8, h.getLeft().getKey());
   }

//
//   @Test
//   public void cutTest() {
//      Node parent = n1;
//      Node x = n1.getChild()[0];
//
//      f1.cut(x, parent);
//      assertEquals(null, x.getP());
//   }


//   @Test
//   public void consolidateTest() {
//      Node nc = new Node(1);
//
//      Node left1 = new Node(3);
//      left1.setRight(nc);
//      nc.setLeft(left1);
//      Node left2 = new Node(8);
//      Node child = new Node(9);
//      child.setParent(left2);
//      left2.setChild(child);
//      left2.setRight(left1);
//      left1.setLeft(left2);
//      Fibonacci fc = new Fibonacci(nc);
//      fc.consolidate();
//
//      nc = fc.getN();
//      assertEquals(null, nc.getLeft());
//   }

   @Test
   public void linkTest() {
      Node link = new Node( 1);
      Node link2 = new Node( 3);

      Fibonacci linkNode = new Fibonacci(link);
      linkNode.link(link2, link);

      assertEquals(null, linkNode.getN().getLeft());
   }
}