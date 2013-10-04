package Heaps;

import BuildHeaps.Node;

public class Fibonacci {

    private Node n;

    public Fibonacci(Node n) {
        this.n = n;
    }

    public Node getN() {
        return n;
    }

    public int getMin() {
        if (n == null) {
            return 0;
        }
        return n.getKey();
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
            if (x.getKey() < getMin()) {
                Node left = null;
                Node right = null;
                if (x.getLeft() != null) {
                    left = x.getLeft();
                }
                if (x.getRight() != null) {
                    right = x.getRight();
                }
                x.setLeft(n);
                x.setRight(null);
                n.setLeft(left);
                n.setRight(right);
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
        if (n != null && n.getChild() != null) {
            n.moveChild();
        }

    }

    public void insert(Node k) {
        if (k == null) {
            return;
        }
        if (getMin() > k.getKey()) {
            k.setChild(n);
            n.setP(k);
            n = k;
        } else {
            if (n.getLeft() != null) {
                n.getLeft().setRight(k);
                k.setLeft(n.getLeft());
            }
            n.setLeft(k);
            k.setRight(n);
        }
//        consolidate();
    }

    public void consolidate() {
        Node A[] = new Node[256];
        Node x = n;
        int val = 0;
        while (x != null) {
            int degree = x.getDegree();
            while (A[degree] != null) {
                Node y = A[degree];
                if (x.getKey() > y.getKey()) {
                    int keyX = x.getKey();
                    x.setKey(y.getKey());
                    y.setKey(keyX);
                }
                link(y, x);
                A[degree] = null;
                degree = degree + 1;

            }

            A[degree] = x;
            val = degree;
            x = x.getLeft();
        }
        int i = val;
        while (A[i] != null) {
            if (i == 0) {
                n = A[i];
            } else if (A[i].getKey() < n.getKey()) {
                n.setRight(A[i]);
                A[i].setLeft(n);
                A[i].setRight(null);
                n = A[i];
            } else {
                Node left = n.getLeft();
                n.setLeft(A[i]);
                A[i].setRight(n);
                A[i].setLeft(left);
                if (left != null) {
                    left.setRight(A[i]);
                }
            }
            i++;
        }
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
                    Node child = childs[i];
                    if (child != null) {
                        child.setRight(z);
                        child.setLeft(z.getLeft());
                        z.setLeft(child);
                        child.setP(null);
                    }
                }
            }
            if (z.getP() != null) {
                z.getP().getChild()[z.getPlace()] = null;
            }
            if (z.getLeft() == null && z.getRight() == null) {
                this.n = null;
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
