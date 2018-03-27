package medium;

/**
 * You are given two non-empty linked lists representing two non-negative
 * integers. The digits are stored in reverse order and each of their nodes
 * contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the
 * number 0 itself.
 *
 * Example
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4) Output: 7 -> 0 -> 8 Explanation: 342 +
 * 465 = 807.
 *
 * @author Sravani Murakonda
 *
 */

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode cursor = null;
        ListNode sum = null;
        ListNode result = null;
        int remainder = 0;
        while (l2 != null && l1 != null) {
            remainder = l1.val + l2.val + remainder;
            if (remainder < 10) {
                cursor = new ListNode(remainder);
                cursor.next = null;
                remainder = 0;
            } else {
                cursor = new ListNode(remainder % 10);
                cursor.next = null;
                remainder = 1;
            }
            if (sum == null) {
                sum = cursor;
                result = sum;
            } else {
                sum.next = cursor;
                sum = sum.next;
            }
            cursor = cursor.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        if (l1 == null)
            l1 = l2;
        while (l1 != null) {
            remainder = l1.val + remainder;
            if (remainder < 10) {
                cursor = new ListNode(remainder);
                cursor.next = null;
                remainder = 0;
            } else {
                cursor = new ListNode(remainder % 10);
                cursor.next = null;
                remainder = remainder - 9;
            }
            if (sum == null) {
                sum = cursor;
                result = sum;
            } else {
                sum.next = cursor;
                sum = sum.next;
            }
            cursor = cursor.next;
            l1 = l1.next;
        }
        if (remainder != 0) {
            cursor = new ListNode(remainder);
            cursor.next = null;
            if (sum == null) {
                sum = cursor;
                result = sum;
            } else {
                sum.next = cursor;
                sum = sum.next;
            }

        }
        return result;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}
