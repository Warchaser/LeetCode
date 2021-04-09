import Bean.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Util {

    static void logList(ListNode head){
        ListNode node = head;
        while (node.next != null){
            System.out.println(node.val + " ");
            node = node.next;
        }
    }

    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(listNode == null) {
            return res;
        }
        Stack<ListNode> nodes = new Stack<ListNode>();
        ListNode head = listNode;
        while(head != null) {
            nodes.push(head);
            head = head.next;
        }
        while(!nodes.empty()) {
            res.add(nodes.peek().val);
            nodes.pop();
        }
        return res;
    }

}
