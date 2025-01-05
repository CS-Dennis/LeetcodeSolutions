package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution109 {
    public TreeNode sortedListToBST(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        return buildRootTreeNode(list, 0, list.size() - 1);
    }

    private TreeNode buildRootTreeNode(List<Integer> list, int startIndex, int endIndex) {
        if (startIndex > endIndex) {
            return null;
        } else {
            int midIndex = startIndex + (endIndex - startIndex) / 2;
            TreeNode node = new TreeNode(list.get(midIndex));
            node.left = buildRootTreeNode(list, startIndex, midIndex - 1);
            node.right = buildRootTreeNode(list, midIndex + 1, endIndex);
            return node;
        }
    }
}
