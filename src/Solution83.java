import java.util.ArrayList;
import java.util.List;

public class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        List<Integer> nodeValues = new ArrayList<>();
        List<Integer> nodeUniqueValues = new ArrayList<>();

        while (head.next != null) {
            nodeValues.add(head.val);
            head = head.next;
        }
        nodeValues.add(head.val);

        Integer duplicateValue = null;
        for (int i = 0; i < nodeValues.size(); i++) {
            if (i == 0) {
                duplicateValue = nodeValues.get(i);
                nodeUniqueValues.add(nodeValues.get(i));
            } else if (!nodeValues.get(i).equals(nodeValues.get(i - 1))
                    && !nodeValues.get(i).equals(duplicateValue)) {
                nodeUniqueValues.add(nodeValues.get(i));
                duplicateValue = null;
            } else if (nodeValues.get(i).equals(nodeValues.get(i - 1))) {
                duplicateValue = nodeValues.get(i);
            }
        }

        if (nodeUniqueValues.isEmpty()) {
            return null;
        }

        ListNode endNode = new ListNode();
        endNode.val = nodeUniqueValues.get(nodeUniqueValues.size() - 1);

        if (nodeUniqueValues.size() == 1) {
            return endNode;
        }

        return createHeadNode(nodeUniqueValues, endNode, nodeUniqueValues.size() - 2);
    }

    public ListNode createHeadNode(List<Integer> nodeValues, ListNode currentNode, int index) {
        ListNode node = new ListNode();
        node.next = currentNode;
        node.val = nodeValues.get(index);
        if (index == 0) {
            return node;
        } else {
            return createHeadNode(nodeValues, node, index - 1);
        }
    }
}
