package assignment2.task2;

import timer.timer;

import java.util.Random;

public class test {

    public void tes(){

        int[] nodes = {10, 100, 1000, 10000};
        Random random = new Random();
        timer timer = new timer();

        for (int i : nodes) {
            AvlTree avlTree = new AvlTree();
            Bst bst = new Bst();

            // Insertion in AVL Tree and BST
            timer.startTime();
            for (int j = 0; j < i; j++) {
                int node = random.nextInt(i * 10); // Larger range for random numbers
                avlTree.insert(node);
            }
            timer.endTime();
            System.out.println("duration time for inserting " + i + " random nodes using AVL: " + timer.duration() + "ms");
            System.out.println("height of AVL tree with " + i + " nodes: " + avlTree.getHeight());

            timer.startTime();
            for (int j = 0; j < i; j++) {
                int node = random.nextInt(i * 10); // Larger range for random numbers
                bst.insert(node);
            }
            timer.endTime();
            System.out.println("duration time for inserting " + i + " random nodes using BST: " + timer.duration() + "ms");
            System.out.println("height of BST with " + i + " nodes: " + bst.getHeight());
            System.out.println();

            // Deletion in AVL Tree and BST
            timer.startTime();
            for (int j = 0; j < i; j++) {
                int node = random.nextInt(i * 10); // Larger range for random numbers
                avlTree.deleteNode(node);
            }
            timer.endTime();
            System.out.println("duration time for deleting " + i + " random nodes using AVL: " + timer.duration() + "ms");

            timer.startTime();
            for (int j = 0; j < i; j++) {
                int node = random.nextInt(i * 10); // Larger range for random numbers
                bst.deleteNode(node);
            }
            timer.endTime();
            System.out.println("duration time for deleting " + i + " random nodes using BST: " + timer.duration() + "ms");
            System.out.println();
        }
    }
}
