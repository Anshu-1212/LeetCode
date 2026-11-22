// class Solution {
//     class Pair{
//         int node;
//         long t;
//         Pair(int node,long t){
//             this.node=node;
//             this.t=t;
//         }
//     }
//     public long[] earliestActivationTimes(int n, int[][] edges, int[] req) {
//         List<List<Pair>>l=new ArrayList<>();
//         for(int i=0;i<n;i++) l.add(new ArrayList<>());
//         for(int[]e:edges){
//             int u=e[0],v=e[1],d=e[2];
//             l.get(u).add(new Pair(v,d));
//         }
//         long[]ans=new long[n];
//         Arrays.fill(ans,-1);
//         ans[0]=0;
//         Queue<Pair>q=new LinkedList<>();   //node,time
//         q.add(new Pair(0,0));
//         while(!q.isEmpty()){
//             Pair p=q.poll();
//             int node=p.node;
//             long t=p.t;
//             for(Pair a:l.get(node)){
//                 int nnode=a.node;
//                 long nt=t+a.t;
//                 req[nnode]--;
//                 if(req[nnode]==0){
//                     q.add(new Pair(nnode,nt));
//                     ans[nnode]=nt;
//                 }
//             }
//         }
//         return ans;
//     }
// }
// class Solution {
//     class Pair{
//         int node;
//         long t;
//         Pair(int node,long t){
//             this.node=node;
//             this.t=t;
//         }
//     }
//     public long[] earliestActivationTimes(int n, int[][] edges, int[] req) {
//         List<List<Pair>>l=new ArrayList<>();
//         for(int i=0;i<n;i++) l.add(new ArrayList<>());
//         for(int[]e:edges){
//             int u=e[0],v=e[1],d=e[2];
//             l.get(u).add(new Pair(v,d));
//         }
//         // long[]fans=new long[n];
//         long[]ans=new long[n];
//         Arrays.fill(ans,-1);
//         ans[0]=0;
//         PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Long.compare(a.t,b.t));   //node,time
//         pq.add(new Pair(0,0));
//         while(!pq.isEmpty()){
//             Pair p=pq.poll();
//             int node=p.node;
//             long t=p.t;
//             for(Pair a:l.get(node)){
//                 int nnode=a.node;
//                 long nt=t+a.t;
//                 req[nnode]--;
//                 // fans[nnode]=Math.max(fans[nnode],nt);
//                 if(req[nnode]==0){
//                     pq.add(new Pair(nnode,nt));
//                     // ans[nnode]=fans[nnode];
//                     ans[nnode]=nt;
//                 }
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    class Pair{
        int node;
        long t;
        Pair(int node,long t){
            this.node=node;
            this.t=t;
        }
    }
    public long[] earliestActivationTimes(int n, int[][] edges, int[] req) {
        req[0]=1;
        List<List<Pair>>l=new ArrayList<>();
        for(int i=0;i<n;i++) l.add(new ArrayList<>());
        for(int[]e:edges){
            int u=e[0],v=e[1],d=e[2];
            l.get(u).add(new Pair(v,d));
        }
        boolean[]s=new boolean[n];
        // s[0]=true;
        long[]ans=new long[n];
        Arrays.fill(ans,-1);
        ans[0]=0;
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->Long.compare(a.t,b.t));   //node,time
        pq.add(new Pair(0,0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int node=p.node;
            long t=p.t;
            if(s[node]) continue;
            req[node]--;
            if(req[node]==0){
                ans[node]=t;
                s[node]=true;
            }
            if(req[node]>0) continue;
            for(Pair a:l.get(node)){
                int nnode=a.node;
                long nt=t+a.t;
                if(s[nnode]) continue;
                pq.add(new Pair(nnode,nt));
            }
        }
        return ans;
    }
}