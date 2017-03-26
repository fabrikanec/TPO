package algoritm;

import java.lang.Comparable;
import java.util.ArrayList;
import java.util.List;

public class FibonacciHeap<T extends Comparable<T>> {

    private Node<T> min;
    private int     size;

    public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {
        private Node<T> parent;
        private Node<T> left;
        private Node<T> right;
        private Node<T> child;
        private boolean mark;
        private int     degree;
        public T       key;

        public Node(T key) {
            parent   = null;
            child    = null;
            this.key = key;
            mark     = false;
            degree   = 0;
            left = right = this;
        }

        @Override
        public int compareTo(Node<T> t) {
            return key.compareTo(t.key);
        }
    }

    public FibonacciHeap() {
        min = null;
        size = 0;
    }

    public FibonacciHeap(T key) throws IllegalArgumentException {
        if (key == null) {
            throw new IllegalArgumentException();
        }

        min = new Node<>(key);
        size = 1;
    }

    public Node<T> getMin() {
        return min;
    }

    public int getSize() {
        return size;
    }

    public void insert(T key) {
        Node<T> n = new Node<>(key);

        min = mergeLists(min, n);

        if (min != null) {
            size++;
        }
    }

    public void merge(FibonacciHeap<T> other) throws IllegalArgumentException {
        if (other == null) {
            throw new IllegalArgumentException();
        }
        min = mergeLists(min, other.getMin());

        if (min != null) {
            size += other.getSize();
        }
    }

    public Node<T> extractMin() {
        Node<T> z = min;

        if (z != null) {
            if (z.child != null) {
                Node<T> child = z.child;
                mergeLists(z, child);
                for (Node x = z.child.right; x != z.child; x = x.right) {
                    x.parent = null;
                }
                child.parent.child = null;
            }
            removeFromRootList(z);

            if (z == z.right) {
                min = null;
            }
            else {
                min = z.right;
                consolidate();
            }

            size--;
        }

        return z;
    }

    public void decreaseKey(Node<T> node, T key) throws IllegalArgumentException {
        if (key == null || node == null) {
            throw new IllegalArgumentException();
        }

        if (key.compareTo(node.key) > 0) {
            throw new IllegalArgumentException("New key in node can not be greater than current");
        }

        node.key = key;
        Node<T> parent = node.parent;

        if (parent != null && parent.compareTo(node) > 0) {
            cut(node, parent);
            cascadingCut(parent);
        }

        if (min.compareTo(node) > 0) {
            min = node;
        }
    }

    public void delete(Node<T> node) throws IllegalArgumentException, IllegalStateException {
        if (node == null) {
            throw new IllegalArgumentException();
        }

        if (min == null) {
            throw new IllegalStateException();
        }

        Node<T> parent = node.parent;
        if (parent != null) {
            cut(node, parent);
            cascadingCut(parent);
        }
        min = node;
        extractMin();
    }

    private void cascadingCut(Node<T> parent) {
        Node<T> tmp = parent.parent;
        if (tmp == null) {
            return;
        }

        if (parent.mark) {
            cut(parent, tmp);
            cascadingCut(tmp);
        }
        else {
            parent.mark = true;
        }
    }

    private void cut(Node<T> node, Node<T> parent) {
        parent.degree--;
        removeFromList(node);

        node.parent = null;
        node.mark = false;
        mergeLists(min, node);
    }

    private Node<T> mergeLists(Node<T> base, Node<T> node) {
        if (base == null) {
            return node;
        }

        if (node == null) {
            return base;
        }

        Node<T> L = node.left;
        Node<T> R = base.right;
        base.right = node;
        node.left = base;
        L.right = R;
        R.left  = L;

        return (base.compareTo(node) > 0) ? node : base;
    }

    private void consolidate() {
        int arraySize = size + 1;
        List<Node<T>> array = new ArrayList<>(arraySize);

        for (int i = 0; i < arraySize; i++) {
            array.add(i, null);
        }

        Node<T> tmpMin  = min;
        Node<T> tmp     = min;

        do {
            Node<T> x = tmp;
            Node<T> nextTmp = tmp.right;

            int d = x.degree;

            while (array.get(d) != null) {
                Node<T> y = array.get(d);
                if (x.compareTo(y) > 0) {
                    Node<T> temp = x;
                    x = y;
                    y = temp;
                }

                if (y == tmpMin) {
                    tmpMin = tmpMin.right;
                }

                if (y == nextTmp) {
                    nextTmp = nextTmp.right;
                }

                linkHeap(y, x);
                array.set(d, null);
                d++;
            }

            array.set(d, x);
            tmp = nextTmp;
        } while (tmp != tmpMin);

        min = null;

        for (int i = 0; i < arraySize; i++) {
            if (array.get(i) != null) {
                min = mergeLists(min, array.get(i));
            }
        }
    }

    private void linkHeap(Node<T> y, Node<T> x) {
        removeFromList(y);
        x.degree++;
        x.child = mergeLists(y, x.child);
        y.mark = false;
        y.parent = x;
    }

    private void removeFromRootList(Node<T> node) {
        Node<T> before = node.left;
        Node<T> after  = node.right;

        before.right = after;
        after.left   = before;
    }

    private void removeFromList(Node<T> node) {
        removeFromRootList(node);

        node.left = node.right = node;
    }
}