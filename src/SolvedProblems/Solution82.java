package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return head;
        }

        List<Integer> nodeValues = new ArrayList<>();
        while (head.next != null) {
            nodeValues.add(head.val);
            head = head.next;
        }

        nodeValues.add(head.val);

        Integer duplicatedValue = null;
        List<Integer> uniqueValues = new ArrayList<>();
        for (int i = 0; i < nodeValues.size(); i++) {
            if (i <= nodeValues.size() - 2) {
                if (!nodeValues.get(i).equals(nodeValues.get(i + 1)) && !nodeValues.get(i).equals(duplicatedValue)) {
                    uniqueValues.add(nodeValues.get(i));
                } else {
                    duplicatedValue = nodeValues.get(i);
                }
            }
        }
        if (!nodeValues.get(nodeValues.size() - 1).equals(nodeValues.get(nodeValues.size() - 2))) {
            uniqueValues.add(nodeValues.get(nodeValues.size() - 1));
        }

        if (uniqueValues.isEmpty()) {
            return null;
        }
        if (uniqueValues.size() == 1) {
            ListNode node = new ListNode();
            node.val = uniqueValues.get(0);
            return node;
        }

        ListNode currentNode = new ListNode();
        currentNode.val = uniqueValues.get(uniqueValues.size() - 1);
        return createHeadNode(uniqueValues, currentNode, uniqueValues.size() - 2);
    }

    public ListNode createHeadNode(List<Integer> list, ListNode currentNode, int currentIndex) {
        ListNode node = new ListNode();
        node.next = currentNode;
        node.val = list.get(currentIndex);
        if (currentIndex == 0) {
            return node;
        } else {
            return createHeadNode(list, node, currentIndex - 1);
        }
    }
}
