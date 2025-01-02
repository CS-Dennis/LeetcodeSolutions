import java.util.ArrayList;
import java.util.List;

public class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list =new ArrayList<>();
        createTopDownList(root, 0, list);

//        reverse list
        List<List<Integer>> reversedList = new ArrayList<>();
        for (int i = list.size()-1; i >=0 ; i--) {
            reversedList.add(list.get(i));
        }
        return reversedList;
    }

    private void createTopDownList(TreeNode currentNode, int currentLevel, List<List<Integer>> list) {
        if (currentNode != null) {
            if (list.size() == currentLevel) {
                list.add(new ArrayList<>());
                list.get(currentLevel).add(currentNode.val);
            } else if(list.size() > currentLevel) {
                list.get(currentLevel).add(currentNode.val);
            }

            if(currentNode.left != null) {
                createTopDownList(currentNode.left, currentLevel + 1, list);
            }
            if(currentNode.right != null) {
                createTopDownList(currentNode.right, currentLevel + 1, list);
            }
        }
    }
}
