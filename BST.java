
import java.util.ArrayList;

public class BST {
    public static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = this.right = null;

        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }
        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void preorder(Node root) {
        if (root == null) {
            return;
        }
        System.out.print(root.data + "  ");
        preorder(root.left);
        preorder(root.right);
    }

    public static Node createBst(int arr[], int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(arr[mid]);
        root.left = createBst(arr, start, mid - 1);
        root.right = createBst(arr, mid + 1, end);
        return root;
    }

    public static void getInorder(Node root, ArrayList<Integer> inorder) {
        if (root == null) {
            return;
        }
        getInorder(root.left, inorder);
        inorder.add(root.data);
        getInorder(root.right, inorder);
    }

    public static Node createBST(ArrayList<Integer> inorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        Node root = new Node(inorder.get(mid));
        root.left = createBST(inorder, start, mid - 1);
        root.right = createBST(inorder, mid + 1, end);
        return root;
    }

    public static Node balancedBST(Node root) {
        ArrayList<Integer> inorder = new ArrayList<>();
        getInorder(root, inorder);
        root = createBST(inorder, 0, inorder.size() - 1);
        return root;

    }

    public static void main(String[] args) {
        // int arr[] = { 3, 5, 6, 8, 10, 11, 12 };
        // Node root = createBst(arr, 0, arr.length - 1);
        // preorder(root);
        // System.out.println();
        int arr[] = { 8, 6, 5, 3, 10, 11, 12 };
        Node root = null;
        for (int i = 0; i < arr.length; i++) {
            root = insert(root, arr[i]);
        }
        preorder(root);
        System.out.println();
        root = balancedBST(root);
        preorder(root);
        System.out.println();

    }

}
