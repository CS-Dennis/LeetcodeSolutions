import java.util.ArrayList;
import java.util.List;

public class Solution113 {
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> list = new ArrayList<>();
        if(root==null){
            return list;
        }

        findPathSums(root, 0, targetSum, new ArrayList<>(), list);
        return list;
    }

    private void findPathSums(TreeNode node, int currentSum, int targetSum, List<Integer> currentNodeValuesList, List<List<Integer>> list) {
        int newCurrentSum = node.val + currentSum;
        List<Integer> newCurrentNodeValuesList = new ArrayList<>(currentNodeValuesList);
        newCurrentNodeValuesList.add(node.val);
        if (node.left == null && node.right == null) {
            if (newCurrentSum == targetSum) {
                list.add(newCurrentNodeValuesList);
            }
        } else if (node.left == null) {
            findPathSums(node.right, newCurrentSum, targetSum, newCurrentNodeValuesList, list);
        } else if (node.right == null) {
            findPathSums(node.left, newCurrentSum, targetSum, newCurrentNodeValuesList, list);
        } else {
            findPathSums(node.right, newCurrentSum, targetSum, newCurrentNodeValuesList, list);
            findPathSums(node.left, newCurrentSum, targetSum, newCurrentNodeValuesList, list);
        }
    }
}
