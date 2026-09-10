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
    int sans;
    public int averageOfSubtree(TreeNode root) {
        sans=0;
        helper(root);
        return sans;
    }
    public int[] helper(TreeNode root) {
        if(root==null) return new int[]{0,0};
        if(root.left==null && root.right==null){
            sans++;
            return new int[]{root.val,1};
        } 
        int[]a=helper(root.left);
        int[]b=helper(root.right);
        double c=(root.val+a[0]+b[0])/(1+a[1]+b[1]);
        if((root.val+a[0]+b[0])/(1+a[1]+b[1])==root.val) sans++;
        return new int[]{root.val+a[0]+b[0],1+a[1]+b[1]};
    }
}