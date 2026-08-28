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
    Map<Integer,Integer>map;
    public int[] findFrequentTreeSum(TreeNode root) {
        map=new HashMap<>();
        helper(root);
        int mxf=0;
        int occ=0;
        for(var e:map.values()){
            if(mxf<e){
                mxf=e;
                occ=1;
            }
            else if(mxf==e) occ++;
        }
        int[]sans=new int[occ];
        int k=0;
        for(var e:map.entrySet()){
            int a=e.getKey();
            int b=e.getValue();
            if(mxf==b){
                sans[k++]=a;
            }
        }
        return sans;
    }
    public int helper(TreeNode root){
        if(root==null) return 0;
        int sum=root.val;
        sum+=helper(root.left);
        sum+=helper(root.right);
        map.put(sum,map.getOrDefault(sum,0)+1);
        return sum;
    }
}