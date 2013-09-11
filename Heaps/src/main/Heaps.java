package main;

import Heaps.Binary;


public class Heaps {

   public static void main(String[] args) {
      int[] h = new int[]{1, 2, 4,5};
      Binary test = new Binary(h, 2);
      long eka = System.currentTimeMillis();
      test.decrease_key(3, 3);
      long toka = System.currentTimeMillis();
      System.out.println(eka);
      System.out.println(toka);
      System.out.println(test.getMin());

   }
}
