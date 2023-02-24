package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest12 {
    
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

    int maxD = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxD;
    }

    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            //将每个节点最大直径(左子树深度+右子树深度)，和最大直径比较并进行最大直径更新
            maxD = Math.max(leftDepth+rightDepth, maxD);
            //返回每个节点的深度
            return Math.max(leftDepth, rightDepth) + 1;
        }
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


