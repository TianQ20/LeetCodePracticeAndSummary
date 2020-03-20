package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;


    // Iterative Queue based Java program to do level order traversal


    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    /* Class to print Level Order Traversal */
    class BinaryTree {

        Node root;


        void printLevelOrder() {
            Queue<Node> queue = new LinkedList<Node>();
            queue.add(root);
            while (!queue.isEmpty()) {

                Node tempNode = queue.poll();
                System.out.print(tempNode.data + " ");

                // Enqueue left child
                if (tempNode.left != null) {
                    queue.add(tempNode.left);
                }

                // Enqueue right child
                if (tempNode.right != null) {
                    queue.add(tempNode.right);
                }
            }
        }


    // Test
    public static void main(String args[])
    {
        /* creating a binary tree and entering
         the nodes */
        BinaryTree tree_level = new BinaryTree();
        tree_level.root = new Node(1);
        tree_level.root.left = new Node(2);
        tree_level.root.right = new Node(3);
        tree_level.root.left.left = new Node(4);
        tree_level.root.left.right = new Node(5);

        System.out.println("Level order traversal of binary tree is - ");
        tree_level.printLevelOrder();
    }
}
