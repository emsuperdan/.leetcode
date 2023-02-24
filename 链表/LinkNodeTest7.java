package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest7 {
    

    public static void main(String[] args) throws Exception {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode ret = reverseList(head);
        while(ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }
    }

    //快慢指针，先把快指针前移k位，然后快指针到尾部时，慢指针正好为结果
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode fast = head;
        ListNode slow = head;
        //快指针前移k位
        while(fast!=null && k>0){
            fast = fast.next;
            k--;
        }
        while(fast != null && slow != null){
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }

    //遍历找到总结点数 然后取n-k>0位置的节点(或者翻转链表取第k位置节点)
    public ListNode getKthFromEnd2(ListNode head, int k) {
        int n = 0;
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode prev = fakeHead;
        //计算总节点数
        while(prev.next!=null){
            prev = prev.next;
            n++;
        }
        //重新把prev移动到链表头部(fakeHead.next)
        prev = fakeHead.next;
        while(n-k>0){
            prev = prev.next;
            n--;
        }
        return prev;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


