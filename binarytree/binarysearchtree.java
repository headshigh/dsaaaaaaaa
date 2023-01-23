package binarytree;

class Node {

  int key;
  Node left, right;

  public Node(int key) {
    this.key = key;
    left = right = null;
  }
}

public class binarysearchtree {

  public Node root;

  binarysearchtree(int key) {
    root = new Node(key);
  }

  public static int ceeling(Node root, int val, int ceel) {
    if (root == null) {
      return ceel;
    }
    if (root.key == val) {
      ceel = val;
      return ceel;
    }
    if (root.key > val) {
      ceel = Math.min(root.key, ceel);
      return ceeling(root.left, val, ceel);
    }
    if (root.key < val) {
      ceeling(root.right, val, ceel);
    }

    return ceel;
  }

  public static int floor(Node root, int val, int floor) {
    if (root == null) {
      return floor;
    }
    if (root.key == val) {
      return root.key;
    }
    if (root.key > val) {
      return floor(root.left, val, floor);
    }
    if (root.key < val) {
      floor = Math.max(floor, root.key);
      return floor(root.right, val, floor);
    }
    return floor;
  }

  //construct binary tree with preorder
  public static Node constructBST(
    int[] preorder,
    int preorderstart,
    Node root,
    int upperbound
  ) {
    Node toreturn = null;
    if (preorderstart == 0) {
      root = new Node(preorder[preorderstart]);
      toreturn = root;

      preorderstart = preorderstart + 1;
    }
    root.left = helper(preorder, preorderstart, root.key);
    if (root.left == null) {
      root.right = helper(preorder, preorderstart, upperbound);
    } else {
      root.right = helper(preorder, preorderstart + 1, upperbound);
      if (root.right != null) {
        preorderstart += 1;
      }
    }

    constructBST(preorder, preorderstart, root.left, root.key);
    constructBST(preorder, preorderstart, root.right, upperbound);
    return toreturn;
  }

  public static Node helper(int[] preorder, int preorderstart, int upperbound) {
    if (preorder[preorderstart] < upperbound) {
      return new Node(preorder[preorderstart]);
    }
    return null;
  }

  /////////////////
  public static void inordertraversal(Node node) {
    if (node == null) {
      return;
    }
    inordertraversal(node.left);
    System.out.println(node.key);
    inordertraversal(node.right);
  }

  public static void main(String[] args) {
    binarysearchtree tree = new binarysearchtree(10);
    System.out.println(tree.root);
    tree.root.left = new Node(9);
    tree.root.right = new Node(11);
    tree.root.left.left = new Node(8);
    // System.out.println(ceeling(tree.root, 11, Integer.MAX_VALUE));
    // System.out.println(floor(tree.root, 12, Integer.MIN_VALUE));
    int[] preorder = { 8, 5, 1, 7, 10, 12 };
    constructBST(preorder, 0, null, Integer.MAX_VALUE);
  }
}
