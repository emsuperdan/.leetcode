package 二叉树;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class TreeNodeTest {
    

    public static void main(String[] args) throws Exception {
        TreeNode head = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        head.right = node1;
        node1.left = node2;
        System.out.println(preorderTraversal2(head).toString());
    }

    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        preorder(root, list);
        return list;
    }

    public static void preorder(TreeNode root, List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        preorder(root.left, list);
        preorder(root.right, list);
    }

    public static List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        //栈不为空或节点不为空
        while(!stack.isEmpty() || root != null){
            //把所有子节点和左节点入栈并打印
            while(root != null){
                list.add(root.val);
                stack.push(root);
                root = root.left;
            }
            //把所有子节点和左节点出栈
            root = stack.pop();
            //把所有右节点入栈(如果右节点有左子结点则重复上述步骤入栈),保证了右节点最后遍历
            root = root.right;
        }
        return list;
    }


    static class TreeNode {
             int val;
             TreeNode left;
             TreeNode right;
             TreeNode() {}
             TreeNode(int val) { this.val = val; }
             TreeNode(int val, TreeNode left, TreeNode right) {
                 this.val = val;
                 this.left = left;
                 this.right = right;
             }
         }

}


