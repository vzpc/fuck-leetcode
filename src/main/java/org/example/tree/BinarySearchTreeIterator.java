package org.example.tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTreeIterator {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(7, new TreeNode(3), new TreeNode(15));
        BSTIterator bstIterator = new BSTIterator(root);
        System.out.println(bstIterator.next());
        System.out.println(bstIterator.hasNext());
    }
}

class BSTIterator {

    private List<Integer> list = new ArrayList<>();

    public BSTIterator(TreeNode root) {
        inorderTraversal(root, list);
    }

    private void inorderTraversal(TreeNode root, List<Integer> result) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            inorderTraversal(root.left, result);
        }
        result.add(root.val);
        if (root.right != null) {
            inorderTraversal(root.right, result);
        }
    }

    public int next() {
        return list.remove(0);
    }

    public boolean hasNext() {
        return !list.isEmpty();
    }
}
