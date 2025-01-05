package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if(head==null){
            return null;
        }
        if(head.next==null){
            return head;
        }
        List<Integer> nodeValues = new ArrayList<>();
        while (head.next != null) {
            nodeValues.add(head.val);
            head = head.next;
        }
        nodeValues.add(head.val);
        List<Integer> lessList = new ArrayList<>();
        List<Integer> equalOrGreaterList = new ArrayList<>();

        for (int i : nodeValues) {
            if (i < x) {
                lessList.add(i);
            } else {
                equalOrGreaterList.add(i);
            }
        }

        List<Integer> resultList = new ArrayList<>();
        resultList.addAll(lessList);
        resultList.addAll(equalOrGreaterList);

        ListNode endNode = new ListNode();
        endNode.val = resultList.get(resultList.size() - 1);

        return createHeadNode(resultList, endNode, resultList.size()-2);
    }

    ListNode createHeadNode(List<Integer> nodeValues, ListNode currentNode, int index) {
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
