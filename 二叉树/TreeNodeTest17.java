package 二叉树;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class TreeNodeTest17 {
    
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

    List<List<Integer>> res = new ArrayList<>();
    List<Integer> list = new ArrayList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum, 0);
        return res;
    }
    
    public void dfs(TreeNode root, int targetSum, int sum){
        if(root == null){
            return;
        }
        sum += root.val;
        //添加的是root的值而非sum
        list.add(root.val);
        //如果到了叶子节点 添加到list中
        if(sum == targetSum && root.left == null && root.right == null){
            res.add(new ArrayList<>(list));
        }
        dfs(root.left, targetSum, sum);
        dfs(root.right, targetSum, sum);
        //移除末尾元素(每轮不满足的元素会被移除，由于没法确认具体位置但符合条件元素一定是list中连续，所以移除末尾即可，满足的元素保留加入到res中)
        list.remove(list.size()-1);
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


