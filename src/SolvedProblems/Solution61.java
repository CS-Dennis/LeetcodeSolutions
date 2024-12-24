package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
//        if no rotation
        if (k == 0) {
            return head;
        }

//        if no nodes
        if (head == null) {
            return null;
        }

//        deconstruct nodes
        List<Integer> list = new ArrayList<>();
        while (head.next != null) {
            list.add(head.val);
            head = head.next;
        }

        list.add(head.val);

//        reorder the list
        if (list.size() == 1) {
//            if only one node
            return head;
        }

        Integer[] newArray = new Integer[list.size()];
        int absoluteK = k % list.size();
        if (absoluteK == 0) {
            newArray = list.toArray(Integer[]::new);
        } else {
            int index = 0;
            for (int i = list.size() - absoluteK; i < list.size(); i++) {
                newArray[index] = list.get(i);
                index++;
            }


            for (int i = 0; i < list.size() - absoluteK; i++) {
                newArray[index] = list.get(i);
                index++;
            }
        }

//        construct nodes
        return createHeadNode(new ListNode(), newArray, newArray.length - 1);
    }

    ListNode createHeadNode(ListNode currentNode, Integer[] nodeValues, int currentIndex) {
        if (currentIndex > 0) {
            currentNode.val = nodeValues[currentIndex];
            ListNode preNode = new ListNode();
            preNode.next = currentNode;

            return createHeadNode(preNode, nodeValues, currentIndex - 1);
        } else {
            currentNode.val = nodeValues[currentIndex];
            return currentNode;
        }
    }
}
