

import BuildHeaps.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


public class NodeTest {
   private Node n1;
   private Node f;
   private Node left;
   private Node right;
   
   public NodeTest() {
     this.n1 = new Node(new Node(null,null,n1,1,4),new Node(null,null,n1,1,5),null,1,2);
   }
   @Before
   public void Before(){
      n1.setLeft(left);
      
   }
  
    @Test
   public void nodeKeyTest(){
       assertEquals(n1.getKey(), 2);
    }
  
    @Test
    public void getChild(){
       
    }
    
}