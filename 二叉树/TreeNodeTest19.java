package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TreeNodeTest19 {
    
    public static void main(String[] args) throws Exception {
        TreeNode head = new TreeNode(0);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        head.right = node2;
        head.left = node1;
        node1.left = node3;
        // node2.left = node3;
        // node2.right = node4;
        // node1.left = null;
        // node1.right = null;

        TreeNodeTest17 test = new TreeNodeTest17();
        
        System.out.println(test.pathSum(head, 1));
    }

    public int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
         partMaxPathSum(root);
         return maxSum;
    }
    public int partMaxPathSum(TreeNode root) {
        if(root == null){
            return 0;
        }
        //计算左右子节点贡献值
        int leftGain = Math.max(partMaxPathSum(root.left), 0);
        int rightGain = Math.max(partMaxPathSum(root.right), 0);
        //当前节点的最大贡献值
        int partPathSum = root.val + leftGain + rightGain;
        //最终返回结果 取最大值
        maxSum = Math.max(maxSum, partPathSum);
        //递归返回局部的贡献值
        return root.val + Math.max(rightGain, leftGain);
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


