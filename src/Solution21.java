import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution21 {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        List<Integer> nodes1 = new ArrayList<>();
        List<Integer> nodes2 = new ArrayList<>();

        if (list1 != null) {
            while (list1.next != null) {
                nodes1.add(list1.val);
                list1 = list1.next;
            }
            nodes1.add(list1.val);
        }

        if (list2 != null) {
            while (list2.next != null) {
                nodes2.add(list2.val);
                list2 = list2.next;
            }
            nodes2.add(list2.val);
        }

        nodes1.addAll(nodes2);

        nodes1.sort(Comparator.naturalOrder());

        if (nodes1.size() == 0) {
            return null;
        }

        return createHead(nodes1, null, nodes1.size() - 1);
    }

    private ListNode createHead(List<Integer> nodes, ListNode currentNode, int index) {
        ListNode newNode = new ListNode(nodes.get(index));
        if (index == 0) {
            if (nodes.size() > 1) {
                newNode.next = currentNode;
            }

            return newNode;
        } else {
            newNode.next = currentNode;
            index--;
            return createHead(nodes, newNode, index);
        }
    }
}
