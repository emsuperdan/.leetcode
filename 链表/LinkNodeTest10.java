package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest10 {
    

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

    public ListNode deleteDuplicates(ListNode head) {
        if(head == null){
            return head;
        }
        //注意这里和进阶版不同的是: 
        //比较cur.val 和 cur.next.val的值，正因如此不能用fakeHead，结果返回head;
        ListNode cur = head;
        while(cur.next!=null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            }else {
                cur = cur.next;
            }
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


