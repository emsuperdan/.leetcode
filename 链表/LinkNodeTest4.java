package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest4 {
    

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

    //双指针法
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
       if(headA == null || headB == null){
        return null;
       }
       ListNode pA = headA;
       ListNode pB = headB;
       while(pA != pB){
        pA = pA == null ? headB : pA.next;
        pB = pB == null ? headA : pB.next;
       }
        return pA;
    }

    //Set集合法
    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        Set<ListNode> nodeList = new HashSet<>();
        while(headA!=null){
            nodeList.add(headA);
            headA = headA.next;
        }
        while(headB!=null){
            if(nodeList.contains(headB)){
                return headB;
            }
            headB = headB.next;
        }
        return null;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


