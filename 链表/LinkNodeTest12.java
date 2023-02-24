package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest12 {
    

    public static void main(String[] args) throws Exception {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(3);
        ListNode node3 = new ListNode(4);
        // ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;

        ListNode ret = swapPairs(head);
        while(ret!=null){
            System.out.println(ret.val);
            ret = ret.next;
        }

        // System.out.println(isPalindrome(head));
    }

    public static ListNode swapPairs(ListNode head) {
        ListNode fakeHead = new ListNode(-1, head);
        ListNode cur = fakeHead;
        while(cur.next!=null && cur.next.next!=null){
            ListNode frontNode = cur.next;
            ListNode endNode = cur.next.next;
            //先把cur的指向改为第二个node
            cur.next = endNode;
            //再把第一个node指向改为第二个node的后面一个节点
            frontNode.next = endNode.next;
            //再把第二个node指向第一个节点
            endNode.next = frontNode;
            //往后挪一步(不能用cur=cur.next因为frontNode的指向已经变了)
            cur = frontNode;
        }
        return fakeHead.next;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


