package LinkedList;

public class OddEvenLinkedList328 {
    // TC = 0(n), SC = O(1)

    // we first set current and temp to get started with the odd node and even node. then we set evenHead to remember
    // where the even node starts because the linkedlist of even nodes will be added to the end of the linkedlist of
    // odd nodes, this is why we need to remember it. Then both odd node and even odd node will skip one node and add
    // the node after the skipped one. once the next node of odd head or even head is null, we know we have finished
    // the loop. now we can set currentNode.next to be evenHead.
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null) return head;

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = head.next;

        while(odd.next != null && even.next != null) {
            odd.next = odd.next.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
