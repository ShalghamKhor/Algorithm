package assignment2;

//import java.util.*;
//import assignment2.Node;

public class GenericDeque {
    Node first;
    Node last;
    int size;

    public void GenericDeque() {
        first = null;
        last = null;
        size = 0;
    }

    public void addFirst(int n) {
        if (first == null) {
            last = first = new Node(n, null, null);

        } else {
            first.prev = new Node(n, first, null);
            first = first.prev;
        }
        size += 1;
    }

    public void addLast(int n) {
        if (last == null) {
            first = last = new Node(n, null, null);
        } else {
            last.prev = new Node(n, null, last);
            last = last.prev;
        }
        size += 1;

    }

    public boolean isEmpty() {
        return first == null;
    }

    public int Size() {
        return size;
    }

}
