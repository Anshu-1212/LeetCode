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
    public TreeNode recoverFromPreorder(String s) {
        int n=s.length();
        if(n==0) return null;
        int a=0;
        int i=0;
        while(i<n){
            int ch=s.charAt(i)-'0';
            if(ch<0 || ch>9) break;
            a=a*10+ch;
            i++;
        }
        TreeNode root=new TreeNode(a);
        if(i==n) return root;
        int c=0;
        while(i<n && s.charAt(i)=='-'){
            c++;
            i++;
        }
        int cc=0,k=-1;
        int j;
        for( j=n-1;j>=1;j--){
            char ch=s.charAt(j);
            if(ch=='-'){
                cc++;
                if(cc==1) k=j;
            } 
            else{
                if(cc==c) break;
                cc=0;
            }
        }
        if(k+1==i){
            root.left=recoverFromPreorder(s.substring(i));
            return root;
        }
        root.left=recoverFromPreorder((i<j+1)?s.substring(i,j+1):"");
        root.right=recoverFromPreorder(s.substring(k+1));
        return root;
    }
}