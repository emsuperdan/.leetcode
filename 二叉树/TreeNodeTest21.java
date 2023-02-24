package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TreeNodeTest21 {
    
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

    public boolean isContainValue(TreeNode t1, int val){
        if(t1 == null){
            return false;
        }

        return t1.val == val || isContainValue(t1.left, val) || isContainValue(t1.right, val);
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


