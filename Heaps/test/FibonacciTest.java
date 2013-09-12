

import BuildHeaps.Node;
import Heaps.Fibonacci;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class FibonacciTest {
   private Node n1;
   private Node n2;
   private Fibonacci f1;

   public FibonacciTest() {
      this.n1 = new Node(null,1,2);
      n1.setChild(new Node(n1,1,4));
      n1.setChild(new Node(n1,1,5));
//      this.n2 = new Node(
//                        new Node(new Node(null,null,7),null,3),
//                              new Node(null,null,4),1);
      this.f1 = new Fibonacci(n1);
   }

   @Before
   public void setUp() {
   }

  @Test
  public void insertTest(){
     Node x = new Node(null,0,3);
     f1.insert(x);
     assertEquals(x.getKey(), n1.getLeft().getKey());
  }
}