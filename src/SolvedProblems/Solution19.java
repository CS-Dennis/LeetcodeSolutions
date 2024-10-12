package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<Integer> nodes = new ArrayList<>();
        ListNode headCopy = head;

        while(headCopy.next!=null){
            nodes.add(headCopy.val);
            headCopy = headCopy.next;
        }
        nodes.add(headCopy.val);
        nodes.remove(nodes.size()-n);

        if(nodes.size()==0){
            return null;
        }
        return createHead(nodes, null, nodes.size()-1);
    }

    private ListNode createHead(List<Integer> nodes, ListNode currentNode, int index){
        ListNode newNode = new ListNode(nodes.get(index));
        if(index==0){
            if(nodes.size()>1){
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
