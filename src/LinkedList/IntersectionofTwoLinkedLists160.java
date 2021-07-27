package LinkedList;

public class IntersectionofTwoLinkedLists160 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) {
     *         val = x;
     *         next = null;
     *     }
     * }
     */

    // Two pointers: TC = O(m + n), m = length of headA, n = length of headB
    //               SC = O(1)
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;

        ListNode pointer1 = headA;
        ListNode pointer2 = headB;

        while(pointer1 != pointer2) {
            if(pointer1 != null) {
                pointer1 = pointer1.next;
            } else {
                pointer1 = headB;
            }

            if(pointer2 != null) {
                pointer2 = pointer2.next;
            } else {
                pointer2 = headA;
            }
        }

        return pointer1;
    }
}
