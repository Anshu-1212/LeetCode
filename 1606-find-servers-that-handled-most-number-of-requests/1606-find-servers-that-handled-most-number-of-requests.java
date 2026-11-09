class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int n=load.length;
        PriorityQueue<int[]>use=new PriorityQueue<>((a,b)->Integer.compare(a[1],b[1])); //sno,time
        TreeSet<Integer>av=new TreeSet<>();  //sno
        for(int i=0;i<k;i++) av.add(i);
        int[]ans=new int[k];
        List<Integer>sans=new ArrayList<>();
        int t=0,mx=-1;
        for(int i=0;i<n;i++){
            t=arrival[i];
            while(!use.isEmpty() && use.peek()[1]<=t) av.add(use.poll()[0]);
            if(av.isEmpty()) continue;
            int a=-1;
            if(av.ceiling(i%k)!=null) a=av.ceiling(i%k);
            else a=av.first();
            ans[a]++;
            if(mx<ans[a]){
                mx=ans[a];
                sans=new ArrayList<>();
                sans.add(a);
            }
            else if(mx==ans[a]) sans.add(a);
            av.remove(a);
            use.add(new int[]{a,t+load[i]});
        }
        return sans;
    }
}