package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest15 {
    
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

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //递归出口
        if(root == null || root == p || root == q){
            return root;
        }
        TreeNode leftNode = lowestCommonAncestor(root.left, p, q);
        TreeNode rightNode = lowestCommonAncestor(root.right, p, q);
        //如果左节点不是pq公共父节点，右节点也不是pq公共父节点
        if(leftNode == null && rightNode == null){
            return null;
        }
        //如果左节点是pq公共父节点，右节点是pq公共父节点 返回根节点
        if(leftNode != null && rightNode != null){
            return root;
        }
        //如果左节点是pq公共父节点，右节点不是pq公共父节点 返回左节点
        if(leftNode != null && rightNode == null){
            return leftNode;
        }
        //如果左节点不是pq公共父节点，右节点是pq公共父节点 返回右节点
        if(leftNode == null && rightNode != null){
            return rightNode;
        }
        return null;
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


