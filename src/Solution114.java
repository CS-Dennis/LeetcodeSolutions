import java.util.ArrayList;
import java.util.List;

public class Solution114 {
    public void flatten(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) {
            return;
        }

        findAllNodeValues(root, list);
//        System.out.println(list);

        if (list.size() == 1) {
            return;
        }

        TreeNode node = new TreeNode(list.get(list.size() - 1));
        TreeNode rootNode = createRootNode(node, list.size() - 2, list);
        root.val = rootNode.val;
        root.right = rootNode.right;
        root.left = rootNode.left;
    }

    private void findAllNodeValues(TreeNode node, List<Integer> list) {
        if (node != null) {
            list.add(node.val);
            findAllNodeValues(node.left, list);
            findAllNodeValues(node.right, list);
        }
    }

    private TreeNode createRootNode(TreeNode node, int index, List<Integer> list) {
        TreeNode newNode = new TreeNode(list.get(index));
        newNode.right = node;
        if (index > 0) {
            return createRootNode(newNode, index - 1, list);
        }

        return newNode;
    }
}
