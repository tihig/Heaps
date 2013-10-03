package Heaps;

import BuildHeaps.Node;

public class Fibonacci {

    private Node n;
    private int min;
    private int d;

    public Fibonacci(Node n) {
        this.n = n;
        this.min = n.getKey();
        this.d = 0;
    }

    public Node getN() {
        return n;
    }

    public int getMin() {
        return min;
    }

    public void decrease_key(Node x, int newk) {
        if (x == null) {
            return;
        }
        if (newk < x.getKey()) {
            x.setKey(newk);
            Node parent = x.getP();
            if (parent != null && parent.getKey() > x.getKey()) {
                cut(x, parent);
                cascading_cut(parent);

            }
            if (x.getKey() < this.min) {
                cut(x, parent);
                this.min = x.getKey();
                x.setLeft(n);
                n.setRight(x);
                n = x;
            }
        }
    }

    public void delete(Node x) {
        if (x == null) {
            return;
        }

        decrease_key(x, Integer.MIN_VALUE);
        extract_min();
        if (n != null) {
            n.moveChild();
        }

    }

    public void insert(Node k) {
        if (k == null) {
            return;
        }
        if (min > k.getKey()) {
            k.setChild(n);
            n.setP(k);
            n = k;
        } else {
            n.setLeft(k);
            k.setRight(n);
        }


    }

    public void consolidate() {
        Node A[] = new Node[256];
        Node x = n;
        while (x != null) {
            int degree = x.getDegree();
            while (A[degree] != null) {
                Node y = A[degree];
                if (x.getKey() > y.getKey()) {
                    Node yLeft = y.getLeft();
                    Node yRight = y.getRight();
                    y.setLeft(x.getLeft());
                    y.setRight(x.getRight());
                    x.setLeft(yLeft);
                    x.setRight(yRight);
                }
                link(y, x);
                A[degree] = null;
                degree = degree + 1;

            }
            A[degree] = x;
            x = x.getLeft();
        }
        min = 0;
    }

    public void cut(Node x, Node parent) {
        if (x == null || parent == null) {
            return;
        }
        int place = x.getPlace();
        parent.getChild()[place] = null;
        parent.setC(parent.getC() - 1);
        x.setP(null);
        x.setMark(false);
        if (parent.getLeft() != null) {
            if (parent.getLeft() != x) {
                parent.getLeft().setRight(x);
                x.setLeft(parent.getLeft());
            }
            parent.setLeft(x);
            x.setRight(parent);
            parent.getChild()[place] = null;
        }
        parent.setLeft(x);
        x.setRight(parent);

    }

    public void cascading_cut(Node x) {
        if (x == null) {
            return;
        }
        Node z = x.getP();
        if (z != null) {
            if (!x.isMark()) {
                x.setMark(true);
            } else {
                cut(x, z);
                cascading_cut(z);
            }
        }

    }

    public Node extract_min() {
        if (n != null) {
            Node z = n;
            if (z.getChild() != null) {
                Node[] childs = z.getChild();
                for (int i = 0; i <= z.getC(); i++) {
                    Node n = childs[i];
                    if (n == null) {
                        n.setRight(z);
                        n.setLeft(z.getLeft());
                        z.setLeft(n);
                        n.setP(null);
                    }
                }
            }
            if (z.getP() != null) {
                z.getP().getChild()[z.getPlace()] = null;
            }
            if (z.getLeft() == null) {
                this.n = null;
                this.min = 0;
            } else {
                n = z.getLeft();
                n.setRight(null);
                consolidate();
            }
        }
        return n;
    }

    public void link(Node y, Node x) {
        if (y == null) {
            return;
        }
        Node yLeft = y.getLeft();
        Node yRight = y.getRight();

        y.setLeft(null);
        y.setRight(null);

        if (yLeft != null) {
            yLeft.setRight(yRight);
        }

        if (yRight != null) {
            yRight.setLeft(yLeft);
        }

        x.setChild(y);
        y.setP(x);

        x.setDegree(x.getDegree() + 1);
        y.setMark(false);

    }
}
