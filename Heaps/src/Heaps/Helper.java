
package Heaps;

import BuildHeaps.Node;

public class Helper {
    
    // possible class for initializing methods etc.
    public Helper(){
        
    }
     public Node buildTestHeap() {

        Node node = new Node(null, 0, 0);

        Node prev = null;

        for (int i = 0; i < 11; i++) {
            node = new Node(null, i, i);
            for (int j = 0; j < i; j++) {
                Node c = node;
                c.setChild(new Node(c, j, i + 3));
                c = c.getChild()[0];
            }
            node.setRight(prev);
            if (prev != null) {
                prev.setLeft(node);
            }
            prev = node;

        }
 
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
    
    
}
