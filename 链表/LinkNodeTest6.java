package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest6 {
    

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

    public void reorderList(ListNode head) {
        ListNode mid = middleNode(head);
        ListNode list1 = head;
        ListNode list2 = mid.next;
        //断开链接
        mid.next = null;
        list2 = reverseList(list2);
        mergeList(list1, list2);
    }

    //快慢指针找重点
    public ListNode middleNode(ListNode head){
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next !=null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    //翻转链表基础版
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
        }
        return prev;
    }
    
    public void mergeList(ListNode l1, ListNode l2) {
        while(l1 != null && l2 != null){
            ListNode l1Temp = l1.next;
            ListNode l2Temp = l2.next;

            //本来此处只需要
            //l1.next = l2;
            //(l1往后挪一位)
            //l2.next = l1;
            //(l2往后挪一位)
            //l1和l2的next需要temp暂存，否则往后挪一位的话就把赋的值也给新的l1和l2了
            l1.next = l2;
            l1 = l1Temp;
            l2.next = l1;
            l2 = l2Temp;
        }
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


