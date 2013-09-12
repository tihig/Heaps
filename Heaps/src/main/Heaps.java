package main;

import BuildHeaps.Node;
import Heaps.Binary;

public class Heaps {

   public static void main(String[] args) {
      Node n1 = new Node(null, 1, 2);
      n1.setChild(new Node(n1, 1, 4));
      n1.setChild(new Node(n1, 1, 5));

      System.out.println(n1.getChild()[0].getKey());
      System.out.println(n1.getChild()[0].getP().getKey());

   }
}
