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
    List<Integer>l;
    public int getMinimumDifference(TreeNode root) {
        l=new ArrayList<>();
        helper(root);
        int mn=Integer.MAX_VALUE;
        int n=l.size();
        for(int i=1;i<n;i++){
            mn=Math.min(mn,Math.abs(l.get(i)-l.get(i-1)));
        }
        return mn;
    }
    public void helper(TreeNode root){
        if(root==null) return;
        helper(root.left);
        l.add(root.val);
        helper(root.right);
    }
}