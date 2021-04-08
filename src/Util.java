import Bean.ListNode;

public class Util {

    static void logList(ListNode head){
        ListNode node = head;
        while (node.next != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }

}
