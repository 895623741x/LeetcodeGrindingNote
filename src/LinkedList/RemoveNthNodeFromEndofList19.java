package LinkedList;

public class RemoveNthNodeFromEndofList19 {
    // TC = O(n), SC = O(1)

    // We first build a dummy head to for the reference of head. we first move the fast pointer to position n. then
    // we move both pointers until the fast pointer moves to null. when fast pointer is null, slow.next = slow.next
    // .next. finally we return dummy.next.
    public ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode();
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        for(int i = 1; i <= n + 1; i++) {
            fast = fast.next;
        }

        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return dummy.next;
    }
}
