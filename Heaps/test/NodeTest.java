

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
     this.n1 = new Node(null,1,2);
     n1.setChild(new Node(n1,1,4));
     n1.setChild(new Node(n1,1,5));
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
    public void getChildLeft(){
       assertEquals(4,n1.getChild()[0].getKey());
    }
    @Test
    public void getChildRight(){
       assertEquals(5,n1.getChild()[1].getKey());
    }
    @Test
    public void setChild(){
       n1.setChild(new Node(n1.getChild()[0],2,5));
       n1.setDegree(2);
       
       assertEquals(5,n1.getChild()[2].getKey());
       
    }
    
}