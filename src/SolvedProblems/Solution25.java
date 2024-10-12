package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        List<ListNode> nodes = new ArrayList<>();
        List<ListNode> repositionedNodes = new ArrayList<>();

        while (head.next != null) {
            nodes.add(head);
            head = head.next;
        }

        nodes.add(head);

        if (nodes.size() == 1) {
            return head;
        }

        int length = nodes.size();


        int addedNodes = k;
        while (addedNodes <= length - length % k) {
            for (int i = addedNodes - 1; i >= addedNodes - k; i--) {
                repositionedNodes.add(nodes.get(i));
            }
            addedNodes += k;
        }

        for (int i = length - length % k; i < length; i++) {
            repositionedNodes.add(nodes.get(i));
        }

        return createHead(repositionedNodes, repositionedNodes.size() - 1, null);
    }

    private ListNode createHead(List<ListNode> list, int index, ListNode currentNode) {
        ListNode newNode = list.get(index);
        if (index == 0) {
            if (list.size() == 1) {
                return newNode;
            } else {
                newNode.next = currentNode;
                return newNode;
            }
        }

        newNode.next = currentNode;
        index--;
        return createHead(list, index, newNode);
    }
}
