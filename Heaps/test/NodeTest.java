
import BuildHeaps.Node;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class NodeTest {

   private Node n1;
   private Node f;
   private Node left;
   private Node right;

   public NodeTest() {
      this.n1 = new Node(2);
      Node c1 = new Node(4);
      c1.setParent(n1);
      n1.setChild(c1);
      Node c2 = new Node(5);
      c2.setParent(n1);
      n1.setChild(c2);
   }

   @Before
   public void Before() {
      n1.setLeft(left);

   }

   @Test
   public void nodeKeyTest() {
      assertEquals(n1.getKey(), 2);
   }

   @Test
   public void getChildLeft() {
      assertEquals(4, n1.getChild(0).getKey());
   }

   @Test
   public void getChildRight() {
      assertEquals(5, n1.getChild(1).getKey());
   }

   @Test
   public void setChild() {
      Node c3 = new Node(7);
      n1.setChild(c3);

      assertEquals(7, n1.getChild(2).getKey());

   }
}