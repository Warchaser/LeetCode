import Bean.ListNode;

/**
 * @link https://leetcode.cn/problems/add-two-numbers/
 * */
public class AddTwoNumbers {

    /**
     * 考虑进位
     * 每次相加都将余数放入next
     * */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2){
        final ListNode root = new ListNode(0);
        ListNode cursor = root;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0){
            int l1Val = l1 != null ? l1.val : 0;
            int l2Val = l2 != null ? l2.val : 0;
            int sumVal = l1Val + l2Val + carry;
            carry = sumVal / 10;

            ListNode sumNode = new ListNode(sumVal % 10);
            cursor.next = sumNode;
            cursor = sumNode;

            if(l1 != null){
                l1 = l1.next;
            }

            if(l2 != null){
                l2 = l2.next;
            }
        }

        return root.next;
    }

    public static void main(String[] args) {
        int[] array1 = new int[]{2, 4, 3};
        int[] array2 = new int[]{5, 6, 4};
        Util.logList(addTwoNumbers(Util.array2NodeList(array1), Util.array2NodeList(array2)));
    }

}
