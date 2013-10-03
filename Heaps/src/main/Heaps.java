package main;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Binary;
import Heaps.Fibonacci;

public class Heaps {
    
    public static void main(String[] args) {

//      int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
//      
//      Binary b = new Binary(heap,2);
//     
//      h.setBh(b);
//      b.heapify(0);
//      
//      h.printBh();
        Node n1 = new Node(null, 1, 2);
        Node oo = new Node(n1, 0, 4);
        oo.setChild(new Node(oo,0,7));
        n1.setChild(oo);
        n1.setChild(new Node(n1, 0, 5));
        Fibonacci f1 = new Fibonacci(n1);
        
        f1.decrease_key(n1.getChild()[1], 1);
        
        
        HeapControl h = new HeapControl();
        h.setFh(f1);

     // joku mysteeripilkku on tullu tänne O__O
        h.printFh();

    }
}
