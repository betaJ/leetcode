/**
 * Created by jiangfeipeng on 2017/8/1.
 */

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        ListNode l2 = l1.next;
        l2.next = new ListNode(3);
        l1.next = l2;

        ListNode l3 = new ListNode(5);
        l3.next = new ListNode(6);
        ListNode l4 = l3.next;
        l4.next = new ListNode(4);
        l3.next = l4;

        AddTwoNumbers instance = new AddTwoNumbers();
        System.out.println(instance.addTwoNumbers(l1,l3).print());
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode c1 = l1;
        ListNode c2 = l2;
        ListNode sentinel = new ListNode(0);
        ListNode d = sentinel;
        int sum = 0;
        while (c1 != null || c2 != null) {
            sum /= 10;
            if (c1 != null) {
                sum += c1.val;
                c1 = c1.next;
            }
            if (c2 != null) {
                sum += c2.val;
                c2 = c2.next;
            }
            d.next = new ListNode(sum % 10);
            d = d.next;
        }
        if (sum / 10 == 1)
            d.next = new ListNode(1);
        return sentinel.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public String print() {
        String s = "";
        ListNode l1 = this;
        while (l1.next != null) {
            s += l1.val + "->";
            l1 = l1.next;
        }
        s += l1.val;
        return s;
    }

}