package LinkedList;

public class SwapNodesinPairs24 {
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

    // Iterative way: TC = O(n), SC = O(1)

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode temp = new ListNode();
        temp.next = head;
        ListNode current = temp;

        while(current.next != null && current.next.next != null) {
            ListNode firstNode = current.next;
            ListNode secondNode = current.next.next;

            firstNode.next = secondNode.next;
            current.next = secondNode;
            current.next.next = firstNode;
            current = current.next.next;
        }

        return temp.next;
    }
}
