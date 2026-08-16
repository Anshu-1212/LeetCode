/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>>l=new ArrayList<>();
        if(root==null) return l;
        Queue<Node>q=new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            int s=q.size();
            List<Integer>al=new ArrayList<>();
            while(s-->0){
                Node t=q.poll();
                al.add(t.val);
                for(Node e:t.children) q.add(e);
            }
            l.add(al);
        }
        return l;
    }
}