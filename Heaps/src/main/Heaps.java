package main;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Binary;

public class Heaps {

   public static void main(String[] args) {
      HeapControl h = new HeapControl();
      Node n1 = new Node(null, 1, 2);
      n1.setChild(new Node(n1, 1, 4));
      n1.setChild(new Node(n1, 1, 5));

      Node x = n1;
      for (int i = 0; i < 4; i++) {
         x.setLeft(new Node(null, 0, i + 3));
         x = x.getLeft();
      }
      h.setNode(n1);
      Node[] root = h.getRoot();
      
      for (int i = 0; i < h.getR(); i++) {
         Node node = root[i];
         System.out.println(node.getKey());
      }

   }
}
