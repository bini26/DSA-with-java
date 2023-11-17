public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (val < root.data) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;

        } else if (root.data > key) {
            return search(root.left, key);
        } else {
            return search(root.right, key);
        }
    }

    public static Node findInorderSuccessor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static Node delete(Node root, int val) {
        if (root.data < val) {
            root.right = delete(root.right, val);
        } else if (root.data > val) {
            root.left = delete(root.left, val);
        } else {
            // case 1:leaf node/no child
            if (root.left == null && root.right == null) {
                return null;
            }
            // case2:single child
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            // case 3:two children
            Node inorderSuccessor = findInorderSuccessor(root.right);
            root.data = inorderSuccessor.data;
            root.right = delete(root.right, inorderSuccessor.data);

        }
        return root;

    }

    public static void printInRange(Node root, int k1, int k2) {
        if (root == null) {
            return;
        }
        if (root.data >= k1 && root.data <= k2) {
            printInRange(root.left, k1, k2);
            System.out.print(root.data + "  ");
            printInRange(root.right, k1, k2);
        } else if (root.data <= k1) {
            printInRange(root.left, k1, k2);
        } else {
            printInRange(root.right, k1, k2);
        }
    }

    public static void inorder(Node root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        System.out.print(root.data + "  ");
        inorder(root.right);
    }

    public static void main(String args[]) {
        int values[] = { 8, 5, 3, 1, 4, 6, 10, 11, 14 };
        Node root = null;
        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inorder(root);
        System.out.println();
        // System.out.println(search(root, 8));
        // delete(root, 5);
        // System.out.println();
        // inorder(root);
        printInRange(root, 5, 12);

    }

}
