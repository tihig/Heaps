package Heaps;

import BuildHeaps.Node;

public class Helper {

    // possible class for initializing methods etc.
    public Helper() {
    }

    public Node buildTestHeap() {

        Node node = new Node(null, 0, 0);

        Node prev = null;

        for (int i = 0; i < 11; i++) {
            node = new Node(null, i, i);
            for (int j = 0; j < i; j++) {
                Node c = node;
                c.setChild(new Node(c, j, i + 3));
                c = c.getChild()[0];
            }
            node.setRight(prev);
            if (prev != null) {
                prev.setLeft(node);
            }
            prev = node;

        }

        return rewind(node);
    }

    public Node buildConsolidateHeap() {
        Node node = new Node(null, 1, 0);
        node.setChild(new Node(node, 0, 1));
        node.getChild()[0].setChild(new Node(node, 0, 2));

        node.setRight(null);
        Node prev = node;

        int val = 3;
        int times = 2;
        for (int i = 0; i < 5; i++) {
            node = new Node(null, times, val + 3);
            int lvl = times - 1;
            Node ptr = node;
            for (int j = 0; j < times; j++) {
                Node c = new Node(ptr, lvl, val);
                ptr.setChild(c);
                ptr = ptr.getChild()[0];
                lvl--;
                val++;
            }
            node.setRight(prev);
            prev.setLeft(node);
            prev = prev.getLeft();

            times = times * 2;
        }
        return rewind(node);
    }

    public Node rewind(Node node) {

        while (node.getRight() != null) {
            node = node.getRight();
        }
        return node;
    }
}
