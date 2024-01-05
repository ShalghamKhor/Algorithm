package assignment2.task2;

public class AvlTree {
    Node root;
    boolean isDeleted;

    public AvlTree(){
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

        return rebalance(current);
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

        if(current != null){
            current.height = 1 + Math.max(height(current.left), height(current.right));
            current = rebalance(current);
        }

        return current;
    }

    public Node smallestNode(Node node){
        Node currentNode = node;
        while (currentNode.left != null){
            currentNode = currentNode.left;
        }
        return currentNode;
    }

    public Node rebalance(Node node){
        int balanceFactor = balanceFactor(node);

        // Left heavy
        if (balanceFactor > 1){
            // Left-Left
            if (balanceFactor(node.left) >= 0){
                return rightRotation(node);
            }
            // Left-right
            else {
                node.left = leftRotation(node.left);
                return rightRotation(node);
            }
        }
        //right heavy
        else if(balanceFactor < -1){
            //right-right
            if (balanceFactor < 0){
                return leftRotation(node);
            }
            // right-left
            else {
                node.right = rightRotation(node.right);
                return leftRotation(node);
            }
        }
        return node;
    }


    public Node leftRotation(Node node){
        Node sub_root = node.right;
        Node leftSubTree = sub_root.left;

        sub_root.left = node;
        node.right = leftSubTree;

        node.height = 1 + Math.max(height(node.left), height(node.right));
        sub_root.height = 1 + Math.max(height(sub_root.left), height(sub_root.right));

        return sub_root;
    }

    public Node rightRotation(Node node){
        Node sub_root = node.left;
        Node rightSubTree = sub_root.right;

        sub_root.right = node;
        node.left = rightSubTree;
        node.height = 1 + Math.max(height(node.left), height(node.right));
        sub_root.height = 1 + Math.max(height(sub_root.left), height(sub_root.right));

        return sub_root;
    }

    public int balanceFactor(Node current){
        if (current.height == 0){
            return 0;
        }
        return height(current.left) - height(current.right);

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
