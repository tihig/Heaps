package TimeTest;

import Heaps.Binary;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;

public class BinaryTimeTest {

    private int[] heap = {1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    private Binary bin;
    private Binary hf;
    private Binary b;

    public BinaryTimeTest() {
    }

    @BeforeClass
    public static void className() {
        System.out.println("");
        System.out.println("///Binary times:");
        System.out.println("");
    }

    @Before
    public void setUp() {
        this.bin = new Binary(heap, 2);
        int[] h = {8, 9, 1, 7, 2, 5, 6, 16, 4, 10, 3};
        this.hf = new Binary(h, 10);
        int[] minHeap = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
        this.b = new Binary(minHeap, 10);
    }

    @Test
    public void get_minTime() {
        long first = System.currentTimeMillis();
        for (int i = 0; i < 1000; i++) {
            bin.getMin();       
        }
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Get min, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void del_minTime() {
        long first = System.currentTimeMillis();
        for (int i = 0; i < 11; i++) {
            b.del_min();
        }
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Delete min, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void insertTime() {
        long first = System.currentTimeMillis();
        for (int i = 0; i < 10000; i++) {
            bin.insert(i + 4);

        }
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Insert, time: " + sum);
        assertTrue(sum < 10);
    }

    @Test
    public void dec_keyTime() {
        long first = System.currentTimeMillis();
        Binary dec = new Binary(new int[]{1, 3, 4, 5}, 4);
        dec.decrease_key(3, 2);
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Decrease key, time: " + sum);
        assertTrue(sum < 2);
    }

    @Test
    public void mergeTime() {
        int[] mergeHeap = new int[50];
        for (int i = 0; i < mergeHeap.length; i++) {
            if (i < 48) {
                mergeHeap[i] = i + 3;
            } else {
                mergeHeap[i] = Integer.MAX_VALUE;
            }
        }
        Binary m = new Binary(mergeHeap, 47);
        long first = System.currentTimeMillis();
        b.merge(m);
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Merge, time: " + sum);
        assertTrue(sum < 300);
    }

    @Test
    public void binaryTime() {
        int[] mergeHeap = new int[50];
        for (int i = 0; i < mergeHeap.length; i++) {
            if (i < 48) {
                mergeHeap[i] = i + 3;
            } else {
                mergeHeap[i] = Integer.MAX_VALUE;
            }
        }
        Binary m = new Binary(mergeHeap, 47);
        long first = System.currentTimeMillis();
         // merge
        b.merge(m);
        //get min
        for (int i = 0; i < 1000; i++) {
            bin.getMin(); 
        }
         // delete min
        for (int i = 0; i < 11; i++) {
            b.del_min();
        }
        // insert
        for (int i = 0; i < 10000; i++) {
            bin.insert(i + 4);
        }
        // decrease key
        for (int i = 0; i < 50; i++) {
            m.decrease_key(i, m.getHeap()[i]-(i+1));
        }
        long second = System.currentTimeMillis();
        long sum = second - first;
        System.out.println("Binary, time: " + sum);
        assertTrue(sum < 300);
    }

    @Test(timeout = 3)
    public void insertTime2() {
        for (int i = 0; i < 10000; i++) {
            bin.insert(i + 4);
        }
    }
}