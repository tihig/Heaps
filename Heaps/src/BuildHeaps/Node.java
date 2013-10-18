package BuildHeaps;

public class Node implements ListOperator {

    private int key;
    private Node left;
    private Node right;
    private Node parent;
    private Node[] child_list;
    private int child_length;
    private int degree;
    private int place;
    private boolean mark;

    public Node(int val) {
        this.key = val;
        this.left = null;
        this.right = null;
        this.parent = null;
        this.child_length = -1;
        this.child_list = new Node[1];
        this.degree = 0;
        this.place = -1;
        this.mark = false;
    }

   public boolean isMark() {
      return mark;
   }

   public void setMark(boolean mark) {
      this.mark = mark;
   }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public Node[] getChild_list() {
        return child_list;
    }

    public void setChild_list(Node[] child_list) {
        this.child_list = child_list;
    }

    public int getChild_length() {
        return child_length;
    }

    public void setChild_length(int child_length) {
        this.child_length = child_length;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public Node getLeft() {
        return left;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public Node getParent() {
        return parent;
    }

    public void setParent(Node parent) {
        this.parent = parent;
    }

   public int getPlace() {
      return place;
   }

   public void setPlace(int place) {
      this.place = place;
   }

    public Node[] getChild_List() {
        return child_list;
    }

    public void setChild_List(Node[] childs) {
        this.child_list = childs;
    }

    public void setChild(Node c) {
        this.setChild_length(child_length + 1);
        if (child_length >= child_list.length) {
            moreLength();
        }
        this.child_list[child_length] = c;
        c.setPlace(child_length);
    }

    public Node getChild(int i) {
        if (i >= this.child_list.length || i < 0) {
            return null;
        }
        return this.child_list[i];
    }

    @Override
    public void moreLength() {
        int new_size = child_list.length + (child_list.length / 2);
        if(new_size == 1){
           new_size = 2;
        }
        Node[] new_list = new Node[new_size];
        System.arraycopy(child_list, 0, new_list, 0, child_list.length);
        child_list = new_list;
    }
}
