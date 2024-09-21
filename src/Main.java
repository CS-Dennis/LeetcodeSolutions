import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
//        int[] a= {2,4,3};
//        int[] b= {5,6,4};
        ListNode a = new ListNode(3);
        a.next = new ListNode(7);
//        a.next.next = new ListNode(9);
//        a.next.next.next = new ListNode(9);
//        a.next.next.next.next = new ListNode(9);
//        a.next.next.next.next.next = new ListNode(9);
//        a.next.next.next.next.next.next = new ListNode(9);

        ListNode b = new ListNode(9);
        b.next = new ListNode(2);
//        b.next.next = new ListNode(4);
//        b.next.next.next = new ListNode(9);
//        b.next.next.next.next = new ListNode(9);
//        b.next.next.next.next.next = new ListNode(9);
//        b.next.next.next.next.next.next = new ListNode(9);
//        b.next.next.next.next.next.next.next = new ListNode(9);
//        b.next.next.next.next.next.next.next.next = new ListNode(9);
//        b.next.next.next.next.next.next.next.next.next = new ListNode(9);

        Solution2 s = new Solution2();
        s.addTwoNumbers(a,b);

    }
}