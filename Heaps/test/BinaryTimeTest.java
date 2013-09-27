/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Heaps.Binary;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author viivi
 */
public class BinaryTimeTest {

   private int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
   private Binary bin;
   private Binary hf;

   public BinaryTimeTest() {
      this.bin = new Binary(heap, 2);
   }

   @Test
   public void insertTime(){
      float first = System.currentTimeMillis();
      for (int i = 0; i < 1000; i++) {
         bin.insert(i+4);
         
      }
      float second = System.currentTimeMillis();
      float sum = second-first;
      System.out.println("Insert, time: "+ sum);
      assertTrue(sum < 2);
      
   }
   @Test(timeout = 1000)
   public void insertTime2(){
       for (int i = 0; i < 1000; i++) {
         bin.insert(i+4);
      }
   }
}