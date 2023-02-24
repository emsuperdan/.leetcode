package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest13 {
    
    public static void main(String[] args) throws Exception {
        TreeNode head = new TreeNode(0);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        // head.right = node2;
        // head.left = node1;
        // node2.left = node3;
        // node2.right = node4;
        // node1.left = null;
        // node1.right = null;
        System.out.println(maxDepth(head));
    }

    public boolean isSymmetric(TreeNode root) {
        return isSubSymmetric(root, root);
    }

    public boolean isSubSymmetric(TreeNode p, TreeNode q) {
        if(p == null && q == null){
            return true;
        }
        if(p == null || q == null){
            return false;
        }
        //对称条件: 节点值相等且向下递归的左右都对称
        return p.val == q.val && isSubSymmetric(p.left, q.right) && isSubSymmetric(p.right, q.left);
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


