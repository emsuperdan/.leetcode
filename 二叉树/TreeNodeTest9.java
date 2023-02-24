package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest9 {
    
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
        System.out.println(convert(head));
    }

    TreeNode leftHead = null;
    TreeNode rightHead = null;

    public TreeNode convert(TreeNode root) {
        inOrderTraversal(root);
        return leftHead;
    }

    public void inOrderTraversal(TreeNode root){
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        if(rightHead == null){
            leftHead = root;
            rightHead = root;
        }else{
            //rightHead右指针指向root
            rightHead.right = root;
            //root左指针指向rightHead，至此双向指针建立
            root.left = rightHead;
            //往root方向移动，也就是说往后移动一位
            rightHead = root;
        }
        inOrderTraversal(root.right);
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


