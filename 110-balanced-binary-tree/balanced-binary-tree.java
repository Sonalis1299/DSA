class Solution {
    public boolean isBalanced(TreeNode root) {
        return height(root) != -1;
    }
    public int height(TreeNode root){
        if(root == null) return 0;

        int lh = height(root.left);
        int rh = height(root.right);

        if(rh == -1 || lh == -1) return -1;
        if(Math.abs(rh-lh)>1) return -1;
        
        return Math.max(lh,rh)+1;
    }
}