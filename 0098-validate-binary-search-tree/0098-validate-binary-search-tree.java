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
    class Pair{
        boolean f;
        long min;
        long max;
        Pair(boolean f,long min,long max){this.f=f;this.min=min;this.max=max;}
    }
    public boolean isValidBST(TreeNode root) {
        return helper(root).f;
    }
    public Pair helper(TreeNode root) {
        if(root==null){
            return new Pair(true,Long.MAX_VALUE,Long.MIN_VALUE);
        }
        Pair a=helper(root.left);
        Pair b=helper(root.right);
        if(!a.f || !b.f) return new Pair(false,root.val,root.val);
        long mx=Math.max(root.val,Math.max(a.max,b.max));
        long mn=Math.min(root.val,Math.min(a.min,b.min));
        boolean valid=(root.val>a.max && root.val<b.min);
        return new Pair(valid,mn,mx);
    }
}