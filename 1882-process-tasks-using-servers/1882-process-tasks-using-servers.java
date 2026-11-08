class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {      
        int m=tasks.length,n=servers.length;
        PriorityQueue<int[]>av=new PriorityQueue<>((a,b)->{     //idx,swt
            if(a[1]==b[1]) return Integer.compare(a[0],b[0]);
            return Integer.compare(a[1],b[1]);
        });
        PriorityQueue<int[]>uav=new PriorityQueue<>((a,b)->Integer.compare(a[2],b[2])); //idx,swt,time
        for(int i=0;i<n;i++){
            av.offer(new int[]{i,servers[i]});
        }
        int[]ans=new int[m];
        int t=0;
        for(int i=0;i<m;i++){
            if(t<i) t=i;
            if(av.isEmpty()) t=uav.peek()[2];
            while(!uav.isEmpty() && uav.peek()[2]<=t){
                int[]a=uav.poll();
                av.offer(new int[]{a[0],a[1]});
            }
            int[]a=av.poll();
            ans[i]=a[0];
            uav.offer(new int[]{a[0],a[1],t+tasks[i]});
        }
        return ans;
    }
}