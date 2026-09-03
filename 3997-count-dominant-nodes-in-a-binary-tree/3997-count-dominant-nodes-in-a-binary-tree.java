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
    int s;
    public int countDominantNodes(TreeNode root) {
        s=0;
        helper(root);
        return s;
    }
    public int helper(TreeNode root) {
        if(root==null) return 0;
        int a=Math.max(helper(root.left),helper(root.right));
        if(root.val>=a) s++;
        return Math.max(root.val,a);
    }
}