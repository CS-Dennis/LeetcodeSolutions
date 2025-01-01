
public class Solution100 {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        return compareTrees(p, q);
    }

    private boolean compareTrees(TreeNode p, TreeNode q){
        if(p==null && q==null){
            return true;
        }

        if(p!=null && q==null){
            return false;
        }

        if(p==null && q!=null){
            return false;
        }

        if(p.val== q.val){
            return compareTrees(p.left, q.left) && compareTrees(p.right, q.right);
        } else {
            return false;
        }
    }
}
