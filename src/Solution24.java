import java.util.ArrayList;
import java.util.List;

public class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }

        List<ListNode> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head);
            head = head.next;
        }
        list.add(head);

        if (list.size() == 1) {
            return list.get(0);
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (i % 2 == 1) {
                    ListNode temp = list.get(i);
                    list.set(i, list.get(i - 1));
                    list.set(i - 1, temp);
                }
            }

            return createHeadNode(list, list.size() - 1, null);
        }
    }

    private ListNode createHeadNode(List<ListNode> nodes, int index, ListNode currentNode) {
        if (index == 0) {
            if (nodes.size() == 1) {
                return nodes.get(index);
            } else if (nodes.size() > 1) {
                nodes.get(index).next = currentNode;
                return nodes.get(index);
            }
        }

        ListNode newNode = nodes.get(index);
        newNode.next = currentNode;
        index--;
        return createHeadNode(nodes, index, newNode);
    }
}
