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
class FindElements {
    Set<Integer>set;
    TreeNode root;
    public FindElements(TreeNode root) {
        this.root=root;
        set=new HashSet<>();
        helper(root,0);
    }
    public void helper(TreeNode root,int x){
        if(root==null) return;
        set.add(x);
        helper(root.left,2*x+1);
        helper(root.right,2*x+2);
    }
    public boolean find(int target) {
        return set.contains(target);
    }
}

/**
 * Your FindElements object will be instantiated and called as such:
 * FindElements obj = new FindElements(root);
 * boolean param_1 = obj.find(target);
 */