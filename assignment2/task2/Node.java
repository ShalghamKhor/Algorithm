package assignment2.task2;

public class Node {

    int value;
    Node left;
    Node right;
    int height;

    Node(int value) {
        this.value = value;
        left = null;
        right = null;
        height = 1;
    }
}
