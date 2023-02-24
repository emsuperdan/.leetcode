package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest11 {
    
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

    TreeNode leftHead = null;
    TreeNode rightHead = null;

    //注意最后的判断条件 不仅左右子树高度差小于1且左右子树都得各为平衡树，否则子树内部依旧不满足平衡树条件
    public boolean isBalanced(TreeNode root) {
        if(root == null){
            return true;
        }

        int leftDepth = getDepth(root.left);
        int rightDepth = getDepth(root.right);
        return Math.abs(leftDepth-rightDepth)<=1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getDepth(TreeNode root){
        if(root == null){
            return 0;
        }else{
            int leftDepth = getDepth(root.left);
            int rightDepth = getDepth(root.right);
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


