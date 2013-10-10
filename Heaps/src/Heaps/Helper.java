package Heaps;

import BuildHeaps.Node;

public class Helper {

    // possible class for initializing methods etc.
    public Helper() {
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
        
        return rewind(node);
    }
    
    public Node buildConsolidateHeap() {
        Node node = new Node(null, 0, 0);

//        node.setRight(null);
//        node.setLeft(new Node(null, 1, 1));
//        node.getLeft().setRight(node);
//        
//        node = node.getLeft();
        int degree = 0;
        int val = 2;
        int times = 1;
        for (int i = 0; i < 40; i++) {
            Node ins = new Node(null, degree, val);
            
            int c_degree = degree - 1;
            Node c = ins;
            for (int j = 1; j < times; j++) {
                val++;
                c.setChild(new Node(c, c_degree, val));
                if (c_degree > 0) {
                    c_degree--;
                }
                c = c.getChild()[0];
            }
            node.setLeft(ins);
            ins.setRight(node);
            node = ins;
            times ++;
            degree = times - 1;
            val++;
        }
        
        return rewind(node);
    }
    
    public Node buildExtractMinHeap() {
        Node x = new Node(null, 0, 0);
        Node z = x;
        
        for (int i = 1; i < 20; i++) {
            Node ins = new Node(null, 0, i);
            x.setLeft(ins);
            ins.setRight(x);
            x = x.getLeft();
        }
        return z;
    }
    
    public Node rewind(Node node) {
        
        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
    
    public void spareMethod() {
//          while (true) {
//            hc.printBh();
//            System.out.println("////////");
//            hc.trees();
//            System.out.println("");
//            System.out.println("Anna komento: ");
//            System.out.println("1. insert");
//            System.out.println("2. delete min");
//            System.out.println("3. decrease key");
//            System.out.println("muu numero: lopeta");
//
//            int answer = Integer.parseInt(reader.nextLine());
//            f1 = hc.getFh();
//            b1 = hc.getBh();
//            if (answer == 1) {
//                System.out.println("anna luku: ");
//                int number = Integer.parseInt(reader.nextLine());
//                f1.insert(new Node(null, 0, number));
//                b1.insert(number);
//            } else if (answer == 2) {
//                System.out.println("Pienin, fibonacci: " + f1.getN().getKey());
//                System.out.println("Pienin, binääri: " + b1.getMin());
//                f1.extract_min();
//                b1.del_min();
//                System.out.println("Uusi pienin, fibonacci: " + f1.getN().getKey());
//                System.out.println("Uusi pienin, binääri: " + b1.getMin());
//            } else if (answer == 3) {
//                System.out.println("Anna avain: ");
//                int key = Integer.parseInt(reader.nextLine());
//                System.out.println("Anna uusi avain: ");
//                int newk = Integer.parseInt(reader.nextLine());
//
//                //trying to find the node... might be a bad idea
//                //ei pelaa!!
//                Node x = f1.getN();
//                while (x != null) {
//                    if (x.getKey() == key) {
//                        break;
//                    }
//                    for (int i = 0; i < x.getC(); i++) {
//                        if (x.getChild()[i].getKey() == key) {
//                            x = x.getChild()[i];
//                            break;
//                        }
//                    }
//                    x = x.getLeft();
//                }
//                int bhkey = 0;
//                for (int i = 0; i <= b1.getHeap_size(); i++) {
//                    if (b1.getHeap()[i] == key) {
//                        bhkey = i;
//                        break;
//                    }
//                }
//                f1.decrease_key(x, newk);
//                b1.decrease_key(bhkey, newk);
//            } else {
//                System.out.println("END!");
//                break;
//            }
//
//        }
    }
}
