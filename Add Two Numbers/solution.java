/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int add1, add2;
        int carry = 0;
        int x = (l1.val + l2.val + carry) % 10;
        carry = (l1.val + l2.val + carry) / 10;
        ListNode lh = new ListNode(x);
        ListNode li = lh;
        if (carry > 0 && l1.next == null && l2.next == null){
            li.next = new ListNode(carry);
            li = li.next;
            carry = 0;
        }
        l1 = l1.next;
        l2 = l2.next;
        while(l1 != null || l2 != null || carry > 0){
            if(l1 == null){
                add1 = 0;
            }
            else{
                add1 = l1.val;
                l1 = l1.next;
            }
            if(l2 == null){
                add2 = 0;
            }
            else{
                add2 = l2.val;
                l2 = l2.next;
            }
            x = (add1 + add2 + carry) % 10;
            carry = (add1 + add2 + carry) / 10;
            li.next = new ListNode(x);
            li = li.next;
        }
        li.next = null;
        return lh;
    }
}
