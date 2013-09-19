package main;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Binary;
import Heaps.Fibonacci;

public class Heaps {

   public static void main(String[] args) {
      
      HeapControl h = new HeapControl();
      
      Node n = h.buildHeap(0);
      int[] heap = new int[]{0, Integer.MAX_VALUE, Integer.MAX_VALUE};
      
      Fibonacci f = new Fibonacci(n);
      Binary b = new Binary(heap,0);
      
      h.setBh(b);
      h.setFh(f);
      
      long[] results = h.insertTimeComparison();
      
      for (int i = 0; i < results.length; i++) {
         System.out.println(results[i]);
         
      }

   }
}
