package 链表;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LinkNodeTest2 {
    

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

    //快慢指针(注意quick和quick.next不为空即可)
    public boolean hasCycle(ListNode head) {
        ListNode quick = head;
        ListNode slow = head;
        while(quick!=null && quick.next !=null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick==slow){
                return true;
            }
        }
        return false;
    }

    //Set容器(把所有节点全部add，判断是否add过)
    public boolean hasCycle2(ListNode head) {
        Set<ListNode> nodeSet = new HashSet<>();
        while(head!=null){
            if(!nodeSet.add(head)){
                return true;
            }
            head = head.next;
        }

        return false;
    }


    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

}


