package main;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Binary;
import Heaps.Fibonacci;
import Heaps.Helper;
import java.util.Scanner;

public class Heaps {

    public static void main(String[] args) {

        HeapControl hc = new HeapControl();
        Scanner reader = new Scanner(System.in);

        Node n1 = new Node(null, 1, 2);
        Node c = new Node(n1, 0, 4);
        n1.setChild(c);
        n1.setChild(new Node(n1, 0, 5));
        Node left1 = new Node(null, 0, 8);
        n1.setLeft(left1);
        Node left2 = new Node(null, 1, 15);
        left2.setChild(new Node(left2, 0, 23));
        left1.setLeft(left2);
        left1.setRight(n1);
        left2.setRight(left1);

        Fibonacci f1 = new Fibonacci(n1);

        Binary b1 = new Binary(new int[]{2, 4, 5, 8, 15, Integer.MAX_VALUE}, 4);
        hc.setFh(f1);
        hc.setBh(b1);

          while (true) {
            hc.printBh();
            System.out.println("////////");
            hc.trees();
            System.out.println("");
            System.out.println("Anna komento: ");
            System.out.println("1. insert");
            System.out.println("2. delete min");
            System.out.println("3. decrease key");
            System.out.println("muu numero: lopeta");

            int answer = Integer.parseInt(reader.nextLine());
            f1 = hc.getFh();
            b1 = hc.getBh();
            if (answer == 1) {
                System.out.println("anna luku: ");
                int number = Integer.parseInt(reader.nextLine());
                f1.insert(new Node(null, 0, number));
                b1.insert(number);
            } else if (answer == 2) {
                System.out.println("Pienin, fibonacci: " + f1.getN().getKey());
                System.out.println("Pienin, binääri: " + b1.getMin());
                f1.extract_min();
                b1.del_min();
                System.out.println("Uusi pienin, fibonacci: " + f1.getN().getKey());
                System.out.println("Uusi pienin, binääri: " + b1.getMin());
            } else if (answer == 3) {
                System.out.println("Anna avain: ");
                int key = Integer.parseInt(reader.nextLine());
                System.out.println("Anna uusi avain: ");
                int newk = Integer.parseInt(reader.nextLine());

                //finding fib-nodes won't work
                Node x = f1.getN();
                while (x != null) {
                    if (x.getKey() == key) {
                        break;
                    }
                    for (int i = 0; i < x.getC(); i++) {
                        if (x.getChild()[i].getKey() == key) {
                            x = x.getChild()[i];
                            break;
                        }
                    }
                    x = x.getLeft();
                }
                int bhkey = 0;
                for (int i = 0; i <= b1.getHeap_size(); i++) {
                    if (b1.getHeap()[i] == key) {
                        bhkey = i;
                        break;
                    }
                }
                f1.decrease_key(x, newk);
                b1.decrease_key(bhkey, newk);
            } else {
                System.out.println("END!");
                break;
            }

        }
    }
}
