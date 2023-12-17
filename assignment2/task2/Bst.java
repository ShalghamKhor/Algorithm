package assignment2.task2;

public class Bst {
    Node root;
    Boolean isDeleted;

    public Bst() {
        root = null;
    }

    public void insert(int value) {
        root = insertion(root, value);
    }

    public Node insertion(Node current, int value) {
        if (current == null) {
            return new Node(value);
        }

        if (value < current.value) {
            current.left = insertion(current.left, value);
        } else if (value > current.value) {
            current.right = insertion(current.right, value);
        } else {
            return current;
        }
        current.height = 1 + Math.max(height(current.left), height(current.right));
        return current;
    }

    public void printTree() {
        print(root);
    }

    public void print(Node current) {
        if (current != null) {
            System.out.println(current.value);
            print(current.left);
            print(current.right);
        }
    }

    public void find(int value) {
        Node result = findRecursion(root, value);
        if (result == null){
            System.out.println("Value: " +value + " not found");
        }else {
            System.out.println("value: "+ value + " found");
        }
    }

    public Node findRecursion(Node current, int value) {
        if (current == null) {
            return null;
        }
        if (value == current.value) {
            return current;
        }
        else if (value < current.value) {
            return findRecursion(current.left, value);
        } else {
            return findRecursion(current.right, value);
        }
    }

    public void deleteNode(int value){
        isDeleted = false;
        root = deleteRecursion(root, value);
        /*
        if (isDeleted){
            System.out.println("Node was deleted: " + value);
        }else {
            System.out.println("Node with " + value + " does not exist!");
        }*/

    }
    public Node deleteRecursion(Node current, int value){
        if(current == null){
            return null;
        }
        if (value < current.value) {
            current.left = deleteRecursion(current.left, value);

        }
        else if (value > current.value){
            current.right = deleteRecursion(current.right, value);
        }
        else {
            if(current.left == null ){
                isDeleted = true;
                return current.right;
            } else if (current.right == null) {
                isDeleted = true;
                return current.left;
            }

            Node smallest = smallestNode(current.right);
            current.value = smallest.value;
            current.right = deleteRecursion(current.right, smallest.value);
            isDeleted = true;
        }
        current.height = 1 + Math.max(height(current.left), height(current.right));
        return current;
    }

    public Node smallestNode(Node node){
        Node currentNode = node;
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }
    public int height(Node node){
        if(node == null){
            return 0;
        }
        return node.height;
    }

    public int getHeight(){
        if(root == null){
            return 0;
        }
        return root.height;
    }
}