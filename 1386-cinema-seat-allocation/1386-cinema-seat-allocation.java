// class Solution {
//     public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
//         boolean[][]seat=new boolean[n][10];
//         Set<Integer>set=new HashSet<>();
//         for(int[]rs:reservedSeats){
//             seat[rs[0]-1][rs[1]-1]=true;
//             set.add(rs[0]-1);
//         } 
//         int[][]block={{1,2,3,4},{3,4,5,6},{5,6,7,8}};
//         int ans=(n-set.size())*2;
//         for(int a:set){
//             for(int[]b:block){
//                 if(seat[a][b[0]] || seat[a][b[1]] || seat[a][b[2]] || seat[a][b[3]]) continue;
//                 ans++;
//                 seat[a][b[0]]=true;
//                 seat[a][b[1]]=true;
//                 seat[a][b[2]]=true;
//                 seat[a][b[3]]=true;
//             }
//         }
//         return ans;
//     }
// }
class Solution {
    public int maxNumberOfFamilies(int n, int[][] reservedSeats) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int[] rs : reservedSeats) {
            if (!map.containsKey(rs[0] - 1))
                map.put(rs[0] - 1, new HashSet<>());
            map.get(rs[0] - 1).add(rs[1] - 1);
        }
        int[][] block = { { 1, 2, 3, 4 }, { 3, 4, 5, 6 }, { 5, 6, 7, 8 } };
        int ans = (n - map.size()) * 2;
        for (int a : map.keySet()) {
            Set<Integer> tset = map.get(a);
            for (int[] b : block) {
                if (tset.contains(b[0]) || tset.contains(b[1]) || tset.contains(b[2]) || tset.contains(b[3]))
                    continue;
                ans++;
                tset.add(b[0]);
                tset.add(b[1]);
                tset.add(b[2]);
                tset.add(b[3]);
            }
        }
        return ans;
    }
}