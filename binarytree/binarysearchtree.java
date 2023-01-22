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

  public static void main(String[] args) {
    binarysearchtree tree = new binarysearchtree(10);
    System.out.println(tree.root);
    tree.root.left = new Node(9);
    tree.root.right = new Node(11);
    tree.root.left.left = new Node(8);
    System.out.println(ceeling(tree.root, 11, Integer.MAX_VALUE));
    System.out.println(floor(tree.root, 12, Integer.MIN_VALUE));
  }
}
