import Bean.ListNode;

import java.util.ArrayList;
import java.util.Stack;

public class Util {

    static void logList(ListNode head){
        ListNode node = head;
        while (node != null){
            System.out.print(node.val + " ");
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

    public static ListNode array2NodeList(int[] array){
        if(array.length == 0){
            return null;
        }

        ListNode head = new ListNode(array[0]);
        ListNode cursor = head;

        for(int i = 1 ; i < array.length ; i++){
            cursor.next = new ListNode(array[i]);
            cursor = cursor.next;
        }

        return head;
    }

    public static void currentMillis(){
        System.out.println(System.currentTimeMillis());
    }

}
