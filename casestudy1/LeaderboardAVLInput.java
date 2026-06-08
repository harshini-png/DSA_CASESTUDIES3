package casestudy1;

import java.util.*;

class RankNode {
    int key;
    RankNode left, right;
    int height;
    int size;

    RankNode(int key) {
        this.key = key;
        this.height = 1;
        this.size = 1;
    }
}

public class LeaderboardAVLInput {

    // ---------- Utilities ----------
    static int height(RankNode n) {
        return (n == null) ? 0 : n.height;
    }

    static int size(RankNode n) {
        return (n == null) ? 0 : n.size;
    }

    static void update(RankNode n) {
        if (n != null) {
            n.height = 1 + Math.max(height(n.left), height(n.right));
            n.size = 1 + size(n.left) + size(n.right);
        }
    }

    // ---------- Rotations ----------
    static RankNode rightRotate(RankNode y) {
        RankNode x = y.left;
        RankNode T2 = x.right;

        x.right = y;
        y.left = T2;

        update(y);
        update(x);

        return x;
    }

    static RankNode leftRotate(RankNode x) {
        RankNode y = x.right;
        RankNode T2 = y.left;

        y.left = x;
        x.right = T2;

        update(x);
        update(y);

        return y;
    }

    static int getBalance(RankNode n) {
        return (n == null) ? 0 : height(n.left) - height(n.right);
    }

    // ---------- Insert ----------
    static RankNode insert(RankNode node, int key) {

        if (node == null)
            return new RankNode(key);

        // DESC order (higher scores on left)
        if (key > node.key)
            node.left = insert(node.left, key);
        else if (key < node.key)
            node.right = insert(node.right, key);
        else
            return node;

        update(node);

        int balance = getBalance(node);

        // LL
        if (balance > 1 && key > node.left.key)
            return rightRotate(node);

        // RR
        if (balance < -1 && key < node.right.key)
            return leftRotate(node);

        // LR
        if (balance > 1 && key < node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // RL
        if (balance < -1 && key > node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    // ---------- Delete ----------
    static RankNode delete(RankNode root, int key) {

        if (root == null)
            return null;

        if (key > root.key)
            root.left = delete(root.left, key);
        else if (key < root.key)
            root.right = delete(root.right, key);
        else {
            if (root.left == null || root.right == null) {
                RankNode temp = (root.left != null) ? root.left : root.right;
                return temp;
            } else {
                RankNode temp = root.left;
                while (temp.right != null)
                    temp = temp.right;

                root.key = temp.key;
                root.left = delete(root.left, temp.key);
            }
        }

        update(root);

        int balance = getBalance(root);

        // LL
        if (balance > 1 && getBalance(root.left) >= 0)
            return rightRotate(root);

        // LR
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // RR
        if (balance < -1 && getBalance(root.right) <= 0)
            return leftRotate(root);

        // RL
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // ---------- Rank ----------
    static int rankOf(RankNode root, int key) {
        int rank = 1;

        while (root != null) {

            if (key == root.key) {
                rank += size(root.left);
                return rank;
            }

            if (key > root.key)
                root = root.left;
            else {
                rank += 1 + size(root.left);
                root = root.right;
            }
        }

        return rank;
    }

    // ---------- Display ----------
    static void inorder(RankNode root) {
        if (root == null)
            return;
        inorder(root.left);
        System.out.print(root.key + "(" + root.size + ") ");
        inorder(root.right);
    }

    // ---------- MAIN (USER INPUT) ----------
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        RankNode root = null;

        System.out.println("Enter number of initial scores:");
        int n = sc.nextInt();

        System.out.println("Enter scores:");
        for (int i = 0; i < n; i++) {
            root = insert(root, sc.nextInt());
        }

        System.out.println("\nAVL Tree (inorder):");
        inorder(root);

        System.out.println("\n\nEnter score to find rank:");
        int key = sc.nextInt();
        System.out.println("Rank = " + rankOf(root, key));

        System.out.println("\nEnter delete value:");
        int del = sc.nextInt();
        root = delete(root, del);

        System.out.println("\nAfter deletion:");
        inorder(root);

        System.out.println("\n\nEnter new score to insert:");
        int ins = sc.nextInt();
        root = insert(root, ins);

        System.out.println("\nFinal Tree:");
        inorder(root);

        sc.close();
    }
}