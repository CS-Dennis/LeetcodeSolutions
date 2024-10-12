package SolvedProblems;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < lists.length; i++) {
            if(lists[i]!=null){
                while(lists[i].next!=null){
                    result.add(lists[i].val);
                    lists[i] = lists[i].next;
                }
                result.add(lists[i].val);
            }
        }
        result.sort(Comparator.naturalOrder());
        if(result.isEmpty()){
            return null;
        }

        return createHeadNode(result, result.size()-1, null);
    }

    private ListNode createHeadNode(List<Integer> list, int index, ListNode currentNode){
        ListNode newNode = new ListNode(list.get(index));
        if(index==0){
            if(list.size()>1){
                newNode.next = currentNode;
                return newNode;
            } else {
                return newNode;
            }
        } else {
            newNode.next = currentNode;
            index--;
            return createHeadNode(list, index, newNode);
        }
    }
}
