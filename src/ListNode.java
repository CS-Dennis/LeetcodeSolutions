// used for Solution2, 19, 21

// my notes
// to create a chain of linked nodes, the easiest way is to us recursive and construct the last node back to the head
// ListNode newNode = new ListNode(value, lastNode);
// return newNode
public class ListNode {
    int val;
    ListNode next;

    ListNode() {
    }

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}