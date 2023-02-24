package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class TreeNodeTest18 {
    
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

    int rootIndex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        //由于题设元素无重复，将中序元素先快速存入，然后由前序的每个元素(即根节点)查出index，最后确定左右子树开始的下标
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return buildTree(map, 0, map.size()-1, preorder);
    }

    public TreeNode buildTree(Map<Integer, Integer> map, int left, int right, int[] preOrder) {
        //防数组越界
        if(left > right){
            return null;
        }

        //前序的每个元素都是根节点,由此先确定index，最后确定左右子树开始的下标
        int rootVal = preOrder[rootIndex];
        TreeNode root = new TreeNode(rootVal);
        //这里有点取巧，因为每轮递归的顺序正好符合前序遍历(递归版本)，因此rootIndex可以作为根节点值下标
        rootIndex++;
        //左递归
        root.left = buildTree(map, left, map.get(rootVal) - 1, preOrder);
        //右递归
        root.right = buildTree(map, map.get(rootVal) + 1, right, preOrder);
        return root;
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


