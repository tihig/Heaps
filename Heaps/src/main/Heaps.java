package main;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Binary;
import Heaps.Fibonacci;

public class Heaps {

   public static void main(String[] args) {
      Node n1 = new Node(null, 1, 2);
      n1.setChild(new Node(n1, 1, 4));
      n1.setChild(new Node(n1, 1, 5));
      Fibonacci f1 = new Fibonacci(n1);
      
      f1.decrease_key(n1.getChild()[1], 1);

   }
}
