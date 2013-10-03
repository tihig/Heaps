package BuildHeaps;

import Heaps.Binary;
import Heaps.Fibonacci;

public class HeapControl {

    private Node f;
    private Fibonacci fh;
    private Binary bh;

    public HeapControl() {
        this.fh = null;
        this.bh = null;
//      Node f = new Node(null, null, 0);
    }

    public Node buildHeap(int k) {
        return new Node(null, 0, k);
    }

    public Fibonacci getFh() {
        return fh;
    }

    public Binary getBh() {
        return bh;
    }

    public void setFh(Fibonacci fh) {
        this.fh = fh;
    }

    public void setBh(Binary bh) {
        this.bh = bh;
    }

    public void printBh() {
        if (bh == null) {
            return;
        }
        int[] heap = bh.getHeap();
        int h = 0;
        int x = heap[0];

        int i = 1;
        int j = 0;
        while (x != Integer.MAX_VALUE) {
            i--;
            if (heap[bh.left(h)] != Integer.MAX_VALUE) {
                System.out.print("_");
                j++;
            } else {
                System.out.print(" ");
            }
            System.out.print(x);
            if (heap[bh.right(h)] != Integer.MAX_VALUE) {
                System.out.print("_");
                j++;
            }
            if (i == 0) {
                System.out.println("");
                i = j;
                j = 0;
            }
            h++;
            x = heap[h];
        }
    }

    public void printFh() {
        Node x = fh.getN();
        while (x != null) {
            dfs(x);
            System.out.println("");
            x = x.getRight();
        }

    }

    public void dfs(Node x) {
        if (x == null) {
            return;
        }
        if (x.getChild() == null) {
            System.out.println(x.getKey());
            return;
        }
        Node[] childs = x.getChild();
        int length = childsLength(childs);

        System.out.print(x.getKey() + "");

        if (length > -1) {
            System.out.print(":");

            for (int i = 0; i < length; i++) {
                Node node = childs[i];
                if (node == null) {
                    break;
                }
                
                dfs(node);
            }

            System.out.println(", ");
        }
    }

    public int childsLength(Node[] list) {
        int i = 0;
        if (list[0] == null) {
            return -1;
        }
        while (list[i] != null) {
            if (i == list.length) {
                return list.length - 1;
            }
            i++;
        }
        return i;
    }
}
