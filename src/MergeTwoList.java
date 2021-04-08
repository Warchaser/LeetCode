import Bean.ListNode;
public class MergeTwoList {

    static public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode res;
        if(l1.val < l2.val){
            res = l1;
            res.next = mergeTwoLists(l1.next, l2);
        } else {
            res = l2;
            res.next = mergeTwoLists(l1,l2.next);
        }
        return res;
    }

    static public ListNode mergeTwoLists1(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }

        if(l2 == null){
            return l1;
        }

        ListNode pre = new ListNode(-1);
        ListNode end = pre;
        while (l1 != null && l2 != null){
            if(l1.val > l2.val){
                end.next = l2;
                end = l2;
                l2 = l2.next;
            } else {
                end.next = l1;
                end = l1;
                l1 = l1.next;
            }
        }

        if(l1 == null){
            end.next = l2;
        } else {
            end.next = l1;
        }

        return pre.next;
    }

    public static void main(String[] args){
        final ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));
        final ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

//        ListNode result = mergeTwoLists(l1, l2);
        ListNode result = mergeTwoLists1(l1, l2);
        Util.logList(result);
    }

}
