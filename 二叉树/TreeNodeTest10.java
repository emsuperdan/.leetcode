package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest10 {
    
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

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }else{
            int leftDepth = maxDepth(root.left);
            int rightDepth = maxDepth(root.right);
            return Math.max(leftDepth, rightDepth) + 1;
        }
    }

    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        int ans = 0;
        Deque<TreeNode> deque = new LinkedList<>();
        //根节点放入栈底
        deque.offer(root);
        while(!deque.isEmpty()){
             //每层的数据
            List<Integer> levelList = new ArrayList<>();
            int size = deque.size();
            for(int index = 0; index < size; index++){
                //从栈顶取元素打印
                TreeNode node = deque.poll();
                    levelList.add(node.val);
                    //有左节点则放入栈底
                    if(node.left!=null){
                        deque.offer(node.left);
                    }
                    //有右节点则放入栈底
                    if(node.right!=null){
                        deque.offer(node.right);
                    }
            }
            ans++;
        }
        return ans;
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


