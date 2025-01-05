package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        int diff = right - left;
        if (diff == 0) {
            return head;
        }

        List<Integer> nodeValues = new ArrayList<>();
        int[] reversedSectionTemp = new int[diff+1];
        int[] reversedSection = new int[diff+1];

        while (head.next != null) {
            nodeValues.add(head.val);
            head = head.next;
        }
        nodeValues.add(head.val);

        for (int i = 0; i < nodeValues.size(); i++) {
            if (i + 1 >= left && i + 1 <= right) {
                reversedSectionTemp[i+1-left] = nodeValues.get(i);
            }
        }

        for (int i = reversedSectionTemp.length-1; i>=0; i--) {
            reversedSection[reversedSectionTemp.length-1-i] = reversedSectionTemp[i];
        }

        for (int i = 0; i < nodeValues.size(); i++) {
            if (i + 1 >= left && i + 1 <= right) {
                nodeValues.set(i, reversedSection[i+1-left]);
            }
        }

        ListNode endNode = new ListNode();
        endNode.val = nodeValues.get(nodeValues.size() - 1);
        return createHeadNode(nodeValues, endNode, nodeValues.size() - 2);
    }

    private ListNode createHeadNode(List<Integer> nodeValues, ListNode currentNode, int index) {
        ListNode newNode = new ListNode();
        newNode.next = currentNode;
        newNode.val = nodeValues.get(index);
        if (index == 0) {
            return newNode;
        } else {
            return createHeadNode(nodeValues, newNode, index - 1);
        }
    }
}
