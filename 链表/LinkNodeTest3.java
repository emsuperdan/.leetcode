package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest3 {
    

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

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //preHead为哨兵指针用于返回结果，真正执行逻辑的指针为prev
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        while(list1!=null && list2!=null){
            if(list1.val>=list2.val){
                prev.next = list2;
                list2 = list2.next;
            }else{
                prev.next = list1;
                list1 = list1.next;
            }
            prev = prev.next;
        }
        //最后list1和list2至少有一个不为空，直接把这部分拼接到prev尾部
        prev.next = list1==null ? list2:list1;
        return preHead.next;
     }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


