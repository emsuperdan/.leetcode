package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest8 {
    

    public static void main(String[] args) throws Exception {

        ListNode head = new ListNode(1);
        // ListNode node1 = new ListNode(2);
        // ListNode node2 = new ListNode(3);
        // ListNode node3 = new ListNode(4);
        // ListNode node4 = new ListNode(5);
        // head.next = node1;
        // node1.next = node2;
        // node2.next = node3;
        // node3.next = node4;

        ListNode ret = removeNthFromEnd(head,1);
        while(ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {
        //先算总数
        int k = 0;
        ListNode countTemp = head;
        while(countTemp!=null){
            countTemp = countTemp.next;
            k++;
        }
        //再算倒n位置节点
        ListNode temp = new ListNode(-1);
        //暂存ret 供后续返回结果
        ListNode ret = temp;
        temp.next = head;
        while(temp !=null && k-n>0){
            temp = temp.next;
            k--;
        }
        //删除节点
        temp.next = temp.next.next;
        return ret.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


