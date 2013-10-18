
import Heaps.Binary;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BinaryTest {

    private int[] heap = {Integer.MIN_VALUE,1, 2, 3, Integer.MAX_VALUE, Integer.MAX_VALUE, Integer.MAX_VALUE};
    private Binary bin;
    private Binary hf;

    public BinaryTest() {
    }

    @Before
    public void setUp() {
        this.bin = new Binary(heap, 2);
        int[] h = {Integer.MIN_VALUE,2, 1, 3};
        this.hf = new Binary(h, 3);
    }

    @Test
    public void getMinTest() {
        assertEquals(1, bin.getMin());
    }

    @Test
    public void HeapifyTest() {
        hf.heapify(1);
        assertEquals(1, hf.getMin());
    }

    @Test
    public void del_min_Test() {
        bin.del_min();
        assertEquals(2, bin.getMin());
    }

    @Test
    public void dec_key_Test() {
        Binary dec = new Binary(new int[]{Integer.MIN_VALUE,1, 3, 4, 5}, 4);
        dec.dec_key(3, -1);
        assertEquals(-1, dec.getHeap()[1]);
    }
     @Test
    public void dec_key_Test2() {
        Binary dec = new Binary(new int[]{Integer.MIN_VALUE,1, 3, 4, 5}, 4);
        dec.dec_key(3, 2);
        assertEquals(2, dec.getHeap()[3]);
    }

    @Test
    public void lengthTest() {
        Binary full = new Binary(new int[]{1, 2}, 1);
        full.moreLength();
        assertEquals(3, full.getHeap().length);

    }

    @Test
    public void insertTest() {
        bin.insert(4);
        assertEquals(4, bin.getHeap()[3]);
    }

    @Test
    public void mergeTest() {
        Binary m = new Binary(new int[]{Integer.MIN_VALUE,2, 4, 5, 7, Integer.MAX_VALUE}, 4);
        bin.merge(m);
        assertEquals(5, bin.getHeap_size());
    }
}