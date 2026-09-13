// class Solution {
    // class Pair {
    //     int x;
    //     int y;

    //     Pair(int x, int y) {
    //         this.x = x;
    //         this.y = y;
    //     }

    //     @Override
    //     public boolean equals(Object obj) {
    //         if (this == obj) return true;
    //         if (!(obj instanceof Pair)) return false;

    //         Pair p = (Pair) obj;
    //         return this.x == p.x && this.y == p.y;
    //     }

    //     @Override
    //     public int hashCode() {
    //         return 31 * x + y;
    //     }
    // }
//     public int largestOverlap(int[][] img1, int[][] img2) {
//         Set<Pair>set1=new HashSet<>();
//         Set<Pair>set2=new HashSet<>();
//         int n=img1.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(img1[i][j]==1)set1.add(new Pair(i,j));
//                 if(img2[i][j]==1)set2.add(new Pair(i,j));
//             }
//         }
//         int ans=0;
//         for(Pair p1:set1){
//             int x1=p1.x;
//             int y1=p1.y;
//             for(Pair p2:set2){
//                 int x2=p2.x;
//                 int y2=p2.y;
//                 int dx=x2-x1;
//                 int dy=y2-y1;
//                 int c=0;
//                 for(Pair p3:set1){
//                     if(set2.contains(new Pair(p3.x+dx,p3.y+dy))) c++;
//                 }
//                 ans=Math.max(ans,c);
//             }
//         }
//         return ans;
//     }
// }
// class Solution {
//     public int largestOverlap(int[][] img1, int[][] img2) {
//         List<int[]>l1=new ArrayList<>();
//         List<int[]>l2=new ArrayList<>();
//         List<int[]>diff=new ArrayList<>();
//         int n=img1.length;
//         for(int i=0;i<n;i++){
//             for(int j=0;j<n;j++){
//                 if(img1[i][j]==1)l1.add(new int[]{i,j});
//                 if(img2[i][j]==1)l2.add(new int[]{i,j});
//             }
//         }
//         int ans=0;
//         for(int[] p1:l1){
//             int x1=p1[0];
//             int y1=p1[1];
//             for(int[] p2:l2){
//                 int x2=p2[0];
//                 int y2=p2[1];
//                 diff.add(new int[]{x2-x1,y2-y1});
//             }
//         }
//         int c;
//         for(int[]p:diff){
//             int x=p[0],y=p[1];
//             c=0;
//             for(int[] p1:l1){
//                 int nx=x+p1[0],ny=y+p1[1];
//                 if(nx<0 || ny<0 || nx>=n || ny>=n) continue;
//                 if(img2[nx][ny]==1) c++;
//             }
//             ans=Math.max(ans,c);
//         }
//         return ans;
//     }
// }
class Solution {
    class Pair {
        int x;
        int y;

        Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Pair)) return false;

            Pair p = (Pair) obj;
            return this.x == p.x && this.y == p.y;
        }

        @Override
        public int hashCode() {
            return 31 * x + y;
        }
    }
    public int largestOverlap(int[][] img1, int[][] img2) {
        List<int[]>l1=new ArrayList<>();
        List<int[]>l2=new ArrayList<>();
        Map<Pair,Integer>diff=new HashMap<>();
        int n=img1.length;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                if(img1[i][j]==1)l1.add(new int[]{i,j});
                if(img2[i][j]==1)l2.add(new int[]{i,j});
            }
        }
        int ans=0;
        for(int[] p1:l1){
            int x1=p1[0];
            int y1=p1[1];
            for(int[] p2:l2){
                int x2=p2[0];
                int y2=p2[1];
                diff.put(new Pair(x2-x1,y2-y1),diff.getOrDefault(new Pair(x2-x1,y2-y1),0)+1);
            }
        }
        for(var d:diff.values()){
            ans=Math.max(ans,d);
        }
        return ans;
    }
}