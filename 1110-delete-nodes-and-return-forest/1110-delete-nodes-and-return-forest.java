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
    Set<Integer> d = new HashSet<>();
    List<TreeNode> ans = new ArrayList<>();

    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        for (int x : to_delete) {
            d.add(x);
        }

        del(root, true);
        return ans;
    }

    public TreeNode del(TreeNode root, boolean isRoot) {
        if (root == null)
            return null;

        boolean deleted = d.contains(root.val);

        if (isRoot && !deleted) {
            ans.add(root);
        }

        root.left = del(root.left, deleted);
        root.right = del(root.right, deleted);

        return deleted ? null : root;
    }
}