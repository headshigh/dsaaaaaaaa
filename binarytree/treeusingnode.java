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

class Pair {

  Node node;
  int h;

  public Pair(Node node_val, int h) {
    this.h = h;
    node = node_val;
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

  //for boundry traversal

  //add left boundry--go left if no left go right
  public static void addLeftBoundry(Node root, ArrayList<Integer> res) {
    Node curr = root.left;
    while (curr != null) {
      if (curr.left != null || curr.right != null) { //not a leaf node
        res.add(curr.key);
      }
      if (curr.left != null) {
        curr = curr.left;
      } else {
        curr = curr.right;
      }
    }
  }

  //add right boundry --we just keep adding all right elements and if there are none right we add left to a new arraylist then we access the elements of array list from last  and  insert at these elements in arraylist to be returned. .
  public static void addRightBoundry(Node root, ArrayList<Integer> res) {
    Node curr = root.right;
    ArrayList<Integer> temp = new ArrayList<Integer>();
    while (curr != null) {
      if (curr.left != null || curr.right != null) {
        temp.add(curr.key);
      }
      if (curr.right != null) {
        curr = curr.right;
      } else {
        curr = curr.left;
      }
    }
    int i;
    for (i = temp.size() - 1; i >= 0; --i) {
      res.add(temp.get(i));
    }
  }

  //if leaf node add to list,else go check for it's right and left part to be node
  public static void addLeaves(Node root, ArrayList<Integer> res) {
    if (root.left == null && root.right == null) {
      res.add(root.key);
      return;
    }
    if (root.left != null) {
      addLeaves(root.left, res);
    }
    if (root.right != null) {
      addLeaves(root.right, res);
    }
  }

  public static ArrayList<Integer> printBoundry(Node node) {
    ArrayList<Integer> ans = new ArrayList<Integer>();
    //check if the given root was leaf node itself or not;
    if (node.left == null && node.right == null) {
      ans.add(node.key);
    }
    //real test begins here first add left boundry
    addLeftBoundry(node, ans);
    //add leaf nodes (of the bottom) function checks and add all leaf node starting form given root
    addLeaves(node, ans);
    addRightBoundry(node, ans);
    return ans;
  }

  //for boundry traversal ^^^^^^^^^

  //for top view
  public static void topview(Node root) {
    Queue<Pair> queue = new LinkedList<>();
    queue.add(new Pair(root, 0));
    Stack<Integer> leftstack = new Stack<>();
    ArrayList<Integer> right = new ArrayList<>();
    int hd = 0; //horizontal line
    int l = 0;
    int r = 0;
    while (!queue.isEmpty()) {
      Pair p = queue.peek();
      //left part ma p.h is less than height so
      if (p.h < l) {
        leftstack.add(p.node.key);
        l = p.h;
      }
      if (p.h > r) {
        right.add(p.node.key);
        r = p.h;
      }
      if (p.node.left != null) {
        queue.add(new Pair(p.node.left, hd - 1));
      }
      if (p.node.right != null) {
        queue.add(new Pair(p.node.right, hd + 1));
      }
      queue.poll();
    }
    while (!leftstack.isEmpty()) {
      System.out.print(leftstack.peek() + " ");
      leftstack.pop();
    }

    // then printing the root node's data
    System.out.print(root.key + " ");

    // finally printing the right node's data
    for (int d : right) {
      System.out.print(d + " ");
    }
  }

  //root to  node
  public boolean getPath(Node root, ArrayList<Integer> arr, int x) {
    if (root == null) {
      return false;
    }
    arr.add(root.key);
    if (root.key == x) {
      return true;
    }
    if (getPath(root.left, arr, x) || getPath(root.right, arr, x)) {
      return true;
    }
    arr.remove(arr.size() - 1);
    return false;
  }

  //root to leaf
  public static void printRootTOLeafPaths(Node node, ArrayList<Integer> path) {
    if (node == null) {
      return;
    }
    path.add(node.key);
    if (node.left == null && node.right == null) {
      System.out.println(path);
    }
    printRootTOLeafPaths(node.left, path);
    printRootTOLeafPaths(node.right, path);
    path.remove(path.size() - 1);
  }

  public ArrayList<ArrayList<Integer>> Paths(Node root) {
    // Code here
    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
    ArrayList<Integer> list = new ArrayList<>();
    addleaf(root, list, ans);
    return ans;
  }

  public void addleaf(
    Node root,
    ArrayList<Integer> list,
    ArrayList<ArrayList<Integer>> ans
  ) {
    if (root == null) {
      return;
    }
    list.add(root.key);
    if (root.right == null && root.left == null) {
      System.out.println(list);
      list.remove(list.size() - 1);
      return;
      // System.out.println(ans);
    }
    //if it is not leaf node we go first to left and check for root nodes ,we pass the same list as we need to keep adding
    //once these recursion calls finish, it means we have found a leaf node thus we need to backtracck i.e remove the element we added in that recursion call so list gets emptied for other call
    addleaf(root.left, list, ans);
    addleaf(root.right, list, ans);
    list.remove(list.size() - 1);
  }

  public static void main(String[] args) {
    Binarytree tree = new Binarytree(1);
    // tree.root.left = new Node(2);
    // tree.root.right = new Node(3);
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
    // int[] sum = new int[1];
    // System.out.println(findmaxsum(tree.root, sum));
    // ArrayList<Integer>dummy=new ArrayList<>();
    // System.out.println(printBoundry(tree.root));
    // topview(tree.root);
    // // root to node samma print
    // ArrayList<Integer> arr = new ArrayList<>();
    // tree.getPath(tree.root, arr, 2);
    // System.out.println(arr);
    // ArrayList<Integer> toleaf = new ArrayList<>();
    // printRootTOLeafPaths(tree.root, toleaf);
    // System.out.println(Paths(tree.root));
    System.out.println(tree.Paths(tree.root));
    System.out.println("height of tree " + height(tree.root));
  }
}
