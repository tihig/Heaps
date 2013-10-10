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

        Node n1 = new Node(null, 1, 1);
        n1.setChild(new Node(n1, 1, 4));
        n1.setChild(new Node(n1, 1, 5));
        Fibonacci f1 = new Fibonacci(n1);

        Binary b1 = new Binary(new int[]{1, Integer.MAX_VALUE}, 0);


        hc.setFh(f1);
        hc.setBh(b1);

        while (true) {
            System.out.println("");
            System.out.println("Anna komento: ");
            System.out.println("1. insert");
            System.out.println("2. delete min");
            System.out.println("3. decrease key");
            System.out.println("4. lopeta");

            int answer = Integer.parseInt(reader.nextLine());
            f1 = hc.getFh();
            b1 = hc.getBh();
            if (answer == 1) {
                System.out.println("anna luku: ");
                int number = Integer.parseInt(reader.nextLine());
                f1.insert(new Node(null, 0, number));
                b1.insert(number);
            } else if (answer == 2) {
                System.out.println("Pienin, fibonacci: "+ f1.getN().getKey());
                System.out.println("Pienin, binääri: "+ b1.getMin());
                f1.delete(f1.getN());
                b1.del_min();
                System.out.println("Uusi pienin, fibonacci: " + f1.getN().getKey());
                System.out.println("Uusi pienin, binääri: " + b1.getMin());
            } else if (answer == 3) {
                System.out.println("Anna avain: ");
                int key = Integer.parseInt(reader.nextLine());
                System.out.println("Anna uusi avain: ");
                int newk = Integer.parseInt(reader.nextLine());
                
                //trying to find the node... might be a bad idea
                Node x = f1.getN();
                while(x != null){
                    if(x.getKey() == key){
                        break;
                    }
                    for (int i = 0; i <= x.getC(); i++) {
                        if(x.getChild()[i].getKey() == key){
                            x = x.getChild()[i];
                            break;
                        }
                    }
                    x = x.getLeft();
                }
                int bhkey = 0;
                for (int i = 0; i < b1.getHeap_size(); i++) {
                    if(b1.getHeap()[i] == key){
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
            hc.printBh();
            System.out.println("////////");
            hc.printFh();
        }


    }
}
