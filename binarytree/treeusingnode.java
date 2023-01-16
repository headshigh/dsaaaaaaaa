package binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

class Node {

  int key;
  Node left, right;

  public Node(int key) {
    this.key = key;
    left = right = null;
  }
}

class Binarytree {

  public Node root;

  Binarytree(int key) {
    root = new Node(key);
  }

  public static void inordertraversal(Node node) {
    if (node == null) {
      return;
    }
    inordertraversal(node.left);
    System.out.println(node.key);
    inordertraversal(node.right);
  }

  public static void levelordertraversal(Node root, int level) {
    for (int i = 1; i <= height(root); i++) {
      printlevel(root, i);
      System.out.println();
    }
  }

  public static int height(Node root) {
    if (root == null) { //base case
      return 0;
    } else {
      int lheight = height(root.left);
      int rheight = height(root.right);
      //also add the se lines for checking balanced tree, if not balanced return -1 else reurns height of tree
      // if(lheight==-1 || lheight==-1) return -1;
      // if(Math.abs(lheight-rheight)>1) return -1;
      if (lheight > rheight) {
        return lheight + 1;
      } else {
        return rheight + 1;
      }
    }
  }

  public static void printlevel(Node root, int level) {
    if (root == null) {
      return;
    }
    if (level == 1) {
      System.out.print(root.key + " ");
    }
    printlevel(root.left, level - 1);
    printlevel(root.right, level - 1);
  }

  public void queuelevelorder() {
    Queue<Node> queue = new LinkedList<Node>();
    queue.add(root);
    while (!queue.isEmpty()) {
      Node currentNode = queue.poll();
      System.out.print(currentNode.key);
      if (currentNode.left != null) {
        queue.add(currentNode.left);
      }
      if (currentNode.right != null) {
        queue.add(currentNode.right);
      }
    }
  }

  public void stackpreorder() {
    Stack<Node> stack = new Stack<Node>();
    stack.push(root);
    while (stack.empty() == false) {
      Node current = stack.peek();
      System.out.print(current.key + " ");
      stack.pop();
      if (current.right != null) {
        stack.push(current.right);
      }
      if (current.left != null) {
        stack.push(current.left);
      }
    }
  }

  public void inorderstack() {
    Stack<Node> stack = new Stack<Node>();
    Node current = root;
    while (true) {
      if (current != null) {
        stack.push(current);
        current = current.left;
      } else {
        if (stack.isEmpty()) {
          break;
        }
        //if we get null we return back as in recursion
        current = stack.pop();
        System.out.println(current.key);
        current = current.right;
      }
    }
  }

  public static List<List<Integer>> zigzagtraversal(Node root) {
    List<List<Integer>> toreturn = new ArrayList<>();
    for (int i = 1; i <= height(root); i++) {
      List<Integer> insert = new ArrayList<>();

      zigzag(root, insert, i, i % 2 == 0 ? false : true);
      toreturn.add(insert);
    }
    return toreturn;
  }

  public static void zigzag(
    Node root,
    List<Integer> initiallist,
    int level,
    boolean isLtR
  ) {
    // List<List<Integer>> ans = new List<List<Integer>>();
    if (root == null) {
      return;
    }
    if (level == 1) {
      // System.out.print(root.key);
      // List<Integer> toadd = new ArrayList<Integer>();
      // toadd.add(root.key);
      // initiallist.add(toadd);
      initiallist.add(root.key);
    }
    if (isLtR == true) {
      zigzag(root.left, initiallist, level - 1, isLtR);
      zigzag(root.right, initiallist, level - 1, isLtR);
    } else {
      zigzag(root.right, initiallist, level - 1, isLtR);
      zigzag(root.left, initiallist, level - 1, isLtR);
    }
  }

  public void postorderstack() {
    Node curl = root;
    Stack<Node> st = new Stack<Node>();
    while (curl != null || !st.isEmpty()) {
      if (curl != null) {
        st.push(curl);
        curl = curl.left;
      } else {
        Node temp = st.peek().right;
        if (temp == null) {
          temp = st.peek();
          st.pop();
          System.out.print(temp.key);
          while (!st.isEmpty() && temp == st.peek().right) {
            temp = st.peek();
            st.pop();
            System.out.print(temp.key);
          }
        } else {
          curl = temp;
        }
      }
    }
  }

  public static boolean checkbalanced(Node root) {
    int leftheight = height(root.left);
    int rightheight = height(root.right);
    System.out.println(leftheight);
    System.out.println(rightheight);
    if (Math.abs(leftheight - rightheight) > 1) {
      return false;
    }
    return true;
  }

  public static int finddiameter(Node root, int maxi) {
    if (root == null) { //this in big o n square soln better solution is solved in leetcode
      return 0;
    }
    int lh = height(root.left);
    int rh = height(root.right);
    maxi = Math.max(maxi, lh + rh);
    maxi = Math.max(maxi, finddiameter(root.left, maxi));
    maxi = Math.max(maxi, finddiameter(root.right, maxi));
    return maxi;
  }

  public static int findmaxsum(Node root, int[] maxi) {
    if (root == null) {
      return 0;
    }
    int ls = Math.max(0, findmaxsum(root.left, maxi)); //if any part returns less than 0 we donot consider that part to be path of the sum
    int rs = Math.max(0, findmaxsum(root.right, maxi));
    maxi[0] = Math.max(maxi[0], ls + rs + root.key);
    return Math.max(ls, rs) + root.key;
  }

  public static void main(String[] args) {
    Binarytree tree = new Binarytree(3);

    tree.root.left = new Node(9);
    tree.root.right = new Node(20);
    tree.root.left.left = new Node(3);
    tree.root.left.right = new Node(4);
    tree.root.right.left = new Node(15);
    tree.root.right.right = new Node(7);
    tree.root.right.right.left = new Node(7);
    tree.root.right.right.left.left = new Node(7);
    tree.root.right.right.left.left.left = new Node(7);
    tree.root.right.right.left.left.left.left = new Node(7);
    // inordertraversal(tree.root);
    // levelordertraversal(tree.root, 3);
    // tree.queuelevelorder();
    // tree.stackpreorder();
    // tree.inorderstack();
    // tree.postorderstack();
    // System.out.println(zigzagtraversal(tree.root));
    // System.out.println(checkbalanced(tree.root));
    // System.out.println(finddiameter(tree.root, 0));
    int[] sum = new int[1];
    System.out.println(findmaxsum(tree.root, sum));

    System.out.println("height of tree " + height(tree.root));
  }
}
