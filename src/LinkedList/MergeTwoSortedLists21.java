package LinkedList;

public class MergeTwoSortedLists21 {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

    // TC = O(n + m),  n = length of l1, m = length of l2
    // SC = O(1)
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode temp = new ListNode();
        ListNode currentNode = temp;

        while(l1 != null && l2 != null) {

            if(l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }

            temp = temp.next;
        }

        if(l1 != null) {
            temp.next = l1;
        } else {
            temp.next = l2;
        }

        return currentNode;
    }
}
