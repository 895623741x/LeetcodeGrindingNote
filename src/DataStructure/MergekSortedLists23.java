package DataStructure;

import java.util.PriorityQueue;

public class MergekSortedLists23 {
    // In priority queue, we can get the maximum number in O(1) time and retrieve the maximum or add a random number
    // to the priority queue in O(logn) time

    // TC = O(kn * logk), k is the number of elements in the array and n is the length of each linkedList in the array
    // SC = O(k), we use priority queue and there are k linkedLists in the array

    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(ListNode head: lists) {
            // when head is null, we move on to the next linkedList
            while(head != null) {
                minHeap.add(head.val);
                // move to the next head
                head = head.next;
            }
        }

        ListNode dummy = new ListNode();
        ListNode head = dummy;

        while(!minHeap.isEmpty()) {
            head.next = new ListNode(minHeap.remove());
            head = head.next;
        }

        return dummy.next;
    }
}
