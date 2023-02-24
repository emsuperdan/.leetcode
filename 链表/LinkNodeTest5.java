package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest5 {
    

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

    //穿针引线头插法(把一个个元素插到最前面)
    public ListNode reverseBetween(ListNode head, int left, int right) {
        //因为头节点有可能发生变化，使用虚拟头节点可以避免复杂的分类讨论
        ListNode fakeHead = new ListNode(-1);
        fakeHead.next = head;
        ListNode pre = fakeHead;
        //找到左边界
        for(int i = 0;i<left-1;i++){
            pre = pre.next;
        }
        ListNode cur = pre.next;
        ListNode next;
        for(int i = 0; i < right - left; i++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
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


