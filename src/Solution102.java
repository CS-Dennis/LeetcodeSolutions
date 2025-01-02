import java.util.ArrayList;
import java.util.List;

public class Solution102 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();

        getNodesValues(root, 0, list);
        return list;
    }

    private void getNodesValues (TreeNode currentNode, int nodeLevel, List<List<Integer>> list){
        if(currentNode==null){
            return;
        }

        if(list.size()==nodeLevel){
            list.add(new ArrayList<>());
            list.get(nodeLevel).add(currentNode.val);
        } else if(list.size()>nodeLevel){
            list.get(nodeLevel).add(currentNode.val);
        }

        if(currentNode.left!=null){
            getNodesValues(currentNode.left, nodeLevel+1, list);
        }
        if(currentNode.right!=null){
            getNodesValues(currentNode.right, nodeLevel+1, list);
        }
    }
}
