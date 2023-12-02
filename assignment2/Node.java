package assignment2;

public class Node {
    Object value;
    Node next;
    Node prev;

    public Node(int new_value, Node new_next, Node new_prev) {
        value = new_value;
        next = new_next;
        prev = new_prev;
    }

}
