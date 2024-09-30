import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        a.next.next.next = new ListNode(4);
        a.next.next.next.next = new ListNode(5);
        Solution19 s = new Solution19();
        ListNode result = s.removeNthFromEnd(a, 2);
        while (result.next!=null){
            System.out.println(result.val);
            result = result.next;
        }
        System.out.println(result.val);
    }
}