class Graph {
    List<List<int[]>>adj;
    int[]ans;
    PriorityQueue<int[]>pq;
    public Graph(int n, int[][] edges) {
        ans=new int[n];
        pq=new PriorityQueue<>((a,b)->a[1]-b[1]);
        adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int[]e:edges) adj.get(e[0]).add(new int[]{e[1],e[2]});
    }
    
    public void addEdge(int[] e) {
        adj.get(e[0]).add(new int[]{e[1],e[2]});
    }
    
    public int shortestPath(int node1, int node2) {
        int n=adj.size();
        Arrays.fill(ans,Integer.MAX_VALUE);
        ans[node1]=0;
        pq.add(new int[]{node1,0});
        while(!pq.isEmpty()){
            int[]t=pq.poll();
            int node=t[0],wt=t[1];
            if(ans[node]>wt) continue;
            for(int[]a:adj.get(node)){
                int nxnode=a[0];
                int twt=wt+a[1];
                if(twt>=ans[nxnode]) continue;
                ans[nxnode]=twt;
                pq.add(new int[]{nxnode,twt});
            }
        }
        return ans[node2]==Integer.MAX_VALUE?-1:ans[node2];
    }
}

/**
 * Your Graph object will be instantiated and called as such:
 * Graph obj = new Graph(n, edges);
 * obj.addEdge(edge);
 * int param_2 = obj.shortestPath(node1,node2);
 */