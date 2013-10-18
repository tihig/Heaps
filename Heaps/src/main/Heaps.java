package main;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Binary;
import Heaps.Fibonacci;
import java.util.Scanner;

public class Heaps {

    public static void main(String[] args) {

        HeapControl hc = new HeapControl();
        Scanner reader = new Scanner(System.in);

//        Node n1 = new Node(2);
//        Node c = new Node(4);
//        c.setParent(n1);
//        n1.setChild(c);
//        Node c2 = new Node(5);
//        c2.setParent(n1);
//        n1.setChild(c2);
//        Node left1 = new Node(8);
//        n1.setLeft(left1);
//        
//        Node left2 = new Node(15);
//        Node c3 = new Node(23);
//        c3.setParent(left2);
//        left2.setChild(c3);
//        left1.setLeft(left2);
//        left1.setRight(n1);
//        left2.setRight(left1);
//
//        Fibonacci f1 = new Fibonacci(n1);
        Binary b1 = new Binary(new int[]{2, 4, 5, 8, 15, Integer.MAX_VALUE}, 4);
        hc.setBh(b1);

          while (true) {
            hc.printBh();
            System.out.println("////////");
            System.out.println("");
            System.out.println("Anna komento: ");
            System.out.println("1. insert");
            System.out.println("2. delete min");
            System.out.println("3. decrease key");
            System.out.println("muu numero: lopeta");

            int answer = Integer.parseInt(reader.nextLine());
            b1 = hc.getBh();
            if (answer == 1) {
                System.out.println("anna luku: ");
                int number = Integer.parseInt(reader.nextLine());
                b1.insert(number);
            } else if (answer == 2) {    
                System.out.println("Pienin, binääri: " + b1.getMin());
                b1.del_min();
                System.out.println("Uusi pienin, binääri: " + b1.getMin());
            } else {
                System.out.println("END!");
                break;
            }

        }
    }
}
