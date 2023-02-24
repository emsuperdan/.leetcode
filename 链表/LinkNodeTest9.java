package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest9 {
    

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
        //返回结果的指针
        ListNode fakeHead = new ListNode(-1, head);
        //移动逻辑的指针
        ListNode cur = fakeHead;
        while(cur.next != null && cur.next.next != null){
            //如果发生相邻两位相等
            if(cur.next.val == cur.next.next.val){
                int val = cur.next.val;
                // cur = cur.next;
                //找到连续相等的最后一位，指针不断后移
                while(cur.next!=null && cur.next.val == val){
                    cur.next = cur.next.next;
                }
            } else{
                //相邻两位不相等，指针直接往后移一位
                cur = cur.next;
            }
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


