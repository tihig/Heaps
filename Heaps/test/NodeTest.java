

import BuildHeaps.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NodeTest {
   private Node n;
   private Node f;
   private Node left;
   private Node right;
   
   public NodeTest() {
      this.n = new Node(null,null,5);
      this.f = new Node(null,null,0);
      this.left = new Node(null,null,8);
      this.right = new Node(null,null,3);
   }
   @Before
   public void Before(){
      n.setLeft(left);
      n.setRight(right);  
   }
  
    @Test
   public void nodeKeyTest(){
       assertEquals(n.getKey(), 5);
    }
    
}