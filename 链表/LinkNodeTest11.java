package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest11 {
    

    public static void main(String[] args) throws Exception {

        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        // ListNode node4 = new ListNode(5);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        // node3.next = node4;

        // ListNode ret = isPalindrome(head);
        // while(ret!=null){
        //     System.out.println(ret.val);
        //     ret = ret.next;
        // }

        System.out.println(isPalindrome(head));
    }

    //先找到一半的节点A，然后把A到尾部节点链表反转，再一一比较
    public static boolean isPalindrome(ListNode head) {
        ListNode halfNode = getFrontPartNode(head);
        ListNode reversedHalfNode = reverseListNode(halfNode);
        while(head != null && reversedHalfNode != null){
            if(head.val != reversedHalfNode.val){
                return false;
            }
            head = head.next;
            reversedHalfNode = reversedHalfNode.next;
        }
        return true;
    }

    public static ListNode getFrontPartNode(ListNode head){
        ListNode quick = head;
        ListNode slow = head;
        while(quick != null && quick.next != null){
            quick = quick.next.next;
            slow = slow.next;
        }
        return slow;
    }

    public static ListNode reverseListNode(ListNode head){
        ListNode prev = null;
        ListNode cur = head;
        while(cur!=null){
            ListNode tempNext = cur.next;
            cur.next = prev;
            prev = cur;
            cur = tempNext;
        }
        return prev;
    }

    public boolean isPalindrome2(ListNode head) {
        List<Integer> valList = new ArrayList<>();
        while(head!=null){
            valList.add(head.val);
            head = head.next;
        }
        int front = 0;
        int back = valList.size() - 1;
        while(front<back){
            if(valList.get(front) != valList.get(back)){
                return false;
            }
            front++;
            back--;
        }
        return true;
    }

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


