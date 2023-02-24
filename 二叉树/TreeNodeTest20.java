package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TreeNodeTest20 {
    
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

    public boolean checkSubTree(TreeNode t1, TreeNode t2){
        //左右子树都为空才是子树关系
        if(t1 == null && t2 == null){
            return true;
        }
        //左右子树有一个为空 则不是子树关系
        if(t1 == null || t2 == null){
            return false;
        }

        //左右子树直接相等 或 t1左子树为t2 或 t1右子树为t2
        return isEqual(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);

    }

    public boolean isEqual(TreeNode t1, TreeNode t2){
        //左右子树都为空才结点相等
        if(t1 == null && t2 == null){
            return true;
        }
        //左右子树有一个为空 则不相等
        if(t1 == null || t2 == null){
            return false;
        }

        //结点值相等 且 t1左节点和t2左节点完全相等 且 t1右节点和t2右节点完全相等
        return t1.val == t2.val && isEqual(t1.left, t2.left) && isEqual(t1.right, t2.right);
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


