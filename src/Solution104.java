import java.util.ArrayList;
import java.util.List;

public class Solution104 {
    public int maxDepth(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        findMaxDepth(root, 1, list);
        return list.get(0);
    }

    private void findMaxDepth(TreeNode currentNode, int currentLevel, List<Integer> list){
        if(currentNode!=null){
            if(currentLevel> list.get(0)){
                list.set(0, currentLevel);
            }
            if(currentNode.left!=null){
                findMaxDepth(currentNode.left, currentLevel+1, list);
            }
            if(currentNode.right!=null){
                findMaxDepth(currentNode.right, currentLevel+1, list);
            }
        }
    }
}
