class Solution {
    public int[] findSubtreeSizes(int[] par, String s) {
        int n=par.length;
        List<List<Integer>>l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            l.get(par[i]).add(i);
        }
        List<Integer>[]seen=new LinkedList[26];
        for(int i=0;i<26;i++) seen[i]=new LinkedList<>();
        dfs(l,0,seen,new StringBuilder(s),par);
        l=new ArrayList<>();
        for(int i=0;i<n;i++){
            l.add(new ArrayList<>());
        }
        for(int i=1;i<n;i++){
            l.get(par[i]).add(i);
        }
        int[] ans=new int[n];
        size(l,0,ans);
        return ans;
    }
    public void dfs(List<List<Integer>>l,int root,List<Integer>[]seen,StringBuilder s,int[]par){
        List<Integer>a=seen[s.charAt(root)-'a'];
        if(seen[s.charAt(root)-'a'].size()>0){
            par[root]=a.getLast();
        }
        a.add(root);
        for(int x:l.get(root)){
            dfs(l,x,seen,s,par);
        }
        a.removeLast();
    }
    public int size(List<List<Integer>>l,int root,int[]ans){
        int t=1;
        for(int x:l.get(root)){
            t+=size(l,x,ans);
        }
        return ans[root]=t;
    }
}