package TimeTest;

import BuildHeaps.Node;
import Heaps.Fibonacci;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTimeTest {

   private Node n1;
   private Fibonacci f1;
   private Node n2;

   public FibonacciTimeTest() {
   }

   @BeforeClass
   public static void className() {
      System.out.println("");
      System.out.println("///Fibonacci times:");
      System.out.println("");
   }

   @Before
   public void setUp() {
      this.n1 = new Node(2);
      Node c1 = new Node(4);
      c1.setParent(n1);
      n1.setChild(c1);
      Node c2 = new Node(5);
      c2.setParent(n1);
      n1.setChild(c2);
      this.f1 = new Fibonacci(n1);
   }

   @Test
   public void get_minTime() {
      long first = System.currentTimeMillis();
      for (int i = 0; i < 10000; i++) {
         f1.getN();
      }

      long second = System.currentTimeMillis();
      long sum = second - first;
      System.out.println("Get min, time: " + sum);
      assertTrue(sum < 10);
   }

   @Test
   public void del_minTime() {
      Node[] del = new Node[100000];
      Node prev = null;
      for (int i = 0; i < del.length; i++) {
         Node x = new Node(i + 3);
         if (prev != null) {
            x.setLeft(prev);
            prev.setRight(x);
         }
         prev = x;
         del[i] = x;
      }
      Fibonacci f_dec = new Fibonacci(del[0]);
      long first = System.currentTimeMillis();
      for (int i = 0; i < del.length; i++) {
         f_dec.del_min();
      }

      long second = System.currentTimeMillis();
      long sum = second - first;
      System.out.println("Delete min, time: " + sum);
      assertTrue(sum < 10);
   }

   @Test
   public void insertTime() {
      Node[] ins = new Node[100000];
      for (int i = 0; i < ins.length; i++) {
         Node x = new Node(i + 3);
         ins[i] = x;
      }
      long first = System.currentTimeMillis();
      for (int i = 0; i < 100000; i++) {
         f1.insert(ins[i]);
      }
      long sec = System.currentTimeMillis();
      long sum = sec - first;

      System.out.println("Insert, time: " + sum);
      assertTrue(sum < 60);
   }

   @Test
   public void decrease_keyTime() {
      Node[] dec = new Node[100000];
      Node prev = null;
      for (int i = 0; i < dec.length; i++) {
         Node x = new Node(i + 3);
         if (prev != null) {
            x.setLeft(prev);
            prev.setRight(x);
         }
         prev = x;
         dec[i] = x;
      }
      Fibonacci f_dec = new Fibonacci(dec[0]);
      long first = System.currentTimeMillis();
      for (int j = 99999; j > 0; j--) {
         f_dec.dec_key(dec[j], j - 100);
      }
      long sec = System.currentTimeMillis();
      long sum = sec - first;

      System.out.println("Decrease key, time: " + sum);
      assertTrue(sum < 100);
   }

   @Test
   public void linkTime() {
      Node[] link = new Node[100000];
      Node prev = null;
      for (int i = 0; i < link.length; i++) {
         Node x = new Node(i + 3);
         if (prev != null) {
            x.setLeft(prev);
            prev.setRight(x);
         }
         prev = x;
         link[i] = x;
      }
      Fibonacci f_link = new Fibonacci(new Node(0));
      long first = System.currentTimeMillis();

      for (int j = 0; j < link.length; j++) {
         f_link.link(f_link.getN(), link[j]);

      }
      long sec = System.currentTimeMillis();
      long sum = sec - first;

      System.out.println("Link(same as merge), time: " + sum);
      assertTrue(sum < 100);
   }
}