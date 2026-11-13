/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans=0;
    public int findTilt(TreeNode root) {
        upd(root);
        return ans;
    }
    public int upd(TreeNode root) {
        if(root==null) return 0;
        int l=upd(root.left);
        int r=upd(root.right);
        ans+=Math.abs(l-r);
        return root.val+l+r;
    }
}