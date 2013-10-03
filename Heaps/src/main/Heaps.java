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


        Node node = hc.buildHeap(1);
        Fibonacci f1 = new Fibonacci(node);

        Binary b1 = new Binary(new int[]{1, Integer.MAX_VALUE}, 0);

        hc.setFh(f1);
        hc.setBh(b1);


//        while (true) {
//            System.out.println("Anna komento: ");
//            System.out.println("1. insert");
//            System.out.println("2. delete min");
//            System.out.println("3. decrease key");
//            System.out.println("4. lopeta");
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
//            } else if (answer == 3) {
//            } else {
//                System.out.println("END!");
//                break;
//            }
////            hc.printBh();
////            System.out.println("////////");
////            hc.printFh();
//        }


    }
}
