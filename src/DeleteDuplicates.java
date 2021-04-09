import Bean.ListNode;

import java.lang.reflect.Array;
import java.util.Arrays;

public class DeleteDuplicates {

    public static ListNode deleteDuplicates(ListNode head){
        if(head == null){
            return head;
        }

        ListNode cur = head;

        while (cur.next != null){
            if(cur.val == cur.next.val){
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        final ListNode head = new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3)))));

        deleteDuplicates(head);

        System.out.println(Arrays.toString(Util.printListFromTailToHead(head).toArray()));
    }

}
