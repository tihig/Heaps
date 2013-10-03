
import BuildHeaps.HeapControl;
import BuildHeaps.Node;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

public class HeapControlTest {

    private int[] numbers;
    private HeapControl hc;
    private Node h;

    public HeapControlTest() {
        numbers = new int[]{1, 3, 4, 5, 7, 8};
        hc = new HeapControl();

    }

    @Before
    public void setUp() {
        h = hc.buildHeap(2);
    }

    @Test
    public void buildHeapTest1() {
        assertEquals(2, h.getKey());
    }
}