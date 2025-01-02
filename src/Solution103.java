import java.util.ArrayList;
import java.util.List;

public class Solution103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        createList(root, 0, list);

//        zig zag the 2d list
        for (int i = 0; i < list.size(); i++) {
            if(i%2==1){
                List<Integer> temp = new ArrayList<>();
                for (int j = list.get(i).size()-1; j >=0 ; j--) {
                    temp.add(list.get(i).get(j));
                }

                list.set(i, temp);
            }
        }

        return list;
    }

    private void createList(TreeNode currentNode, int nodeLevel, List<List<Integer>> list) {
        if (currentNode == null) {
            return;
        }

        if (list.size() == nodeLevel) {
            list.add(new ArrayList<>());
            list.get(nodeLevel).add(currentNode.val);
        } else if (list.size() > nodeLevel) {
            list.get(nodeLevel).add(currentNode.val);
        }

        if (currentNode.left != null) {
            createList(currentNode.left, nodeLevel + 1, list);
        }
        if (currentNode.right != null) {
            createList(currentNode.right, nodeLevel + 1, list);
        }
    }
}
