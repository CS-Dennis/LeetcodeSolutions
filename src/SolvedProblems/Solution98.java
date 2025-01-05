package SolvedProblems;

import java.util.ArrayList;
import java.util.List;

public class Solution98 {
    public boolean isValidBST(TreeNode root) {
        List<Boolean> result = new ArrayList<>();
        result.add(true);

        findValidBST(root, new ArrayList<>(), new ArrayList<>(), result);
        return result.get(0);
    }


    private void findValidBST(TreeNode currentNode, List<Integer> lessValues, List<Integer> greaterValues, List<Boolean> result) {
        if (!result.get(0)) {
            return;
        }

        if (compareToList(currentNode.val, lessValues, ">") && compareToList(currentNode.val, greaterValues, "<")) {
            if (currentNode.left != null) {
                if (currentNode.left.val < currentNode.val && compareToList(currentNode.left.val, greaterValues, "<") && compareToList(currentNode.left.val, lessValues, ">")) {
                    List<Integer> newLessValues = new ArrayList<>(lessValues);
                    List<Integer> newGreaterValues = new ArrayList<>(greaterValues);
                    newGreaterValues.add(currentNode.val);
                    findValidBST(currentNode.left, newLessValues, newGreaterValues, result);
                } else {
                    result.set(0, false);
                    return;
                }
            }

            if (currentNode.right != null) {
                if (currentNode.right.val > currentNode.val && compareToList(currentNode.right.val, greaterValues, "<") && compareToList(currentNode.right.val, lessValues, ">")) {
                    List<Integer> newLessValues = new ArrayList<>(lessValues);
                    List<Integer> newGreaterValues = new ArrayList<>(greaterValues);
                    newLessValues.add(currentNode.val);
                    findValidBST(currentNode.right, newLessValues, newGreaterValues, result);
                } else {
                    result.set(0, false);
                }
            }
        } else {
            result.set(0, false);
        }
    }

    private boolean compareToList(int target, List<Integer> list, String operator) {
        if (list.isEmpty()) {
            return true;
        } else if (operator.equals(">")) {
            for (int i : list) {
                if (target <= i) {
                    return false;
                }
            }
        } else if (operator.equals("<")) {
            for (int i : list) {
                if (target >= i) {
                    return false;
                }
            }
        }
        return true;
    }
}
