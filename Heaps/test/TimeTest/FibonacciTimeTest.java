package TimeTest;

import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import Heaps.Fibonacci;
import Heaps.Helper;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class FibonacciTimeTest {

    private Node n1;
    private Fibonacci f1;
    private Node n2;
    private Fibonacci f2;
    private Helper help;

    public FibonacciTimeTest() {
        this.help = new Helper();
    }

    @BeforeClass
    public static void className() {
        System.out.println("");
        System.out.println("///Fibonacci times:");
        System.out.println("");
    }

    @Before
    public void setUp() {
        this.n1 = new Node(null, 1, 2);
        n1.setChild(new Node(n1, 1, 4));
        n1.setChild(new Node(n1, 1, 5));
        this.f1 = new Fibonacci(n1);
        this.n2 = help.buildConsolidateHeap();
        this.f2 = new Fibonacci(n2);
    }

    @Test
    public void get_minTime() {
        long first = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            f1.getN();
        }

        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Get min, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void del_minTime() {
        long first = System.currentTimeMillis();
        for (int i = 0; i < 40; i++) {
            f2.extract_min();
        }

        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Delete min, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void insertTime() {
        Node[] ins = new Node[100000];
        for (int i = 0; i < ins.length; i++) {
            Node x = new Node(null, 0, i + 3);
            ins[i] = x;
        }
        long first = System.currentTimeMillis();
        for (int i = 0; i < 100000; i++) {
            f1.insert(ins[i]);
        }
        long sec = System.currentTimeMillis();
        long sum = sec - first;

        System.out.println("Insert, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void decrease_keyTime() {
        long first = System.currentTimeMillis();
        Node x = n2;
        for (int i = 0; i < 40; i++) {
            x = x.getLeft();
            f2.decrease_key(x, i - 2);
        }
        long sec = System.currentTimeMillis();
        long sum = sec - first;

        System.out.println("Decrease key, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void consolidateTime() {
        Node n = help.buildConsolidateHeap();
        Node x = help.buildConsolidateHeap();
        long first = System.currentTimeMillis();
        Fibonacci fc = new Fibonacci(x);

        fc.consolidate();


        long sec = System.currentTimeMillis();
        long sum = sec - first;

        System.out.println("Consolidate, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void fibonacciTime() {
        Node n = help.buildConsolidateHeap();
        long first = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            f1.getN();
        }

        for (int i = 0; i < 40; i++) {
            f2.extract_min();
        }

        for (int i = 0; i < 40; i++) {
            Node x = new Node(null, 0, i + 3);
            f1.insert(x);
        }

        Node x = n2;
        for (int i = 0; i < 20; i++) {
            x = x.getLeft();
            f2.decrease_key(x, i - 2);
        }

        Fibonacci fc = new Fibonacci(n);
        fc.consolidate();
        long sec = System.currentTimeMillis();
        long sum = sec - first;

        System.out.println("Fibonacci, time: " + sum);
        assertTrue(sum < 20);
    }
}