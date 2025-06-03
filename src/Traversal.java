import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

public class Traversal {
  public static void main(String[] args) {
    TreeNode<Integer> root = new TreeNode<>(10, null, null);
    root.left = new TreeNode<>(15);
    root.left.left = new TreeNode<>(39);
    root.left.right = new TreeNode<>(21);

    root.right = new TreeNode<>(20);
    root.right.left = new TreeNode<>(72);
    root.right.left.right = new TreeNode<>(42);

    TreeNode<String> stringRoot = new TreeNode<>("hello", null, null);
    stringRoot.left = new TreeNode<>("cat");
    stringRoot.left.left = new TreeNode<>("Miku");
    stringRoot.left.right = new TreeNode<>("dog");
    stringRoot.right = new TreeNode<>("Cyborg");
    stringRoot.right.left = new TreeNode<>("Jay");
    stringRoot.right.left.right = new TreeNode<>("RoboCop");

    // preOrder(root);
    // System.out.println();
    // postOrder(root);
    // inOrder(stringRoot);
    // greaterThan(root, 25);

    TreeNode<Integer> megaRoot = new TreeNode<Integer>(1);
    TreeNode<Integer> current = megaRoot;

    for(int i = 2; i < 30001; i++){
      current.right = new TreeNode<Integer>(i);
      current = current.right;
    }


    // preOrderIter(root);
    // System.out.println("***************************************************");
    // levelOrder(root);

    Set<Integer> set = convertToSet(root);
    System.out.println(set);
  }

  public static <T> Set<T> convertToSet(TreeNode<T> root){
    Set<T> set = new HashSet<>();

    convertToSetHelper(root, set);

    return set;
  } 

  public static<T> void convertToSetHelper(TreeNode<T> current, Set<T> set) {
    if(current == null) return;

    set.add(current.value);
    convertToSetHelper(current.left, set);
    convertToSetHelper(current.right, set);
  }

  public static void preOrderIter(TreeNode<?> current){
    // stack =[]
    // stack.push(current)

    // while !stack.empty()
    //  node = stack.pop()
    //  if null
    //  print node.value
    //  stack.push(left)
    //  stack.push(right)

    Stack<TreeNode<?>> stack = new Stack();

    stack.push(current);

    while(!stack.empty()){
      TreeNode<?> node = stack.pop();
      if(node == null){
        continue;
      }

      System.out.println(node.value);
      stack.push(node.right);
      stack.push(node.left);

    }
  }

  public static void levelOrder(TreeNode<?> current){
    Queue<TreeNode<?>> queue = new LinkedList<>();
    queue.add(current);

    while (!queue.isEmpty()) {
      TreeNode<?> node = queue.poll();
      if(node != null) {
        System.out.println(node.value);
        queue.add(node.left);
        queue.add(node.right);
      }
    }
  }

  public static <E> void preOrder(TreeNode<E> current) {
    if (current == null) return;
    // TreeNode<E> duplicate = new TreeNode<>(current.value); 
    System.out.println(current.value);
    preOrder(current.left);
    preOrder(current.right);
  }

  public static void postOrder(TreeNode<?> current) {
    if (current == null) return;

    postOrder(current.left);
    postOrder(current.right);
    System.out.println(current.value);
  }

  public static void inOrder(TreeNode<?> current) {
    if (current == null) return;

    postOrder(current.left);
    System.out.println(current.value);
    postOrder(current.right);
  }

  public static void greaterThan(TreeNode<Integer> current, int compare){
    if(current == null) return;
    if(current.value > compare) System.out.println(current.value);

    greaterThan(current.left, compare);
    greaterThan(current.right, compare);
  }

  public static int countNode(TreeNode<?> current){
    if(current == null) return 0;
    return 1 + countNode(current.left) + countNode(current.right);
  }
}
  