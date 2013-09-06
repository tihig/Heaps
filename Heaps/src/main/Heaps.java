
package main;

import Heaps.Binary;

public class Heaps {

  
   public static void main(String[] args) {
      int[] h = new int[]{2,1,3};
      Binary test = new Binary(h, 2);
      test.heapify(0);
      System.out.println(test.getMin());
   }
}
