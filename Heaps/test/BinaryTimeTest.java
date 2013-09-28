/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

import Heaps.Binary;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;


public class BinaryTimeTest {

   private int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
   private Binary bin;
   private Binary hf;
   private Binary b;

   public BinaryTimeTest() {
     
   }
    @Before
   public void setUp() {
      this.bin = new Binary(heap, 2);
      int[] h = {8, 9, 1, 7, 2, 5, 6, 16, 4, 10, 3};
      this.hf = new Binary(h, 10);
      int[] minHeap = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
      this.b = new Binary(minHeap, 10);
   }

   @Test
   public void insertTime() {
      float first = System.currentTimeMillis();
      for (int i = 0; i < 1000; i++) {
         bin.insert(i + 4);

      }
      float second = System.currentTimeMillis();
      float sum = second - first;
      System.out.println("Insert, time: " + sum);
      assertTrue(sum < 2);

   }

   @Test
   public void heapifyTime() {
      float first = System.currentTimeMillis();
      for (int i = 0; i < 11; i++) {
         hf.heapify(i);

      }
      float second = System.currentTimeMillis();
      float sum = second - first;
      System.out.println("Heapify, time: " + sum);
      assertTrue(sum < 2);
   }

   @Test
   public void del_minTime() {
      float first = System.currentTimeMillis();
      for (int i = 0; i < 11; i++) {
         b.del_min();
      }
      float second = System.currentTimeMillis();
      float sum = second - first;
      System.out.println("Delete min, time: " + sum);
      assertTrue(sum < 2);
   }

   @Test
   public void binaryTime() {
      float first = System.currentTimeMillis();

      for (int i = 0; i < 1000; i++) {
         bin.insert(i + 4);

      }

      for (int i = 0; i < 11; i++) {
         hf.heapify(i);

      }

      for (int i = 0; i < 11; i++) {
         b.del_min();
      }
      float second = System.currentTimeMillis();
      float sum = second - first;
      System.out.println("Binary, time: " + sum);
      assertTrue(sum < 2);
   }

   @Test(timeout = 1000)
   public void insertTime2() {
      for (int i = 0; i < 1000; i++) {
         bin.insert(i + 4);
      }
   }
}